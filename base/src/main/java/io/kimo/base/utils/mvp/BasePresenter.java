package io.kimo.base.utils.mvp;

import io.kimo.base.Base;

/**
 * BasePresenter
 *
 * @param <V>
 */
public abstract class BasePresenter<V extends Base.Component> implements Base.Presenter {
    /**
     * mComponent
     */
    protected V mComponent;

    /**
     * BasePresenter
     *
     * @param component V
     */
    public BasePresenter(V component) {
        this.mComponent = component;
    }

    @Override
    public void createComponent() {
        hideAllComponents();
    }

    /**
     * hideAllComponents
     */
    protected abstract void hideAllComponents();
}
