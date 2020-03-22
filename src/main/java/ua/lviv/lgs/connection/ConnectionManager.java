package ua.lviv.lgs.connection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static Logger log = Logger.getLogger(ConnectionManager.class);

    private final static String USER_NAME = "user";
    private final static String USER_PASSWORD = "1111";
    private final static String URL = "jdbc:mysql://localhost/i_shop";

    private static Connection connection;

    private ConnectionManager() {
    }

    public static Connection openConnection() {
        log.info("open connection");
        if (connection != null) {
            return connection;
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
                return connection;
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("Failed to create connection");
                e.printStackTrace();
            }
            throw new RuntimeException("Failed to create connection");
        }
    }

    public static void closeConnection() {
        log.info("close connection");
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
