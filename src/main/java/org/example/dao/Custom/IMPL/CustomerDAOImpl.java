package org.example.dao.Custom.IMPL;

import config.FactoryConfiguration;
import org.example.dao.Custom.CustomerDAO;
import org.example.entity.CustomerEntity;
import org.example.entity.ItemEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {


    @Override
    public void save(CustomerEntity customerEntity) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customerEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(CustomerEntity entity) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM customerentity WHERE id = :id").setParameter("id", entity.getID())
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void update(CustomerEntity entity) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public CustomerEntity search(String id) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        CustomerEntity customerEntity = session.get(CustomerEntity.class, id);

        transaction.commit();
        session.close();
        System.out.println(customerEntity.getID());

        return customerEntity;

    }

    @Override
    public List<CustomerEntity> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<CustomerEntity> query = session.createQuery("from CustomerEntity ");
        List<CustomerEntity> clist = query.list();

        return clist;
    }

    @Override
    public List<String> getid() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<String> query = session.createQuery("select ID from CustomerEntity", String.class);
        List<String> clist = query.list();
        session.close();

        return clist;
    }

    @Override
    public String getname(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<String> query = session.createQuery("select name from CustomerEntity where id =:id ").setParameter("id",id);
        String name = query.getSingleResult();
        session.close();

        return name;
    }

    @Override
    public CustomerEntity getdata(String cid) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<CustomerEntity> query = session.createQuery("from CustomerEntity where ID =:id ").setParameter("id",cid);
        CustomerEntity item = query.getSingleResult();
        session.close();

        return item;
    }
}
