package org.loose.fis.sre.controllers;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.loose.fis.sre.model.Item;

import java.util.ArrayList;

public class OrderPlacedController {
    @FXML
    private TableView<Item> tableView;
    @FXML
    private TableColumn<Item,String> itemColumn;
    @FXML
    private TableColumn<Item,Integer> priceColumn;
    @FXML
    private TableColumn<Item,String> sizeColumn;

    private ArrayList<Item> items;

    @FXML
    public void initialize(){
        items = ItemsController.getCartItems();

        tableView.setItems(FXCollections.observableArrayList(items));
        itemColumn.setCellValueFactory(new PropertyValueFactory<Item,String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Item,Integer>("price"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<Item,String>("size"));
    }
}
