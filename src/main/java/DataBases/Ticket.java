package DataBases;

import javafx.beans.property.SimpleStringProperty;

public class Ticket {

    private SimpleStringProperty Username;
    private SimpleStringProperty Company;
    private SimpleStringProperty FullName;
    private SimpleStringProperty StartAirport;
    private SimpleStringProperty EndAirport;
    private SimpleStringProperty SeatID;
    private SimpleStringProperty SeatClass;
    private SimpleStringProperty TakingoffDate;
    private SimpleStringProperty contry;
    private SimpleStringProperty city;
    private SimpleStringProperty flight_date;
    private SimpleStringProperty reservation_date;
    private SimpleStringProperty cost;
    private SimpleStringProperty end_city;

    public Ticket(String username, String company, String fullName, String startAirport, String endAirport, String seatID, String seatClass, String takingoffDate,
                  String contry,String city,String flight_date,String reservation_date,String cost ,String end_city) {
        this.Username = new SimpleStringProperty(username);
        this.Company = new SimpleStringProperty(company);
        this.FullName = new SimpleStringProperty(fullName);
        this.StartAirport = new SimpleStringProperty(startAirport);
        this.EndAirport = new SimpleStringProperty(endAirport);
        this.SeatID = new SimpleStringProperty(seatID);
        this.SeatClass = new SimpleStringProperty(seatClass);
        this.TakingoffDate = new SimpleStringProperty(takingoffDate);
        this.contry = new SimpleStringProperty(contry);
        this.city = new SimpleStringProperty(city);
        this.flight_date = new SimpleStringProperty(flight_date);
        this.reservation_date = new SimpleStringProperty(reservation_date);
        this.cost = new SimpleStringProperty(cost);
        this.end_city = new SimpleStringProperty(end_city);
    }

    public String getUsername() {
        return Username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username.set(username);
    }

    public String getCompany() {
        return Company.get();
    }

    public SimpleStringProperty companyProperty() {
        return Company;
    }

    public void setCompany(String company) {
        this.Company.set(company);
    }

    public String getFullName() {
        return FullName.get();
    }

    public SimpleStringProperty fullNameProperty() {
        return FullName;
    }

    public void setFullName(String fullName) {
        this.FullName.set(fullName);
    }

    public String getStartAirport() {
        return StartAirport.get();
    }

    public SimpleStringProperty startAirportProperty() {
        return StartAirport;
    }

    public void setStartAirport(String startAirport) {
        this.StartAirport.set(startAirport);
    }

    public String getEndAirport() {
        return EndAirport.get();
    }

    public SimpleStringProperty endAirportProperty() {
        return EndAirport;
    }

    public void setEndAirport(String endAirport) {
        this.EndAirport.set(endAirport);
    }

    public String getSeatID() {
        return SeatID.get();
    }

    public SimpleStringProperty seatIDProperty() {
        return SeatID;
    }

    public void setSeatID(String seatID) {
        this.SeatID.set(seatID);
    }

    public String getSeatClass() {
        return SeatClass.get();
    }

    public SimpleStringProperty seatClassProperty() {
        return SeatClass;
    }

    public void setSeatClass(String seatClass) {
        this.SeatClass.set(seatClass);
    }

    public String getTakingoffDate() {
        return TakingoffDate.get();
    }

    public SimpleStringProperty takingoffDateProperty() {
        return TakingoffDate;
    }

    public void setTakingoffDate(String takingoffDate) {
        this.TakingoffDate.set(takingoffDate);
    }

    public String getContry() {
        return contry.get();
    }

    public SimpleStringProperty contryProperty() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry.set(contry);
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getFlight_date() {
        return flight_date.get();
    }

    public SimpleStringProperty flight_dateProperty() {
        return flight_date;
    }

    public void setFlight_date(String flight_date) {
        this.flight_date.set(flight_date);
    }

    public String getReservation_date() {
        return reservation_date.get();
    }

    public SimpleStringProperty reservation_dateProperty() {
        return reservation_date;
    }

    public void setReservation_date(String reservation_date) {
        this.reservation_date.set(reservation_date);
    }

    public String getCost() {
        return cost.get();
    }

    public SimpleStringProperty costProperty() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost.set(cost);
    }

    public String getEnd_city() {
        return end_city.get();
    }

    public SimpleStringProperty end_cityProperty() {
        return end_city;
    }

    public void setEnd_city(String end_city) {
        this.end_city.set(end_city);
    }
}