package io.kimo.base.utils.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseMapper.
 */
public abstract class BaseMapper<E, M> {

    public abstract M toModel(E entity);

    public abstract String serializeModel(M model);

    public abstract M deserializeModel(String serializedModel);

    /**
     * toModels.
     *
     * @param entities List.
     * @return list
     */
    public List<M> toModels(List<E> entities) {
        List<M> models = new ArrayList<>();

        for (E e : entities) {
            models.add(toModel(e));
        }

        return models;
    }

    /**
     * serializeModels.
     *
     * @param models List.
     * @return list
     */
    public List<String> serializeModels(List<M> models) {
        List<String> serializedModels = new ArrayList<>();

        for (M model : models) {
            serializedModels.add(serializeModel(model));
        }

        return serializedModels;
    }

    /**
     * deserializeModels.
     *
     * @param serializedModels List.
     * @return list
     */
    public List<M> deserializeModels(List<String> serializedModels) {
        List<M> deserializedModels = new ArrayList<>();

        for (String serializedModel : serializedModels) {
            deserializedModels.add(deserializeModel(serializedModel));
        }

        return deserializedModels;
    }
}
