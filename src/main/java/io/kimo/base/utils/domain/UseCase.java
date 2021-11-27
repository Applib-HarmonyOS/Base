package io.kimo.base.utils.domain;

/**
 * UseCase interface
 *
 * @param <R> usecase
 */
public interface UseCase<R> {

    /**
     * perform
     *
     * @return r
     * @throws Exception value
     */
    R perform() throws Exception;

    /**
     * onError
     */
    void onError();
}
