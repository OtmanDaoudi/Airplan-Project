package GUIs.LoginScreen.Controllers;

import DataBases.DB_Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class SignupScreenController
{
    @FXML
    TextField username_input;
    @FXML
    PasswordField password_input;
    @FXML
    Button signup_button;
    public void signup() throws IOException {
        DB_Controller DataBaseBridge = new DB_Controller();
        DataBaseBridge.insertDatatabLogindata(username_input.getText(),password_input.getText());
        Stage to_be_closed = (Stage) username_input.getScene().getWindow();
        to_be_closed.close();
        //popupScreen pop = new popupScreen("successfully registred");
    }
}
