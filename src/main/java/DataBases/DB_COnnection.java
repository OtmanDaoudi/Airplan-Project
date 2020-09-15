package DataBases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_COnnection {

    public static Connection connection() {
        Connection conn = null;

//        ========MYSQL
        try {
            // db parameters
            String url = "jdbc:sqlite:Plane.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQL has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}