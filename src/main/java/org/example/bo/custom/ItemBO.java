package org.example.bo.custom;

import org.example.bo.SuperBo;
import org.example.dto.ItemDTO;

import java.util.List;

public interface ItemBO extends SuperBo {
    void savedata(ItemDTO itemEntity);

    void deleteitem(String code);

    void updateItem(ItemDTO itemDTO);

    ItemDTO searchitem(String code);

    List<String> getiids();

    ItemDTO getdata(String value);
}
