package org.loose.fis.sre.test.java.Controllers;

import javafx.scene.control.ChoiceBox;
import org.junit.Before;
import org.junit.Test;
import org.loose.fis.sre.controllers.SelectSizeController;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class SelectSizeControllerTest extends ApplicationTest {
    private SelectSizeController controller;

    @Before
    public void setUp(){
        controller = new SelectSizeController();
        controller.choiceBox = new ChoiceBox();
    }

    @Test
    public void setSize(){
        controller.choiceBox.setValue("46");

        controller.okButton();

        assertEquals("46", controller.choiceBox.getValue().toString());
    }
}
