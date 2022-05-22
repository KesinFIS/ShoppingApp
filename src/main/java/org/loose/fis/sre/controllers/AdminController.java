package org.loose.fis.sre.controllers;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Item;
import org.loose.fis.sre.services.ItemsService;

import java.util.Objects;

public class AdminController {
    private static Item selected;

    @FXML
    TableView<Item> itemsTable;
    @FXML
    TableColumn<Item,String> itemColumn;
    @FXML
    TableColumn<Item,Integer> priceColumn;

    @FXML
    public void initialize(){
        ItemsService.loadItems();

        itemsTable.setItems(FXCollections.observableArrayList(ItemsService.getItems()));
        itemColumn.setCellValueFactory(new PropertyValueFactory<Item,String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Item,Integer>("price"));
    }

    @FXML
    public void backButton(){
        try{
            Stage primaryStage = (Stage)itemsTable.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Login.fxml"));
            primaryStage.setTitle("Login");
            primaryStage.setScene(new Scene(root,600,600));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void addButton(){
        try{
            Stage primaryStage = (Stage)itemsTable.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("AddItem.fxml")));
            primaryStage.setTitle("Add Item");
            primaryStage.setScene(new Scene(root,600,600));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void deleteButton(){
        Item toBeRemoved = itemsTable.getSelectionModel().getSelectedItem();
        ItemsService.removeItem(toBeRemoved);
        this.initialize();
    }

    @FXML
    public void editButton(){
        selected = itemsTable.getSelectionModel().getSelectedItem();

        try{
            Stage primaryStage = (Stage)itemsTable.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("EditItem.fxml"));
            primaryStage.setTitle("Edit Item");
            primaryStage.setScene(new Scene(root,600,600));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static Item getSelected() {
        return selected;
    }

    public static void setSelected(Item selected) {
        AdminController.selected = selected;
    }
}
