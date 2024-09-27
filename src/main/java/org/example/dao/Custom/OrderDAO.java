package org.example.dao.Custom;

import org.example.dao.CrudDAO;
import org.example.entity.OrderEntity;
import org.hibernate.Session;

public interface OrderDAO extends CrudDAO<OrderEntity> {
    boolean savedata(OrderEntity orderEntity, Session session);
}
