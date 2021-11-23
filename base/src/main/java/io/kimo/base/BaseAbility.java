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

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;

import java.lang.reflect.Field;

public abstract class BaseAbility<P extends Base.Presenter>
        extends AbilitySlice
        implements Base.Component<P> {

    private P mPresenter;

    @Override
    protected void onStart(Intent savedInstanceState) {
        super.onStart(savedInstanceState);

        setUIContent(getLayoutResource());
        mPresenter = injectDependencies();

        if(getPresenter() == null) {
            throw new IllegalArgumentException("You must inject the " +
                    "dependencies before retrieving the presenter");
        } else {
            mapUI(getCurComponentContainer(this));
            configureUI();
        }

        mPresenter.createComponent();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.destroyComponent();
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    public static Component getCurComponentContainer(AbilitySlice abilitySlice){
        try{
            Field uiContent = AbilitySlice.class.getDeclaredField("uiContent");
            uiContent.setAccessible(true);
            Object uiContentObj = uiContent.get(abilitySlice);

            Field curComponentContainer = uiContentObj.getClass().getSuperclass().
                    getDeclaredField("curComponentContainer");
            curComponentContainer.setAccessible(true);
            Object curComponentContainerObj = curComponentContainer.get(uiContentObj);

            return (Component) curComponentContainerObj;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
