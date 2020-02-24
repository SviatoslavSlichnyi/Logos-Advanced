package ua.lviv.lgs.magazine;

import ua.lviv.lgs.magazine.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionManager.openConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM i_shop.users");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("first_name"));
        }
        ConnectionManager.closeConnection();
    }
}
