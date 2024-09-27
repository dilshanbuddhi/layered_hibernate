package org.example.dao.Custom.IMPL;

import config.FactoryConfiguration;
import org.example.dao.Custom.OrderDAO;
import org.example.entity.OrderEntity;
import org.hibernate.Session;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public void save(OrderEntity Entity) {

    }

    @Override
    public void delete(OrderEntity entity) {

    }

    @Override
    public void update(OrderEntity entity) {

    }

    @Override
    public OrderEntity search(String id) {
        return null;
    }

    @Override
    public boolean savedata(OrderEntity orderEntity, Session session) {
        boolean issaved = false;
        try{
            session.save(orderEntity);
/*
            transaction.commit();
*/
            issaved=true;

        }catch (Exception e){
            System.out.println("wade aulak");
        }
            return issaved;
    }
}
