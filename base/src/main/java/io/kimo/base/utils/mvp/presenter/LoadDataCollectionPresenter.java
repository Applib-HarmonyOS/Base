package io.kimo.base.utils.mvp.presenter;


import io.kimo.base.utils.domain.BaseMapper;
import io.kimo.base.utils.domain.Callback;
import io.kimo.base.utils.domain.Entity;
import io.kimo.base.utils.domain.usecase.LoadCollectionUseCase;
import io.kimo.base.utils.mvp.BasePresenter;
import io.kimo.base.utils.mvp.Model;
import io.kimo.base.utils.mvp.component.LoadDataCollectionComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * LoadDataCollectionPresenter
 *
 * @param <E>
 * @param <M>
 */
public class LoadDataCollectionPresenter<E extends Entity, M extends Model> extends BasePresenter<LoadDataCollectionComponent<M>> {
    /**
     * mExecutor
     */
    protected Executor mExecutor;
    /**
     * mUseCase
     */
    protected LoadCollectionUseCase<E> mUseCase;
    /**
     * mMapper
     */
    protected BaseMapper<E, M> mMapper;
    /**
     * mLoadedCollection
     */
    protected List<E> mLoadedCollection = new ArrayList<>();

    /**
     * LoadDataCollectionPresenter
     *
     * @param component LoadDataCollectionComponent
     * @param mapper    BaseMapper
     * @param useCase   LoadCollectionUseCase
     * @param executor  Executor
     */
    public LoadDataCollectionPresenter(LoadDataCollectionComponent<M> component, BaseMapper<E, M> mapper, LoadCollectionUseCase<E> useCase, Executor executor) {
        super(component);
        this.mMapper = mapper;
        this.mUseCase = useCase;
        this.mExecutor = executor;
    }

    @Override
    public void createComponent() {
        super.createComponent();

        mComponent.showProgress();

        mUseCase.setCallback(new Callback<List<E>>() {
            @Override
            public void onSuccess(List<E> result) {

                mLoadedCollection = result;

                if (result.isEmpty()) {
                    mComponent.hideProgress();
                    mComponent.showEmpty();
                } else {
                    mComponent.hideProgress();
                    mComponent.renderCollection(mMapper.toModels(result));
                    mComponent.showComponent();
                }
            }

            @Override
            public void onError(String error) {
                mComponent.hideProgress();
                mComponent.showRetry(error);
                mComponent.showFeedback("Try again");
            }
        });

        mExecutor.execute(mUseCase);
    }

    @Override
    protected void hideAllComponents() {
        mComponent.hideComponent();
        mComponent.hideProgress();
        mComponent.hideEmpty();
        mComponent.hideRetry();
    }

    @Override
    public void destroyComponent() {
        mComponent.clearCollection();
    }
}
