package io.kimo.base;

import io.kimo.base.utils.Constant;

/**
 * Presenter.
 */
public abstract class Presenters<V extends Base.Component> implements Base.Presenter {

    private V mComponent;

    /**
     * Presenter constructor.
     *
     * @param component V
     */
    protected Presenters(V component) {
        this.mComponent = component;
        if (getComponent() == null) {
            throw new IllegalArgumentException(Constant.CAN_NOT_NULL);
        }
    }

    @Override
    public void destroyComponent() {
    }

    /**
     * getComponent.
     *
     * @return v
     */
    public V getComponent() {
        return mComponent;
    }
}
