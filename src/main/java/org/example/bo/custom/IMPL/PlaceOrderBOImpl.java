package org.example.bo.custom.IMPL;

import config.FactoryConfiguration;
import org.example.bo.custom.PlaceOrder;
import org.example.dao.Custom.CustomerDAO;
import org.example.dao.Custom.OrderDAO;
import org.example.dao.DAOFactory;
import org.example.entity.CustomerEntity;
import org.example.entity.ItemEntity;
import org.example.entity.OrderEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrder {
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Order);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public void placeOrder(String cid, String oid, String iid, double prize, int qtyy, double tot, String des) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        CustomerEntity customer = customerDAO.getdata(cid);
        List<CustomerEntity>customerEntities = new ArrayList<>();
        customerEntities.add(customer);
        OrderEntity orderEntity = new OrderEntity(oid, tot, qtyy, customer);
        session.save(orderEntity);

        ItemEntity item = new ItemEntity(iid, des, prize, qtyy);
        session.update(item);

        transaction.commit();
    }
}
