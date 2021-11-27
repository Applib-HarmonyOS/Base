package io.kimo.base.utils.domain.usecase;

import io.kimo.base.utils.Constant;
import io.kimo.base.utils.LogUtil;
import io.kimo.base.utils.domain.BaseUseCase;
import io.kimo.base.utils.domain.Callback;
import io.kimo.base.utils.domain.Entity;
import io.kimo.base.utils.domain.callback.SilentCallback;

import java.util.List;

/**
 * LoadCollectionUseCase.
 */
public abstract class LoadCollectionUseCase<E extends Entity> extends BaseUseCase<List<E>> {

    /**
     * LoadCollectionUseCase.
     */
    public LoadCollectionUseCase() {
        super(new SilentCallback() {
            @Override
            public void onSuccess(Object result) {
                LogUtil.info(Constant.TAG, Constant.Result);
            }

            @Override
            public void onError(String error) {
                LogUtil.info(Constant.TAG, error);
            }
        });
    }

    /**
     * setCallback.
     */
    public void setCallback(Callback<List<E>> callback) {
        this.mCallback = callback;
    }
}
