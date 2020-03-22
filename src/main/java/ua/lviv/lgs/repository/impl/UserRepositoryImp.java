package ua.lviv.lgs.repository.impl;

import org.apache.log4j.Logger;
import ua.lviv.lgs.connection.ConnectionManager;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.repository.UserRepository;
import ua.lviv.lgs.service.mappers.UserMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImp implements UserRepository {
    private final static String CREATE = "insert into users(`email`,`first_name`, `last_name`, `role`, `password`) values (?,?,?,?,?)";
    private final static String READ_BY_ID = "select * from users where id =?";
    private final static String READ_BY_EMAIL = "select * from users where email =?";
    private static String UPDATE_BY_ID = "update users set email=?, first_name = ?, last_name = ?, role=?  where id = ?";
    private static String DELETE_BY_ID = "delete from users where id=?";
    private static String READ_ALL = "select * from users";

    private Logger log = Logger.getLogger(UserRepositoryImp.class);
    private static UserRepository userRepository;
    private Connection connection;
    private UserMapper userMapper;
    public UserRepositoryImp() {
        this.connection = ConnectionManager.openConnection();
        this.userMapper = UserMapper.getInstance();
    }

    public static UserRepository getInstance() {
        if (userRepository != null) {
            return userRepository;
        }
        return new UserRepositoryImp();
    }

    @Override
    public User save(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            user.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findById(Integer id) {
        User user = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                user = userMapper.getUser(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public User update(User user) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setInt(5, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        PreparedStatement preparedStatement;
        List<User> userRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                userRecords.add(userMapper.getUser(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userRecords;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                log.debug("find user with email: " + email);
                user = userMapper.getUser(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

}
