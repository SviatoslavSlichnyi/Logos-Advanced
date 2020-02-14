package ua.lgs.lessons.ls02_JDBC.crud.repository.impl;

import ua.lgs.lessons.ls02_JDBC.crud.entity.Employee;
import ua.lgs.lessons.ls02_JDBC.crud.repository.EmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static final String CREATE = "INSERT INTO employee(first_name, last_name) VALUES (?, ?)";
    private static final String UPDATE_BY_ID = "UPDATE employee SET first_name = ?, last_name = ? WHERE id = ?";
    private static final String GET_BY_ID = "SELECT * FROM employee WHERE id = ?";
    private static final String GET_ALL = "SELECT * FROM employee";

    private Connection connection;

    public EmployeeRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Employee employee) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.execute();
        }
    }

    @Override
    public void update(Employee employee) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                GET_BY_ID,
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE
        )) {
            statement.setInt(1, employee.getId());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.first()) {
                resultSet.updateString("first_name", "SvS");
                resultSet.updateString("last_name", "White");
                resultSet.updateRow();
            } else {
                throw new NullPointerException("Employee with " + employee.getId() + " was not found");
            }

        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Employee read(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.first()) {
                int eid = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                return new Employee(eid, firstName, lastName);
            } else {
                throw new NullPointerException("resultSet returned null from database");
            }

        }
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            List<Employee> list = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                Employee employee = new Employee(id, firstName, lastName);
                list.add(employee);
            }

            return list;
        }
    }
}
