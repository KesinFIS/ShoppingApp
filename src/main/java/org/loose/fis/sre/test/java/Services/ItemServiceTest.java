package org.loose.fis.sre.test.java.Services;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loose.fis.sre.model.Item;
import org.loose.fis.sre.services.ItemsService;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class ItemServiceTest extends ApplicationTest {
    @BeforeClass
    public static void setupClass(){
        ItemsService.setPath("src/main/java/org/loose/fis/sre/test/resources/shoppingItems.json");
    }

    @Test
    public void loadWriteTest(){
        ItemsService.getItems().clear();
        ItemsService.getItems().add(new Item("item",10));
        ItemsService.writeItems();
        ItemsService.getItems().clear();
        ItemsService.loadItems();

        assertEquals(1,ItemsService.getItems().size());
    }

    @Test
    public void removeItem(){
        ItemsService.getItems().clear();
        ItemsService.writeItems();

        Item i = new Item("name",10);
        ItemsService.getItems().add(i);
        ItemsService.removeItem(i);

        assertEquals(0,ItemsService.getItems().size());
    }

    @AfterClass
    public static void clean(){
        ItemsService.getItems().clear();
        ItemsService.writeItems();
    }
}
