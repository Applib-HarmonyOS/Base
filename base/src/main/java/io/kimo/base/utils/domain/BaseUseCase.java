package io.kimo.base.utils.domain;

import io.kimo.base.utils.Constant;
import ohos.eventhandler.EventHandler;
import ohos.eventhandler.EventRunner;

/**
 * BaseUseCase.
 */
public abstract class BaseUseCase<T> implements UseCase<T>, Runnable {

    public Callback<T> mCallback;

    /**
     * mErrorReason string
     */
    protected String mErrorReason = Constant.Something_Wrong;

    /**
     * mMainThread EventHandler
     */
    protected EventHandler mMainThread = new EventHandler(EventRunner.getMainEventRunner());

    /**
     * BaseUseCase constructor
     *
     * @param mCallback Callback
     */
    public BaseUseCase(Callback<T> mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    public void run() {
        try {
            final T result = perform();
            mMainThread.postTask(() -> mCallback.onSuccess(result));
        } catch (Exception e) {
            mErrorReason = e.getMessage();
            onError();
        }
    }

    @Override
    public void onError() {
        mMainThread.postTask(() -> mCallback.onError(mErrorReason));
    }
}
