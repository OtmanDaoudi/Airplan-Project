package GUIs.LoginScreen;

import GUIs.LoginScreen.Controllers.newPOPcontroller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class NewPopScreen
{
    Stage window = new Stage();
    public  NewPopScreen(String username) throws IOException {
        window.setTitle("AirePlane Project");

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Interfaces/newPOP.fxml"));
        Parent root = loader.load();
        newPOPcontroller newPOPcontroller = loader.getController();
        newPOPcontroller.setUsername(username);
        newPOPcontroller.setWindow(this.window);


        Image icon = new Image("images/icons/icon.png");
        window.getIcons().add(icon);

        window.setScene(new Scene(root));
        window.resizableProperty().setValue(false);
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();
    }
}
