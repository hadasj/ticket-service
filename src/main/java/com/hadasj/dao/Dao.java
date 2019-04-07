package com.hadasj.dao;

import java.util.Optional;

public interface Dao<T> {
    /**
     * @param record new entity to persist
     */
    void insert(T record);

    /**
     * @return last entity
     */
    Optional<T> getLast();

    /**
     * @return first entity
     */
    Optional<T> getFirst();

    /**
     * delete entity by id
     */
    void delete(long id);

    /**
     * @return next id from sequence
     */
    long next();
}
