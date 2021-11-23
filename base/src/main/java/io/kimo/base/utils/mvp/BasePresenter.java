package io.kimo.base.utils.mvp;

import io.kimo.base.Base;

public abstract class BasePresenter<V extends Base.Component> implements Base.Presenter {

    protected V mComponent;

    public BasePresenter(V component) {
        this.mComponent = component;
    }

    @Override
    public void createComponent() {
        hideAllComponents();
    }

    protected abstract void hideAllComponents();
}
