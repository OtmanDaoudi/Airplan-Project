package GUIs.LoginScreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginScreen extends Application {
    Stage window;
    public void start(Stage primaryStage) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/loginScreen.fxml"));
        window=primaryStage;

        //icon of the window
        Image icon = new Image("images/icons/icon.png");
        window.getIcons().add(icon);
        ////////////////////

        primaryStage.setTitle("AirePlane Project");
        primaryStage.setScene(new Scene(root, 600, 304));
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();
    }
    public void invoke_PLATFORM() throws IOException {
        Stage window1 = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/loginScreen.fxml"));

        //icon of the window
        Image icon = new Image("/images/icons/icon.png");
        window1.getIcons().add(icon);
        ////////////////////

        window1.setTitle("AirePlane Project");
        window1.setScene(new Scene(root, 600, 304));
        window1.resizableProperty().setValue(false);
        window1.show();
    }
    public void invoke()
    {
        launch();
    }
}
