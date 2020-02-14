package ua.lgs.lessons.ls02_JDBC;

import java.sql.*;

public class Read {

    static final String URL = "jdbc:mysql://localhost:3306/demodb";
    static final String USER_NAME = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
