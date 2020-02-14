package ua.lgs.lessons.ls02_JDBC.crud.connection;

import java.sql.*;

public class ConnectionManager {

    static final String URL = "jdbc:mysql://localhost:3306/demodb";

    static final String USER_NAME = "root";
    static final String PASSWORD = "root";

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        return connection;
    }
}
