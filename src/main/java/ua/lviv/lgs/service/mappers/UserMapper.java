package ua.lviv.lgs.service.mappers;

import ua.lviv.lgs.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    private static UserMapper instance;

    public static UserMapper getInstance() {
        if (instance == null) {
            instance = new UserMapper();
        }
        return instance;
    }

    public User getUser(ResultSet result) throws SQLException {
        Integer userId = result.getInt("id");
        String email = result.getString("email");
        String firstName = result.getString("first_name");
        String lastName = result.getString("last_name");
        String role = result.getString("role");
        String password = result.getString("password");
        User user = new User(userId, email, firstName, lastName, role, password);
        return user;
    }
}
