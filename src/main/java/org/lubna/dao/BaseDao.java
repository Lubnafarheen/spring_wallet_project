package org.lubna.dao;

import org.lubna.exception.DataNotFoundException;

import java.util.Collection;
import java.util.Optional;

public interface BaseDao<T, R> {

    T create(T t);

    Optional<T> findById(R id);

    Collection<T> findAll();

    void remove(R id) throws DataNotFoundException;
}
