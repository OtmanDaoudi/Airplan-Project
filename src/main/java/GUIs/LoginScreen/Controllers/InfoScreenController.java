package GUIs.LoginScreen.Controllers;

import DataBases.DB_Controller;
import DataBases.Ticket;
import GUIs.LoginScreen.paymentScreen;
import GUIs.LoginScreen.popupScreen;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class InfoScreenController
{


    private String Company,StartAirport,contry,city,flight_date,end_city,endairport,cost;

    String companies[]={"Delta Air Lines","Frontier Airlines","Hawaiian Airlines","JetBlue Airways"};
    String start_airports[]={"Los Angeles International Airport","O'Hare International Airport","San Francisco International Airport","Logan International Airport"};
    String end_airports[]={"Detroit Metropolitan Airport","Philadelphia International Airport","Dubai Airport","Orly Airport"};
    String start_time[]={"00:00","03:00","18:30","15:30","10:10"};

    @FXML
    Label totalCost_label;
    @FXML
    AireplaneScreenController controller;
    @FXML
    TextField username_textfield;
    @FXML
    ChoiceBox strat_time_input;
    @FXML
    TextField fullname_input,seat_id_input,seattype_input;


    public void setSeat_type(String seat_type)
    {
        seattype_input.setText(seat_type);
    }
    public void setSeatid_input(String seatid_input)
    {
        seat_id_input.setText(seatid_input);
    }

    public ChoiceBox returnCheckbox_of_start_time()
    {
        return strat_time_input;
    }

    public void validate_Infos() throws IOException
    {
        Ticket ticket = new Ticket(username_textfield.getText(), Company,fullname_input.getText(),StartAirport,endairport
        ,seat_id_input.getText(),seattype_input.getText(),strat_time_input.getItems().get(strat_time_input.getSelectionModel().getSelectedIndex()).toString(),contry,city,flight_date
                ,new SimpleDateFormat("dd-MM-yyyy").format(new Date()),totalCost_label.getText(),end_city);

        DB_Controller DataBaseBridge = new DB_Controller();
        DataBaseBridge.InsertDataTabTicket(username_textfield.getText(),ticket);
        System.out.println("data added to the dataBase");

        controller.Mark_Seat(seat_id_input.getText(),"images/seats/transparent/red_seat.png");

        Stage to_be_closed = (Stage) username_textfield.getScene().getWindow();
        to_be_closed.close();
        new popupScreen("Your reservation has been submitted");
        controller.apply_ticket_button();
    }
    public void setController(AireplaneScreenController controller) {
        this.controller = controller;
    }
    public TextField getUsername_textfield()
    {
        return username_textfield;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFlight_date(String flight_date) {
        this.flight_date = flight_date;
    }

    public void setStartAirport(String startAirport) {
        StartAirport = startAirport;
    }

    public void setEnd_city(String end_city) {
        this.end_city = end_city;
    }

    public void setEndairport(String endairport) {
        this.endairport = endairport;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Label getTotalCost_label() {
        return totalCost_label;
    }

    public void payment() throws IOException {
        paymentScreen paymentScreen = new paymentScreen();
    }
}