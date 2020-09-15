package GUIs.LoginScreen.Controllers;

import DataBases.DB_COnnection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ticketScreenController
{
    @FXML
    Label username,company,fullname,startairport,endairport,seatid,takingoffdate,contry,city,flightdate,reservationdate,cost,seatclass,endcity_label;
    private String Username;
    Stage window;


    public void exit()
    {
        window.close();
    }
    public void setWindow(Stage window) {
        this.window = window;
    }
    public void apply_patch_to_ticket(String Username)
    {
        //retrieving the data from the database
        System.out.println("user "+username);
        Connection connection = DB_COnnection.connection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ticketdata WHERE Username = ?");
            preparedStatement.setString(1,Username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                username.setText(resultSet.getString("Username"));
                company.setText(resultSet.getString("Company"));
                fullname.setText(resultSet.getString("Full_Name"));
                startairport.setText(resultSet.getString("Start_Airport"));
                username.setText(resultSet.getString("End_Airport"));
                endairport.setText(resultSet.getString("Seat_ID"));
                seatclass.setText(resultSet.getString("Seat_Class"));
                takingoffdate.setText(resultSet.getString("TakingoffDate"));
                contry.setText(resultSet.getString("contry"));
                city.setText(resultSet.getString("city"));
                flightdate.setText(resultSet.getString("flight_date"));
                reservationdate.setText(resultSet.getString("reservation_date"));
                cost.setText(resultSet.getString("cost"));
                endcity_label.setText(resultSet.getString("end_city"));
            }
            else
            {
                System.out.println("fail to retrieve data");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
}
