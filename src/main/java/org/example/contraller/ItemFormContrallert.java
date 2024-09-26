package org.example.contraller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import org.example.bo.BOFactory;
import org.example.bo.custom.ItemBO;
import org.example.dto.ItemDTO;
import org.example.entity.ItemEntity;

public class ItemFormContrallert {
    public TextField codeTXT;
    public TextField priceTXT;
    public TextField desTXT;
    public TextField qtyTXT;
    public TableColumn colCode;
    public TableColumn colDes;
    public TableColumn colPrize;
    public TableColumn colQty;

    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEM);

    public void saveOnAction(ActionEvent actionEvent) {
        String code=codeTXT.getText();
        String des = desTXT.getText();
        double prize = Double.parseDouble(priceTXT.getText());
        int qty = Integer.parseInt(qtyTXT.getText());
        itemBO.savedata(new ItemDTO(code,des,prize,qty));
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String code = codeTXT.getText();
        itemBO.deleteitem(code);
    }

    public void updateOnaction(ActionEvent actionEvent) {
        String code=codeTXT.getText();
        String des = desTXT.getText();
        double prize = Double.parseDouble(priceTXT.getText());
        int qty = Integer.parseInt(qtyTXT.getText());

        itemBO.updateItem(new ItemDTO(code,des,prize,qty));

    }

    public void searchOnAction(ActionEvent actionEvent) {
        String code = codeTXT.getText();
        ItemDTO i = itemBO.searchitem(code);
        codeTXT.setText(i.getCode());
        desTXT.setText(i.getDescription());
        qtyTXT.setText(String.valueOf(i.getQtyOnhand()));
        priceTXT.setText(String.valueOf(i.getUnitPrice()));
    }


}
