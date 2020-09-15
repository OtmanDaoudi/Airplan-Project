package GUIs.LoginScreen.Controllers;

import DataBases.DB_Controller;
import GUIs.LoginScreen.AireplaneScreen;
import GUIs.LoginScreen.NewPopScreen;
import GUIs.LoginScreen.SignupScreen;
import GUIs.LoginScreen.popupScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginScreenController
{
    @FXML
    Button login_button,signup_button;
    @FXML
    TextField username_input;
    @FXML
    PasswordField password_input;
    public void Login() throws Exception {
        //validate the data from the data base and check uuser name and password
        DB_Controller DataBaseBridge = new DB_Controller();
            if(!DataBaseBridge.CheckLogin(username_input.getText(),password_input.getText(),1)) //if the user exits
            {
                if(!DB_Controller.CheckLogin(username_input.getText(),"",2))   //if the user has already reserved
                {
                    Stage to_be_closed = (Stage) login_button.getScene().getWindow();
                    to_be_closed.close();
                    AireplaneScreen aireplaneScreen = new AireplaneScreen(username_input.getText());
                    String[] temp = DB_Controller.ReturnUsersAirports(username_input.getText());
                    for(String ID: DB_Controller.ReturnAllSeatsIDs(temp[0],temp[1])) //mark reserved seats
                    {
                        aireplaneScreen.getController().Mark_Seat(ID,"images/seats/transparent/dark_seat.png");
                    }
                    aireplaneScreen.getController().Mark_Seat(DB_Controller.ReturnCurrentUser(username_input.getText()),"images/seats/transparent/red_seat.png");
                }
                else
                {
                    Stage to_be_closed = (Stage) login_button.getScene().getWindow();
                    to_be_closed.close();
                    NewPopScreen newPopScreen = new NewPopScreen(username_input.getText());
                }
            }
            else
            {
                //if the username and the password are incorrect
                popupScreen pop = new popupScreen("Invalid Info");
        }
    }
    public void signup() throws IOException
    {
        SignupScreen signupScreen = new SignupScreen();
    }
}
