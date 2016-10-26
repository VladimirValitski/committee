package com.valitski.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface Dao describe the main methods
 */
public interface Dao<T> {
    boolean create(T entity) throws SQLException;

    T read(int id) throws SQLException;

    List<T> update(T entity) throws SQLException;

    boolean delete(int id);
}
