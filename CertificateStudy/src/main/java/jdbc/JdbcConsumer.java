package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConsumer {

    private static JdbcConsumer jdbcConsumer;

    private final JdbcConnectionManager db;

    private JdbcConsumer() {
        db = new JdbcConnectionManager();
    }

    public static void main(String[] args) {
        JdbcConnectionManager jdbc = new JdbcConnectionManager();
        jdbc.loadDriver();
        jdbc.openConnection();

        System.out.println("before closing");
        jdbc.closeConnection();
    }

    public static JdbcConsumer getConsumer() {
        return jdbcConsumer == null
                ? new JdbcConsumer()
                : jdbcConsumer;
    }

    private void commitData() throws SQLException {

        Statement stmt = db.connection.createStatement();
        String query = "SELECT * FROM mytable";

        db.openConnection();

        ResultSet rs = stmt.executeQuery(query);



    }

}
