package org.loose.fis.sre.test.java.Controllers;


import javafx.scene.control.TextField;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loose.fis.sre.controllers.AddItemController;
import org.loose.fis.sre.services.ItemsService;
import org.testfx.framework.junit.ApplicationTest;

import static junit.framework.TestCase.assertEquals;

public class AddItemControllerTest extends ApplicationTest {
    private AddItemController controller;

    @BeforeClass
    public static void setupClass(){
        ItemsService.setPath("src/main/java/org/loose/fis/sre/test/resources/shoppingItems.json");
    }

    @Before
    public void setUp(){
        controller = new AddItemController();
        controller.itemTextField = new TextField();
        controller.priceTextField = new TextField();
    }

    @Test
    public void addItem(){
        controller.priceTextField.setText("10");
        controller.itemTextField.setText("item");

        controller.addButton();

        assertEquals(1,ItemsService.getItems().size());
    }

    @After
    public void clean(){
        ItemsService.getItems().clear();
        ItemsService.writeItems();
    }
}
