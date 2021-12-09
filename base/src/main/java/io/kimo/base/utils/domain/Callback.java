package io.kimo.base.utils.domain;

/**
 * Callback interface.
 */
public interface Callback<R> {

    /**
     * onSuccess
     *
     * @param result R
     */
    void onSuccess(R result);

    /**
     * onError
     *
     * @param error String
     */
    void onError(String error);
}
