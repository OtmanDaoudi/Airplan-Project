package GUIs.LoginScreen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupScreen
{
    Stage window = new Stage();
    public  SignupScreen() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/SignupScreen.fxml"));  //this could throw an error
        window.setTitle("AirePlane Project");

        Image icon = new Image("images/icons/icon.png");
        window.getIcons().add(icon);

        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(new Scene(root, 550, 270));
        window.resizableProperty().setValue(false);
        window.show();
    }
}
