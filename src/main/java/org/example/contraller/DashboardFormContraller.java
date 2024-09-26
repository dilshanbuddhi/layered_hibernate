package org.example.contraller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormContraller {
    public Label id;

    public void customerOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(getClass().getResource("/view/customer_form.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) id.getScene().getWindow();
        stage.setScene(scene);
    }

    public void ItemOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(getClass().getResource("/view/item_form.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) id.getScene().getWindow();
        stage.setScene(scene);
    }

    public void OrderOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(getClass().getResource("/view/placeOrder_form.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) id.getScene().getWindow();
        stage.setScene(scene);
    }
}
