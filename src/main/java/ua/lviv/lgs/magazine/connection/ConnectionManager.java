package ua.lviv.lgs.connection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private final static String USER_NAME = "user";
    private final static String USER_PASSWORD = "1111";
    private final static String URL = "jdbc:mysql://localhost/i_shop";

    private static Connection connection;

    private ConnectionManager() {
    }

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
        try {
            Class connectionClass = Class.forName("java.sql.Connection");
            Method method = connectionClass.getDeclaredMethod("close");
            method.invoke(connection);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
