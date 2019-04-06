package com.hadasj.dao;

import com.hadasj.entity.Ticket;

import java.util.List;

public interface Dao<T> {
    /**
     * @param record new entity to persist
     */
    void insert(T record);

    /**
     * @return all entities
     */
    List<T> list();

    /**
     * @return get entity by id
     */
    T get(long id);

    /**
     * delete entity by id
     */
    void delete(long id);
}
