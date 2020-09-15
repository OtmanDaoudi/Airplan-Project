package GUIs.LoginScreen.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class paymentScreenController
{
    @FXML
    Stage window;
    @FXML
    Button paymentScreenController;
    @FXML
    TextField first_textfield;
    public void validate_infos()
    {
        window.close();
    }
    public void setWindow(Stage window)
    {
        this.window = window;
    }
}
