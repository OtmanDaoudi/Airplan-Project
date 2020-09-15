package GUIs.LoginScreen;

import GUIs.LoginScreen.Controllers.AireplaneScreenController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class AireplaneScreen {
    Stage window = new Stage();
    AireplaneScreenController controller;
    public AireplaneScreen(String username,String company,String contry ,String city , String flight_date ,String starting_airport,String end_city , String endairport) throws IOException {
        window.setTitle("AirePlane Project");

        FXMLLoader loader =new  FXMLLoader(getClass().getClassLoader().getResource("Interfaces/Aireplane.fxml"));
        Parent root = loader.load();

        controller = loader.getController();
        controller.setCurrent_user(username);
        controller.setCompany(company);
        controller.setContry(contry);
        controller.setCity(city);
        controller.setFlight_date(flight_date);
        controller.setStart_airport(starting_airport);
        controller.setEnd_city(end_city);
        controller.setWindow(window);
        controller.apply_ticket_button();
        controller.setEndairport(endairport);


        Image icon = new Image("images/icons/icon.png");
        window.getIcons().add(icon);


        window.setScene(new Scene(root,647,398));
        window.resizableProperty().setValue(false);
        window.show();
    }

    public AireplaneScreen(String username) throws IOException  //made for peopol who are already registred
    {
        window.setTitle("AirePlane Project 2");

        FXMLLoader loader =new  FXMLLoader(getClass().getClassLoader().getResource("Interfaces/Aireplane.fxml"));
        Parent root = loader.load();

        controller = loader.getController();
        controller.setCurrent_user(username);
        controller.setWindow(window);
        controller.apply_ticket_button();


        Image icon = new Image("images/icons/icon.png");
        window.getIcons().add(icon);


        window.setScene(new Scene(root,647,398));
        window.resizableProperty().setValue(false);
        window.show();
    }
    public AireplaneScreenController getController() {
        return controller;
    }
}

