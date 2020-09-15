package GUIs.LoginScreen;

import GUIs.LoginScreen.Controllers.AireplaneScreenController;
import GUIs.LoginScreen.Controllers.InfoScreenController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class InfoScreen
{
    Stage window = new Stage();

    public InfoScreen(String current_user, String seat_id, String seat_type, String company, AireplaneScreenController controller, String contry, String city, String flight_date , String start_airport, String end_city, String endairport,String cost) throws IOException {
        window.setTitle("Reservation");

        Image icon = new Image("images/icons/icon.png");
        window.getIcons().add(icon);

        int randomNum = ThreadLocalRandom.current().nextInt(100, 300 + 1);
        cost = String.valueOf(randomNum);

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Interfaces/InfoScreen.fxml"));
        Parent root = loader.load();
        InfoScreenController infoScreenController = loader.getController();
        infoScreenController.setSeat_type(seat_type);
        infoScreenController.setSeatid_input(seat_id);
        infoScreenController.setCity(city);
        infoScreenController.setContry(contry);
        infoScreenController.setCompany(company);
        infoScreenController.setFlight_date(flight_date);
        infoScreenController.setStartAirport(start_airport);
        infoScreenController.setEnd_city(end_city);
        infoScreenController.setEndairport(endairport);
        infoScreenController.getTotalCost_label().setText(cost+"$");


        infoScreenController.returnCheckbox_of_start_time().getItems().addAll("00:00","03:00","18:30","15:30","10:10");
        infoScreenController.returnCheckbox_of_start_time().setValue("00:00");



        infoScreenController.getUsername_textfield().setText(current_user);
        infoScreenController.setController(controller);


        window.setScene(new Scene(root));
        window.resizableProperty().setValue(false);
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();
    }

}
