package DataBases;
import javafx.beans.property.SimpleStringProperty;

public class Person {

    private SimpleStringProperty Username;
    private SimpleStringProperty Password;

    public Person(String username,String password)  {
        this.Username = new SimpleStringProperty(username);
        this.Password = new SimpleStringProperty(password);
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

    public String getPassword() {
        return Password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password.set(password);
    }
}