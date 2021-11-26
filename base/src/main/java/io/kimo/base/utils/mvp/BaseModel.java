package io.kimo.base.utils.mvp;

/**
 * BaseModel
 */
public abstract class BaseModel implements Model {

    private long mModelId;

    /**
     * BaseModel
     */
    public BaseModel() {
        mModelId = System.currentTimeMillis();
    }

    @Override
    public long getModelId() {
        return mModelId;
    }
}