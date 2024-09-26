package org.example.dao.Custom;

import org.example.dao.CrudDAO;
import org.example.entity.ItemEntity;

import java.util.List;

public interface ItemDAO extends CrudDAO<ItemEntity> {
    void deletebyid(String code);

    List<String> getid();

    ItemEntity getdata(String value);
}
