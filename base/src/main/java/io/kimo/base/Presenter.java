package io.kimo.base;

/**
 * Presenter.
 */
public abstract class Presenter<V extends Base.Component> implements Base.Presenter {

    private V mComponent;

    /**
     * Presenter constructor.
     *
     * @param component V
     */
    public Presenter(V component) {
        this.mComponent = component;
        if (getComponent() == null) {
            throw new IllegalArgumentException("Component cannot be null");
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
