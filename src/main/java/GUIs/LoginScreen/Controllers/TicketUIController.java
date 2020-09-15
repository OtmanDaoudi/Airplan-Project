package GUIs.LoginScreen.Controllers;
import DataBases.Ticket;
import javafx.fxml.FXML;
import javafx.scene.text.Text;


public class TicketUIController {

    @FXML
    private Ticket ticket;

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    @FXML
    private Text Company;

    @FXML
    private Text Flight;

    @FXML
    private Text Date;

    @FXML
    private Text Time;

    @FXML
    private Text From;

    @FXML
    private Text TO;

    @FXML
    private Text Class;

    @FXML
    private Text Seat;

    @FXML
    private Text Owner;

    @FXML
    private Text Company_r;

    @FXML
    private Text Flighr_r;

    @FXML
    private Text Date_r;

    @FXML
    private Text Time_r;

    @FXML
    private Text From_r;

    @FXML
    private Text To_r;

    @FXML
    private Text Class_r;

    @FXML
    private Text Seat_r;

    public void insertInfo(Ticket ticket){
        Company.setText(ticket.getCompany());
        Company.setText(ticket.getCompany());
        Time.setText(ticket.getTakingoffDate());
        From.setText(ticket.getStartAirport());
        TO.setText(ticket.getEndAirport());
        Class.setText(ticket.getSeatClass());
        Seat.setText(ticket.getSeatID());
        Owner.setText(ticket.getFullName());
        Company_r.setText(Company.getText());
        Date.setText(ticket.getTakingoffDate());
        Flighr_r.setText(Flight.getText());
        Date_r.setText(Date.getText());
        Time_r.setText(Time.getText());
        From_r.setText(From.getText());
        To_r.setText(TO.getText());
        Class_r.setText(Class.getText());
        Seat_r.setText(Seat.getText());
    }

}
