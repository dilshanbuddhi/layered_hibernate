package org.example.contraller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bo.BOFactory;
import org.example.bo.custom.CustomerBo;
import org.example.dto.CustomerDTO;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerFormContraller {
    public TextField idTXT;
    public TextField nameTXT;
    public TextField addressTXT;
    public TextField teliTXT;
    public TableView<CustomerDTO> customerTbl;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colTel;


    CustomerBo customerBo = (CustomerBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    public void initialize(){
        setCellVAlue();
        getAll();
    }

    private void setCellVAlue() {
        colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("teli"));
    }

    private void getAll() {
       ObservableList<CustomerDTO> customerlist= FXCollections.observableArrayList();
        ArrayList<CustomerDTO> clist = customerBo.getAll();
        for (CustomerDTO c: clist
             ) {
            customerlist.add(c);
        }
        System.out.println("sdf");
        System.out.println(customerlist);
        customerTbl.setItems(customerlist);
    }


    public void saveOnAction(ActionEvent actionEvent) {
        String id = idTXT.getText();
        String name = nameTXT.getText();
        String address = addressTXT.getText();
        int tel = Integer.parseInt(teliTXT.getText());
        System.out.println(id+name+address+tel);

        CustomerDTO customerDTO = new CustomerDTO(id, name, address, tel);
        customerBo.save(customerDTO);

        //l

    }



    public void deleteOnAction(ActionEvent actionEvent) {
        String id = idTXT.getText();
        String name = nameTXT.getText();
        String address = addressTXT.getText();
        int tel = Integer.parseInt(teliTXT.getText());
        System.out.println(id+name+address+tel);

        CustomerDTO customerDTO = new CustomerDTO(id, name, address, tel);
        customerBo.delete(customerDTO);
    }


    public void updateOnaction(ActionEvent actionEvent) {
        String id = idTXT.getText();
        String name = nameTXT.getText();
        String address = addressTXT.getText();
        int tel = Integer.parseInt(teliTXT.getText());
        System.out.println(id+name+address+tel);

        CustomerDTO customerDTO = new CustomerDTO(id, name, address, tel);
        customerBo.update(customerDTO);
    }

    public void searchOnAction(ActionEvent actionEvent) {
        String id = idTXT.getText();
        CustomerDTO customerDTO = customerBo.searchbyid(id);
        idTXT.setText(customerDTO.getID());
        nameTXT.setText(customerDTO.getName());
        addressTXT.setText(customerDTO.getAddress());
        teliTXT.setText(String.valueOf(customerDTO.getTeli()));
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) teliTXT.getScene().getWindow();
        stage.setScene(scene);
    }
}
