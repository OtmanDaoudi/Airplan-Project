package GUIs.LoginScreen;

import GUIs.LoginScreen.Controllers.paymentScreenController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class paymentScreen
{
    public paymentScreen() throws IOException {
        Stage window = new Stage();
        Image icon = new Image("images/icons/icon.png");
        window.getIcons().add(icon);
        window.setTitle("Payment");
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Interfaces/paymentScreen.fxml"));
        Parent root = loader.load();

        paymentScreenController paymentScreenController = loader.getController();
        paymentScreenController.setWindow(window);

        window.setScene(new Scene(root));
        window.initModality(Modality.APPLICATION_MODAL);

        window.show();
    }
}

