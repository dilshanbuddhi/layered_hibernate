package org.example.bo.custom.IMPL;

import org.example.bo.custom.CustomerBo;
import org.example.dao.Custom.CustomerDAO;
import org.example.dao.DAOFactory;
import org.example.dto.CustomerDTO;
import org.example.entity.CustomerEntity;

import java.util.ArrayList;
import java.util.List;

public class CustometBOImpl implements CustomerBo {
    CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public void save(CustomerDTO i) {
        customerDAO.save(new CustomerEntity(i.getID(),i.getName(),i.getName(), i.getTeli()));
    }

    @Override
    public void delete(CustomerDTO i) {
        customerDAO.delete(new CustomerEntity(i.getID(),i.getName(),i.getName(),i.getTeli()));
    }

    @Override
    public void update(CustomerDTO i) {
        customerDAO.update(new CustomerEntity(i.getID(),i.getName(),i.getName(),i.getTeli()));

    }

    @Override
    public CustomerDTO searchbyid(String id) {
         CustomerEntity e = customerDAO.search(id);
        return new CustomerDTO(e.getID(),e.getName(),e.getAddress(),e.getTeli());
    }

    @Override
    public ArrayList<CustomerDTO> getAll() {
        ArrayList<CustomerDTO> cList= new ArrayList<>();
        List<CustomerEntity> en = customerDAO.getAll();

        for (CustomerEntity e: en
             ) {
            cList.add(new CustomerDTO(e.getID(),e.getName(),e.getAddress(),e.getTeli()));

        }

        return cList;
    }

    @Override
    public List<String> getcids() {
        List<String> list = customerDAO.getid();
        return list;
    }

    @Override
    public List<String> getiids() {
        return null;
    }

    @Override
    public String getname(String id) {
        String name = customerDAO.getname(id);
        return name;

    }


}
