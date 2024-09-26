package org.example.bo.custom.IMPL;

import org.example.bo.custom.ItemBO;
import org.example.dao.Custom.ItemDAO;
import org.example.dao.DAOFactory;
import org.example.dto.ItemDTO;
import org.example.entity.ItemEntity;

import java.util.List;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public void savedata(ItemDTO e) {
        itemDAO.save(new ItemEntity(e.getCode(),e.getDescription(),e.getUnitPrice(),e.getQtyOnhand()));
    }

    @Override
    public void deleteitem(String code) {
        itemDAO.deletebyid(code);
    }

    @Override
    public void updateItem(ItemDTO e) {
        itemDAO.update(new ItemEntity(e.getCode(),e.getDescription(),e.getUnitPrice(),e.getQtyOnhand()));
    }

    @Override
    public ItemDTO searchitem(String code) {
        ItemEntity e = itemDAO.search(code);
        return new ItemDTO(e.getCode(),e.getDescription(),e.getUnitPrice(),e.getQtyOnhand());
    }

    @Override
    public List<String> getiids() {
        List<String> list = itemDAO.getid();
        return list;
    }

    @Override
    public ItemDTO getdata(String value) {
        ItemEntity e = itemDAO.getdata(value);
        return new ItemDTO(e.getCode(),e.getDescription(),e.getUnitPrice(),e.getQtyOnhand());
    }
}
