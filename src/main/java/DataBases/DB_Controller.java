package DataBases;

import GUIs.LoginScreen.popupScreen;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DB_Controller {
    public static void Load(ObservableList<Person> obsPerson,ObservableList<Ticket> obsTicket) {
        Connection con = DB_COnnection.connection();
        Statement stmt;
        ResultSet Rs;

        try {
            stmt = con.createStatement();
            Rs = stmt.executeQuery("select * from Logindata;");
            while (Rs.next()) {
                Person data = new Person(
                        Rs.getString("Username"),
                        Rs.getString("Password")
                );
                obsPerson.add(data);

            }

            Rs = stmt.executeQuery("select * from ticketdata;");
            while (Rs.next()) {
                Ticket ticket = new Ticket(
                        Rs.getString("Username"),
                        Rs.getString("Company"),
                        Rs.getString("Full_Name"),
                        Rs.getString("Start_Airport"),
                        Rs.getString("End_Airport"),
                        Rs.getString("Seat_ID"),
                        Rs.getString("Seat_Class"),
                        Rs.getString("TakingoffDate"),
                        Rs.getString("contry"),
                        Rs.getString("city"),
                        Rs.getString("flight_date"),
                        Rs.getString("reservation_date"),
                        Rs.getString("cost"),
                        Rs.getString("end_city")
                );
                obsTicket.add(ticket);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void InsertDataTabTicket(String username, Ticket ticket){
        Connection con = DB_COnnection.connection();
        Statement stmt = null;
        ResultSet Rs = null;
        try {
            stmt = con.createStatement();
            if (CheckLogin(username,"",2)) {

                stmt.executeUpdate("INSERT INTO ticketdata ( Username, Company, Full_Name, Start_Airport, End_Airport, Seat_ID, Seat_Class, TakingoffDate, contry, city, flight_date, reservation_date, cost, end_city) Values " +
                        "(  '" + ticket.getUsername() +
                        "', '" + ticket.getCompany() +
                        "', '" + ticket.getFullName() +
                        "', '" + ticket.getStartAirport() +
                        "', '" + ticket.getEndAirport() +
                        "', '" + ticket.getSeatID() +
                        "', '" + ticket.getSeatClass() +
                        "', '" + ticket.getTakingoffDate() +
                        "', '" + ticket.getContry() +
                        "', '" + ticket.getCity() +
                        "', '" + ticket.getFlight_date() +
                        "', '" + ticket.getReservation_date() +
                        "', '" + ticket.getCost() +
                        "', '" + ticket.getEnd_city() +
                        "');");
            } else {
                ERROR_Data();
            }


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    static public void insertDatatabLogindata(String username, String password){
        Connection con = DB_COnnection.connection();
        Statement stmt = null;
        ResultSet Rs = null;

        try {
            stmt = con.createStatement();
            if (CheckLogin(username,password,1)) {
                stmt.executeUpdate("INSERT INTO Logindata (Username, Password) Values " +
                        "('" + username +
                        "', '" + password +
                        "');");
                popupScreen pop = new popupScreen("successfully registred");
            }
            else ERROR_Data();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
    static public boolean CheckLogin(String Username, String Password, int choice){
        if(choice == 1){
            Connection con = DB_COnnection.connection();
            Statement stmt;
            ResultSet Rs;
            try {
                stmt = con.createStatement();
                Rs = stmt.executeQuery("select Username from \"Logindata\" where Username=\""+Username+
                        "\"and Password=\""+Password+"\";");
                if(!Rs.next()) return true;
                else {
                    con.close();
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (choice == 2){
            Connection con = DB_COnnection.connection();
            Statement stmt;
            ResultSet Rs;

            try {
                stmt = con.createStatement();
                Rs = stmt.executeQuery("select Username from ticketdata where username=\""+Username+"\";");
                if(!Rs.next()) return true;
                else {
                    con.close();
                    return false;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static String ReturnCurrentUser(String username){
        if(!CheckLogin(username,"",2)){
            Connection con = DB_COnnection.connection();
            ResultSet Rs = null;
            try {
                Statement stmt = con.createStatement();
                Rs = stmt.executeQuery("select Seat_ID from ticketdata where username=\""+username+"\"");
                return Rs.getString(1);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "Not found";
    }

    public static  String[] ReturnAllSeatsIDs(){
        Connection con = DB_COnnection.connection();
        try {
            Statement stmt = con.createStatement();
            ResultSet Rs = stmt.executeQuery("select Seat_ID from ticketdata;");
            ArrayList<String> str = new ArrayList<>();
            while (Rs.next()){
                str.add(Rs.getString("Seat_ID"));
            }
            return str.toArray(new String[str.size()]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new String[0];
    }

    static void ERROR_Data() throws IOException {
        popupScreen pop = new popupScreen("User already exists");
    }

    public static String[] ReturnAllSeatsIDs(String starting_airport, String end_airport) throws SQLException { //overload
        Connection connection = DB_COnnection.connection();
        final String query = "SELECT * FROM ticketdata WHERE Start_Airport=? AND End_Airport=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,starting_airport);
        preparedStatement.setString(2,end_airport);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String> result = new ArrayList<>();
        while(resultSet.next())
        {
            result.add(resultSet.getString("Seat_ID"));
        }
        connection.close();
        return result.toArray(new String[result.size()]);
    }
    public static String[] ReturnUsersAirports(String username) throws SQLException {
        Connection connection = DB_COnnection.connection();
        final String query = "SELECT Start_Airport,End_Airport FROM ticketdata WHERE Username=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        String[] result = new String[2];
        if(resultSet.next())
        {
            result[0] = resultSet.getString("Start_Airport");
            result[1] = resultSet.getString("End_Airport");
        }
        connection.close();
        return result;
    }


    public static void main(String[] args) throws SQLException {
        String a[] = DB_Controller.ReturnAllSeatsIDs("Cairo International Airport","Orly Airport");
        for(String data : a)
        {
            System.out.println(data);
        }
    }
}




