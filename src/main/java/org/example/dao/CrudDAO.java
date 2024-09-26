package org.example.dao;

import org.example.entity.CustomerEntity;

public interface CrudDAO <T> extends SuperDAO{
    void save(T Entity);

    void delete(T entity);

    void update(T entity);

    T search(String id);


}
