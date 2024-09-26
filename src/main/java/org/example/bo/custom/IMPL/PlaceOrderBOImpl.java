package org.example.bo.custom.IMPL;

import config.FactoryConfiguration;
import org.example.bo.custom.PlaceOrder;
import org.example.dao.Custom.CustomerDAO;
import org.example.dao.Custom.ItemDAO;
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
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public void placeOrder(String cid, String oid, String iid, double prize, int qtyy, double tot, String des, int qtOnHand) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        CustomerEntity customer = customerDAO.getdata(cid);
        //plleha kelinm get kara... mekedi mekenma hdla add kr
        List<CustomerEntity>customerEntities = new ArrayList<>();

        customerEntities.add(customer);
        OrderEntity orderEntity = new OrderEntity(oid, tot, qtyy, customer);
        System.out.println("order ek hadagththa");

        ItemEntity item = new ItemEntity(iid, des, prize, (qtOnHand-qtyy));

        //many to many nisa list eka get karan  ethnin ekkt add k
        orderEntity.getItemEntities().add(item);
        // ekt adala item eketh list eka aran ekma kra
        item.getOrders().add(orderEntity);


        //transaction part
        try{
            boolean isSaved = orderDAO.savedata(orderEntity);
            System.out.println(isSaved+"palaweni eka");
            System.out.println("order eka save");

            if (isSaved){
                boolean issaved2 = itemDAO.updatedata(item);
                System.out.println(issaved2+"dewani eka");
                System.out.println("item ekath save");
                transaction.commit();
            }else {
                transaction.rollback();
            }
        }catch (Exception e){
            transaction.rollback();
        }
        finally {
            session.close();
        }

    }
}
