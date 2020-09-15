package GUIs.LoginScreen;

import GUIs.LoginScreen.Controllers.ticketScreenController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ticketScreen
{
    Stage window;
    public ticketScreen(String username) throws IOException {
        window = new Stage();
        window.setTitle(username);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Interfaces/ticketScreen.fxml"));
        Parent root = loader.load();

        ticketScreenController ticketScreenController = loader.getController();
        ticketScreenController.setWindow(this.window);
        ticketScreenController.apply_patch_to_ticket(username);

        window.setScene(new Scene(root));
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.show();
    }
}
