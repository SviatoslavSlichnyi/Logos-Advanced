package ua.lgs.crud.repository;

import ua.lgs.crud.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {

    void save(Employee employee) throws SQLException;

    void update(Employee employee) throws SQLException;

    void delete(int id);

    Employee read(int id) throws Exception;

    List<Employee> findAll() throws SQLException;
}
