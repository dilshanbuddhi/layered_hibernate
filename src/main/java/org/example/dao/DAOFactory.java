package org.example.dao;

import org.example.dao.Custom.IMPL.CustomerDAOImpl;
import org.example.dao.Custom.IMPL.ItemDAOImpl;
import org.example.dao.Custom.IMPL.OrderDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER,ITEM,Order
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {

            case Order:
                return new OrderDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            default:
                return null;
        }
    }


}

