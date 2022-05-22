package org.loose.fis.sre.test.java.Controllers;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.junit.Before;
import org.junit.Test;
import org.loose.fis.sre.controllers.AdminController;
import org.loose.fis.sre.model.Item;
import org.loose.fis.sre.services.ItemsService;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class AdminControllerTest extends ApplicationTest {
    private AdminController controller;

    @Before
    public void setUp(){
        controller = new AdminController();
        controller.itemsTable = new TableView<>();
        controller.itemColumn = new TableColumn<>();
        controller.priceColumn = new TableColumn<>();
    }

    @Test
    public void deleteItem(){
        ItemsService.getItems().clear();
        Item i = new Item("name",10);
        ItemsService.getItems().add(i);
        controller.itemsTable.getSelectionModel().select(i);

        controller.deleteButton();

        assertEquals(0,ItemsService.getItems().size());
    }
}
