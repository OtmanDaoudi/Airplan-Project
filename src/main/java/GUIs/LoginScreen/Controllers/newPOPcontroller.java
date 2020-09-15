package GUIs.LoginScreen.Controllers;

import DataBases.DB_Controller;
import GUIs.LoginScreen.AireplaneScreen;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class newPOPcontroller implements Initializable
{
    @FXML
    ChoiceBox<String> company_choicebox;
    @FXML
    ChoiceBox contry_choicebox;
    @FXML
    ChoiceBox startcity_choicebox;
    @FXML
    ChoiceBox<String> starting_airport_choicebox,endairport_choicebox;
    @FXML
    ChoiceBox<String> endcity_choicebox;
    @FXML
    DatePicker flightdate_choicebox;
    @FXML
    Stage window;
    private SimpleStringProperty end = new SimpleStringProperty();
    private String username;
    private String cities[] = {"New York","Los Angeles","washington","Marrakech","Casablanca","Tanger","London","Manchester","Liverpool"};

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        company_choicebox.getItems().addAll("Delta Air Lines","Frontier Airlines","Hawaiian Airlines","JetBlue Airways");
        company_choicebox.setValue("Delta Air Lines");

        contry_choicebox.getItems().addAll("USA","Morocco","UK");

        endcity_choicebox.getItems().addAll("Paris","Tokyo","Stockholm");

        endcity_choicebox.getSelectionModel().selectedItemProperty().addListener( (v,oldValue,newValue)->
        {
            if(endcity_choicebox.getSelectionModel().getSelectedItem().toString().equals("Paris"))
            {
                endairport_choicebox.getItems().clear();
                endairport_choicebox.getItems().addAll("Paris Airport-Le Bourget","Orly Airport","Issy-les-Moulineaux Heliport");
                endairport_choicebox.setValue("Paris Airport-Le Bourget");
            }
            else if(endcity_choicebox.getSelectionModel().getSelectedItem().toString().equals("Tokyo"))
            {
                endairport_choicebox.getItems().clear();
                endairport_choicebox.getItems().addAll("Narita International Airport","Haneda Airport","Ibaraki Airport");
                endairport_choicebox.setValue("Narita International Airport");
            }
            else
            {
                endairport_choicebox.getItems().clear();
                endairport_choicebox.getItems().addAll("Stockholm Arlanda Airport","Stockholm Bromma Airport","Stockholm Skavsta Airport");
                endairport_choicebox.setValue("Stockholm Arlanda Airport");
            }
        });
        endcity_choicebox.setValue("Paris");



        startcity_choicebox.getSelectionModel().selectedItemProperty().addListener( (v,oldValue,newValue)->
        {
            if(contry_choicebox.getSelectionModel().getSelectedIndex() == 0 && startcity_choicebox.getSelectionModel().getSelectedIndex()==0)
            {
                starting_airport_choicebox.getItems().clear();
                starting_airport_choicebox.getItems().addAll("John F. Kennedy International Airport","LaGuardia Airport","Newark Liberty International Airport");
                starting_airport_choicebox.setValue("John F. Kennedy International Airport");

            }
            else if(contry_choicebox.getSelectionModel().getSelectedIndex() == 0 && startcity_choicebox.getSelectionModel().getSelectedIndex()==1)
            {
                starting_airport_choicebox.getItems().clear();
                starting_airport_choicebox.getItems().addAll("Los Angeles International Airport","Hollywood Burbank Airport","Van Nuys Airport");
                starting_airport_choicebox.setValue("Los Angeles International Airport");
            }
            else if(contry_choicebox.getSelectionModel().getSelectedIndex() == 0 && startcity_choicebox.getSelectionModel().getSelectedIndex()==2)
            {
                starting_airport_choicebox.getItems().clear();
                starting_airport_choicebox.getItems().addAll("Ronald Reagan Washington National Airport","Signature Flight Support Airport","Airport Strategy Group");
                starting_airport_choicebox.setValue("Ronald Reagan Washington National Airport");

            }else if(contry_choicebox.getSelectionModel().getSelectedIndex() == 1 && startcity_choicebox.getSelectionModel().getSelectedIndex()==1)
            {
                starting_airport_choicebox.getItems().clear();
                starting_airport_choicebox.getItems().addAll("Casablanca Mohammed V International Airport");
                starting_airport_choicebox.setValue("Casablanca Mohammed V International Airport");

            }else if(contry_choicebox.getSelectionModel().getSelectedIndex() == 1 && startcity_choicebox.getSelectionModel().getSelectedIndex()==0)
            {
                starting_airport_choicebox.getItems().clear();
                starting_airport_choicebox.getItems().addAll("Marrakesh Menara Airport");
                starting_airport_choicebox.setValue("Marrakesh Menara Airport");

            }else if(contry_choicebox.getSelectionModel().getSelectedIndex() == 1 && startcity_choicebox.getSelectionModel().getSelectedIndex()==2)
            {
                starting_airport_choicebox.getItems().clear();
                starting_airport_choicebox.getItems().addAll("Tangier Ibn Battuta Airport");
                starting_airport_choicebox.setValue("Tangier Ibn Battuta Airport");

            }else if(contry_choicebox.getSelectionModel().getSelectedIndex() == 2 && startcity_choicebox.getSelectionModel().getSelectedIndex()==0)
            {
                starting_airport_choicebox.getItems().clear();
                starting_airport_choicebox.getItems().addAll("London City Airport","Heathrow Airport","London City Airport Jet Centre");
                starting_airport_choicebox.setValue("London City Airport");

            }else if(contry_choicebox.getSelectionModel().getSelectedIndex() == 2 && startcity_choicebox.getSelectionModel().getSelectedIndex()==2)
            {
                starting_airport_choicebox.getItems().clear();
                starting_airport_choicebox.getItems().addAll("Liverpool John Lennon Airport");
                starting_airport_choicebox.setValue("Liverpool John Lennon Airport");

            }else
            {
                starting_airport_choicebox.getItems().clear();
                starting_airport_choicebox.getItems().addAll("Manchester Airport");
                starting_airport_choicebox.setValue("Manchester Airport");

            }
        });

        contry_choicebox.getSelectionModel().selectedItemProperty().addListener( (v,oldValue,newValue)->
        {

            startcity_choicebox.getItems().clear();

            if(contry_choicebox.getSelectionModel().getSelectedIndex() == 0)
            {

                startcity_choicebox.getItems().addAll("New York","Los Algeles","washington");
                startcity_choicebox.setValue("New York");
            }
            else if(contry_choicebox.getSelectionModel().getSelectedIndex() == 1)
            {
                startcity_choicebox.getItems().addAll("Marrakech","Casablanca","Tanger");
                startcity_choicebox.setValue("Marrakech");
            }
            else
            {
                startcity_choicebox.getItems().addAll("London","Manchester","Liverpool");
                startcity_choicebox.setValue("London");
            }
        });
        contry_choicebox.setValue("USA");
    }
    public void validate() throws IOException, SQLException {
        window.close();
        AireplaneScreen aireplaneScreen = new AireplaneScreen(username,company_choicebox.getSelectionModel().selectedItemProperty().getValue(),
                contry_choicebox.getSelectionModel().selectedItemProperty().getValue().toString(),startcity_choicebox.getSelectionModel().selectedItemProperty().getValue().toString()
                ,flightdate_choicebox.getValue().toString(), starting_airport_choicebox.getSelectionModel().selectedItemProperty().getValue(),
                endcity_choicebox.getSelectionModel().selectedItemProperty().getValue(),endairport_choicebox.getValue());
        for(String ID: DB_Controller.ReturnAllSeatsIDs(starting_airport_choicebox.getValue(),endairport_choicebox.getValue())) //mark reserved seats
        {
            aireplaneScreen.getController().Mark_Seat(ID,"images/seats/transparent/dark_seat.png");
        }
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public void setWindow(Stage window)
    {
        this.window = window;
    }

}
