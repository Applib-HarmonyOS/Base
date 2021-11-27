package io.kimo.base.utils.domain;

/**
 * BaseEntity.
 */
public abstract class BaseEntity implements Entity {
    protected long mEntityId;

    /**
     * BaseEntity constructor
     */
    public BaseEntity() {
        mEntityId = System.currentTimeMillis();
    }

    @Override
    public long getEntityId() {
        return mEntityId;
    }
}
