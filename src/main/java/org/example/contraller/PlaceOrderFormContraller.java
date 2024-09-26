package org.example.contraller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bo.BOFactory;
import org.example.bo.custom.CustomerBo;
import org.example.bo.custom.ItemBO;
import org.example.bo.custom.PlaceOrder;
import org.example.dto.CustomerDTO;
import org.example.dto.ItemDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PlaceOrderFormContraller {
    CustomerBo customerBo = (CustomerBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEM);
    public TextField oidtxt;
    public TextField qty;

    public TextField name;
    public TextField totalTxt;
    public TextField destxt;
    public TextField unitprizeTxt;
    public TextField qtyOnhnadtxt;
    public ComboBox<String> cidCmb;
    public ComboBox <String>itemCMb;

    PlaceOrder placeOrder = (PlaceOrder) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PLACEORDER);

    public void initialize(){

        setCustomerCmb();
        setItemcmb();
    }

    private void setItemcmb() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        List<String> ilist = itemBO.getiids();
        System.out.println("ghjk");
        System.out.println(ilist);

        for (String id : ilist) {
            obList.add(id);
        }
        itemCMb.setItems(obList);
    }

    private void setCustomerCmb() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        List<String> clist = customerBo.getcids();

        for (String party : clist) {
            obList.add(party);
        }
        cidCmb.setItems(obList);
    }

    public void cidCmbOnAction(ActionEvent actionEvent) {

        String id = cidCmb.getValue();
        String nametxt = customerBo.getname(id);
        name.setText(nametxt);

    }

    public void itemCmbOnAction(ActionEvent actionEvent) {
        String value = itemCMb.getValue();
        ItemDTO i = itemBO.getdata(value);
        destxt.setText(i.getDescription());
        unitprizeTxt.setText(String.valueOf(i.getUnitPrice()));
        qtyOnhnadtxt.setText(String.valueOf(i.getQtyOnhand()));
    }

    public void placeOrderOnAction(ActionEvent actionEvent) {
        int qtOnHand = Integer.parseInt(qtyOnhnadtxt.getText());
        int qtyy = Integer.parseInt(qty.getText());
        double prize = Double.parseDouble(unitprizeTxt.getText());
        String oid = oidtxt.getText();
        String cid = cidCmb.getValue();
        String iid = itemCMb.getValue();
        String des = destxt.getText();

        double tot = qtyy*prize;
        System.out.println(tot);

        placeOrder.placeOrder(cid,oid,iid,prize,qtyy,tot,des,qtOnHand);

    }

    public void dashboardOnaction(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) totalTxt.getScene().getWindow();
        stage.setScene(scene);
    }
}
