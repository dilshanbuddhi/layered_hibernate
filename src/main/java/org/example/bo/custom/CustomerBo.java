package org.example.bo.custom;

import org.example.bo.SuperBo;
import org.example.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

public interface CustomerBo extends SuperBo {

    void save(CustomerDTO customerDTO);

    void delete(CustomerDTO i);

    void update(CustomerDTO customerDTO);

    CustomerDTO searchbyid(String id);

    ArrayList<CustomerDTO> getAll();

    List<String> getcids();

    List<String> getiids();

    String getname(String id);
}
