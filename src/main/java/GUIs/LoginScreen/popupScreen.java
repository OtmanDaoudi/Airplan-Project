package GUIs.LoginScreen;

import GUIs.LoginScreen.Controllers.popupScreenController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class popupScreen
{
    Stage window = new Stage();
    public popupScreen(String message) throws IOException {
        window.setTitle("Warning");
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Interfaces/popupScreen.fxml"));
        Parent root = loader.load();

        popupScreenController popupScreenController = loader.getController();

        Image icon = new Image("images/icons/icon.png");
        window.getIcons().add(icon);
        popupScreenController.getMessage().setText(message);
        popupScreenController.getClose_button().setOnAction(e->window.close());

        window.setScene(new Scene(root));
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();
    }
}
