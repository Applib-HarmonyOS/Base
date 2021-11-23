package io.kimo.base;

public abstract class Presenter<V extends Base.Component> implements Base.Presenter {

    private V mComponent;

    public Presenter(V component) {
        this.mComponent = component;
        if(getComponent() == null) {
            throw new IllegalArgumentException("Component cannot be null");
        }
    }

    @Override
    public void destroyComponent() {}

    public V getComponent() {
        return mComponent;
    }
}
