/*
 * Copyright (C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.kimo.base;

import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;

/**
 * BaseFraction.
 */
public abstract class BaseFraction<P extends Base.Presenter>
        extends Fraction
        implements Base.Component<P> {

    private P mPresenter;

    @Override
    public Component onComponentAttached(LayoutScatter inflater, ComponentContainer container, Intent savedInstanceState) {
        Component component = inflater.parse(getLayoutResource(), container, false);
        mPresenter = injectDependencies();

        if (getPresenter() == null) {
            throw new IllegalArgumentException("You must inject the " +
                    "dependencies before retrieving the presenter");
        } else {
            mapUI(component);
            configureUI();
        }

        return component;
    }

    @Override
    public void onActive() {
        super.onActive();
        mPresenter.createComponent();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.destroyComponent();
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }
}
