package ua.lviv.lgs.magazine.repository.mapper;

import ua.lviv.lgs.magazine.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public static final UserMapper userMapper = new UserMapper();

    private UserMapper() {}

    public static UserMapper getInstance() {
        return userMapper;
    }

    public User getUser(ResultSet result) throws SQLException {
        Integer userId = result.getInt("id");
        String email = result.getString("email");
        String password = result.getString("password");
        String firstName = result.getString("first_name");
        String lastName = result.getString("last_name");
        String role = result.getString("role");
        User user = new User(userId, email, password, firstName, lastName, role);
        return user;
    }
}
