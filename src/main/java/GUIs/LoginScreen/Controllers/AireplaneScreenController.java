package GUIs.LoginScreen.Controllers;

import DataBases.DB_COnnection;
import DataBases.DB_Controller;
import DataBases.Ticket;
import GUIs.LoginScreen.InfoScreen;
import GUIs.LoginScreen.LoginScreen;
import GUIs.LoginScreen.popupScreen;
import GUIs.LoginScreen.ticketScreen;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class AireplaneScreenController implements Initializable
{
    public Stage window;
    private String company,contry,city,flight_date,start_airport,end_city,endairport,cost;
    public  String current_user;

    @FXML
    Button saveticket_button;
    @FXML
    Button myticket_Button;
    @FXML
    ImageView A1,A2,A3,A4,A5,A6,A7,A8,A9,A10;
    @FXML
    ImageView B1,B2,B3,B4,B5,B6,B7,B8,B9,B10;
    @FXML
    ImageView C1,C2,C3,C4,C5,C6,C7,C8,C9,C10;
    @FXML
    ImageView D1,D2,D3,D4,D5,D6,D7,D8,D9,D10;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) //this function made to be ran right after the opning of the programme
    {
        myticket_Button.setDisable(true);   //lock the button
        saveticket_button.setDisable(true);
        System.out.println("reinit");


        A1.setOnMouseClicked(e-> reserve_selected_seat(A1.getId(),"Premuime seat"));
        A2.setOnMouseClicked(e-> reserve_selected_seat(A2.getId(),"Premuime seat"));
        A3.setOnMouseClicked(e-> reserve_selected_seat(A3.getId(),"First-Class seat"));
        A4.setOnMouseClicked(e-> reserve_selected_seat(A4.getId(),"First-Class seat"));
        A5.setOnMouseClicked(e-> reserve_selected_seat(A5.getId(),"Standar Seat"));
        A6.setOnMouseClicked(e-> reserve_selected_seat(A6.getId(),"Standar Seat"));
        A7.setOnMouseClicked(e-> reserve_selected_seat(A7.getId(),"Standar Seat"));
        A8.setOnMouseClicked(e-> reserve_selected_seat(A8.getId(),"Standar Seat"));
        A9.setOnMouseClicked(e-> reserve_selected_seat(A9.getId(),"Standar Seat"));
        A10.setOnMouseClicked(e-> reserve_selected_seat(A10.getId(),"Standar Seat"));

        B1.setOnMouseClicked(e-> reserve_selected_seat(B1.getId(),"Premuime seat"));
        B2.setOnMouseClicked(e-> reserve_selected_seat(B2.getId(),"Premuime seat"));
        B3.setOnMouseClicked(e-> reserve_selected_seat(B3.getId(),"First-Class seat"));
        B4.setOnMouseClicked(e-> reserve_selected_seat(B4.getId(),"First-Class seat"));
        B5.setOnMouseClicked(e-> reserve_selected_seat(B5.getId(),"Standar Seat"));
        B6.setOnMouseClicked(e-> reserve_selected_seat(B6.getId(),"Standar Seat"));
        B7.setOnMouseClicked(e-> reserve_selected_seat(B7.getId(),"Standar Seat"));
        B8.setOnMouseClicked(e-> reserve_selected_seat(B8.getId(),"Standar Seat"));
        B9.setOnMouseClicked(e-> reserve_selected_seat(B9.getId(),"Standar Seat"));
        B10.setOnMouseClicked(e-> reserve_selected_seat(B10.getId(),"Standar Seat"));

        C1.setOnMouseClicked(e-> reserve_selected_seat(C1.getId(),"Premuime seat"));
        C2.setOnMouseClicked(e-> reserve_selected_seat(C2.getId(),"Premuime seat"));
        C3.setOnMouseClicked(e-> reserve_selected_seat(C3.getId(),"First-Class seat"));
        C4.setOnMouseClicked(e-> reserve_selected_seat(C4.getId(),"First-Class seat"));
        C5.setOnMouseClicked(e-> reserve_selected_seat(C5.getId(),"Standar Seat"));
        C6.setOnMouseClicked(e-> reserve_selected_seat(C6.getId(),"Standar Seat"));
        C7.setOnMouseClicked(e-> reserve_selected_seat(C7.getId(),"Standar Seat"));
        C8.setOnMouseClicked(e-> reserve_selected_seat(C8.getId(),"Standar Seat"));
        C9.setOnMouseClicked(e-> reserve_selected_seat(C9.getId(),"Standar Seat"));
        C10.setOnMouseClicked(e-> reserve_selected_seat(C10.getId(),"Standar Seat"));

        D1.setOnMouseClicked(e-> reserve_selected_seat(D1.getId(),"Premuime seat"));
        D2.setOnMouseClicked(e-> reserve_selected_seat(D2.getId(),"Premuime seat"));
        D3.setOnMouseClicked(e-> reserve_selected_seat(D3.getId(),"First-Class seat"));
        D4.setOnMouseClicked(e-> reserve_selected_seat(D4.getId(),"First-Class seat"));
        D5.setOnMouseClicked(e-> reserve_selected_seat(D5.getId(),"Standar Seat"));
        D6.setOnMouseClicked(e-> reserve_selected_seat(D6.getId(),"Standar Seat"));
        D7.setOnMouseClicked(e-> reserve_selected_seat(D7.getId(),"Standar Seat"));
        D8.setOnMouseClicked(e-> reserve_selected_seat(D8.getId(),"Standar Seat"));
        D9.setOnMouseClicked(e-> reserve_selected_seat(D9.getId(),"Standar Seat"));
        D10.setOnMouseClicked(e-> reserve_selected_seat(D10.getId(),"Standar Seat"));
    }

    public boolean First_Not_In_Second(String first , String[] second)
    {
        for(String seat:second)
        {
            if(first.equals(seat)) return false;
        }
        return true;
    }


    public void reserve_selected_seat(String Seat_id,String Seat_type) {
        try
        {
            if(DB_Controller.ReturnCurrentUser(current_user).equals("Not found"))  //if the user hasn't reserved
            {
                if(First_Not_In_Second(Seat_id,DB_Controller.ReturnAllSeatsIDs(start_airport,endairport))) //nedd to be changed to return all empty seats from current flight
                {
                    InfoScreen infoScreen = new InfoScreen(current_user,Seat_id,Seat_type,company,this,contry,city,flight_date,start_airport,end_city,endairport,cost);
                }
                else
                {
                    popupScreen pop = new popupScreen("Selected Seat has been already reserved");
                }
            }
            else
            {
                popupScreen pop = new popupScreen("user has already reserved a seat");
            }

        }
        catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void setCurrent_user(String current_user) {
        this.current_user = current_user;
    }
    public void Mark_Seat(String Seat_id,String file)
    {
        switch(Seat_id)
        {
            case "A1" :   A1.setImage(new Image((file)));break;
            case "A2" :   A2.setImage(new Image((file)));break;
            case "A3" :   A3.setImage(new Image((file)));break;
            case "A4" :   A4.setImage(new Image((file)));break;
            case "A5" :   A5.setImage(new Image((file)));break;
            case "A6" :   A6.setImage(new Image((file)));break;
            case "A7" :   A7.setImage(new Image((file)));break;
            case "A8" :   A8.setImage(new Image((file)));break;
            case "A9" :   A9.setImage(new Image((file)));break;
            case "A10" :  A10.setImage(new Image((file)));break;

            case "B1" :   B1.setImage(new Image((file)));break;
            case "B2" :   B2.setImage(new Image((file)));break;
            case "B3" :   B3.setImage(new Image((file)));break;
            case "B4" :   B4.setImage(new Image((file)));break;
            case "B5" :   B5.setImage(new Image((file)));break;
            case "B6" :   B6.setImage(new Image((file)));break;
            case "B7" :   B7.setImage(new Image((file)));break;
            case "B8" :   B8.setImage(new Image((file)));break;
            case "B9" :   B9.setImage(new Image((file)));break;
            case "B10" :  B10.setImage(new Image((file)));break;

            case "C1" :   C1.setImage(new Image((file)));break;
            case "C2" :   C2.setImage(new Image((file)));break;
            case "C3" :   C3.setImage(new Image((file)));break;
            case "C4" :   C4.setImage(new Image((file)));break;
            case "C5" :   C5.setImage(new Image((file)));break;
            case "C6" :   C6.setImage(new Image((file)));break;
            case "C7" :   C7.setImage(new Image((file)));break;
            case "C8" :   C8.setImage(new Image((file)));break;
            case "C9" :   C9.setImage(new Image((file)));break;
            case "C10" :  C10.setImage(new Image((file)));break;

            case "D1" :   D1.setImage(new Image((file)));break;
            case "D2" :   D2.setImage(new Image((file)));break;
            case "D3" :   D3.setImage(new Image((file)));break;
            case "D4" :   D4.setImage(new Image((file)));break;
            case "D5" :   D5.setImage(new Image((file)));break;
            case "D6" :   D6.setImage(new Image((file)));break;
            case "D7" :   D7.setImage(new Image((file)));break;
            case "D8" :   D8.setImage(new Image((file)));break;
            case "D9" :   D9.setImage(new Image((file)));break;
            case "D10" :  D10.setImage(new Image((file)));break;

            default   :   break;
        }
    }

    public void setWindow(Stage window)
    {
        this.window = window;
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

    public void setCompany(String company) {
        this.company = company;
    }

    public void setStart_airport(String start_airport) {
        this.start_airport = start_airport;
    }
    public void exit() throws IOException {
        window.close();
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.invoke_PLATFORM();
    }
    public void my_ticket() throws IOException {
        ticketScreen ticketScreen = new ticketScreen(current_user);
    }
    public void apply_ticket_button()
    {
        System.out.println("unloking buttons");
        if(!DB_Controller.CheckLogin(current_user,"",2))
        {
            myticket_Button.setDisable(false);
            saveticket_button.setDisable(false);
            myticket_Button.setOnAction(e-> {
                        try {
                            my_ticket();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
            saveticket_button.setOnAction(e->
            {
                try {
                    save_ticket();
                } catch (IOException | SQLException ex) {
                    ex.printStackTrace();
                }
            });
        }
        else
        {
            myticket_Button.setDisable(true);
            System.out.println("else");
        }
    }

    public void setEnd_city(String end_city) {
        this.end_city = end_city;
    }

    public void setEndairport(String endairport) {
        this.endairport = endairport;
    }

    public void save_ticket() throws IOException, SQLException {
        Connection connection = DB_COnnection.connection();
        final String query = "SELECT * FROM ticketdata WHERE Username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,current_user);
        ResultSet resultSet = preparedStatement.executeQuery();
        Ticket ticket = new Ticket(
                resultSet.getString("Username"),
                resultSet.getString("Company"),
                resultSet.getString("Full_Name"),
                resultSet.getString("Start_Airport"),
                resultSet.getString("End_Airport"),
                resultSet.getString("Seat_ID"),
                resultSet.getString("Seat_Class"),
                resultSet.getString("TakingoffDate"),
                resultSet.getString("contry"),
                resultSet.getString("city"),
                resultSet.getString("flight_date"),
                resultSet.getString("reservation_date"),
                resultSet.getString("cost"),
                resultSet.getString("end_city")
        );


        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Interfaces/Ticket.fxml"));
        Parent root = loader.load();
        TicketUIController ticketUIController = loader.getController();
        ticketUIController.insertInfo(ticket);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));


        WritableImage wi = new WritableImage(1000, 390);
        WritableImage snapshot = root.snapshot(null, wi);

        BufferedImage bi =SwingFXUtils.fromFXImage((Image)snapshot, null);
        Image image = SwingFXUtils.toFXImage(bi, null);

        ImageView imageView = new ImageView(image);
        stage.setScene(new Scene(new VBox(imageView)));


        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Ticket");
        fileChooser.setInitialFileName("Ticket_" + new Date().getTime());
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("png", "*.png"));
        File output = fileChooser.showSaveDialog(window.getScene().getWindow());

        while (output == null)
            output = fileChooser.showSaveDialog(window.getScene().getWindow());
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", output);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
