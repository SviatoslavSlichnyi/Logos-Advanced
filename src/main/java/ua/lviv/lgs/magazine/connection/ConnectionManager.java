package ua.lviv.lgs.magazine.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager  {

    private final static String USER_NAME = "root";
    private final static String USER_PASSWORD = "root";
    private final static String URL = "jdbc:mysql://localhost/i_shop";

    private static Connection connection;

    private ConnectionManager() {}

    public static Connection openConnection() {

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
        Connection connection = ConnectionManager.openConnection();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Connection Exception");
            }
        }
    }

}
