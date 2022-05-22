package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;


import java.util.Objects;

public class SelectSizeController {
    private static String size = "36";

    public static String getSize() {
        return size;
    }

    public static void setSize(String size) {
        SelectSizeController.size = size;
    }

    @FXML
    public ChoiceBox choiceBox;

    @FXML
    public void initialize(){
        choiceBox.getItems().addAll("36","37","38","39","40");
        choiceBox.setValue("36");
    }

    @FXML
    public void backButton(){
        try{
            Stage primaryStage = (Stage)choiceBox.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("Items.fxml")));
            primaryStage.setTitle("Shop Page");
            primaryStage.setScene(new Scene(root,600,600));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void okButton(){
        size = choiceBox.getValue().toString();
        this.backButton();
    }
}
