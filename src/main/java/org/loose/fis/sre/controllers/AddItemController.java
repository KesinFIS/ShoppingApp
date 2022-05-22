package org.loose.fis.sre.controllers;

import org.loose.fis.sre.model.Item;
import org.loose.fis.sre.services.ItemsService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;


public class AddItemController {
    @FXML
    public
    TextField itemTextField;
    @FXML
    public
    TextField priceTextField;

    @FXML
    public void backButton(){
        try{
            Stage primaryStage = (Stage)itemTextField.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("StoreManagement.fxml")));
            primaryStage.setTitle("Admin Page");
            primaryStage.setScene(new Scene(root,600,600));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void addButton(){
        ItemsService.addItem(new Item(itemTextField.getText(),Integer.parseInt(priceTextField.getText())));
    }
}
