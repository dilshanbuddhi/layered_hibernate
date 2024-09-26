package org.example.dao.Custom;

import org.example.dao.CrudDAO;
import org.example.entity.CustomerEntity;

import java.util.List;

public interface CustomerDAO extends CrudDAO<CustomerEntity> {

    List<CustomerEntity> getAll();

    List<String> getid();

    String getname(String id);
}
