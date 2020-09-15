package GUIs.LoginScreen.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class popupScreenController
{
    @FXML
    Button close_button;
    @FXML
    Label Message;

    public Button getClose_button() {
        return close_button;
    }

    public Label getMessage() {
        return Message;
    }
}