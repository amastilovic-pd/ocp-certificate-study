package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class JdbcConnectionManager {

    public static final Logger log = Logger.getLogger(JdbcConnectionManager.class.getName());
    Connection connection;

    public void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            log.info("error while loading driver " + e);
        }
    }

    public void openConnection() {
        try {                                         // protocol:subprotocol
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rekreativ", "root", "root");
            System.out.println("connected successfully");
        } catch (SQLException e) {
            log.info("error while opening connection " + e);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            log.info("error while closing connection " + e);
        }
    }

    private void usingResultSet() {
        String fetchData = "SELECT * FROM names";

        try (PreparedStatement ps = connection.prepareStatement(fetchData)) {
            ResultSet rs = ps.executeQuery(); // fetching data from statement
            rs.getObject("id");
            rs.getObject(1);
        } catch (SQLException e) {
            log.info("error while using prepared statement " + e);
        }
    }

    private void usingPreparedStatement() {
        String sql = "INSERT INTO names VALUES(?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, 25);
            ps.setString(2, "John");
            ps.setString(3, "Doe");

            boolean execute = ps.execute(); // returns boolean so we know if theres a resultset
            ps.executeBatch();
            int numOfChangedRows = ps.executeUpdate(); // returns number of changed rows

            log.info("number of changed rows " + numOfChangedRows);
        } catch (SQLException e) {
            log.info("error while using prepared statement " + e);
        }
    }
}
