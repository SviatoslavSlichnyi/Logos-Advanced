package ua.lgs.lessons.ls02_JDBC;

import ua.lgs.lessons.ls02_JDBC.crud.connection.ConnectionManager;
import ua.lgs.lessons.ls02_JDBC.crud.entity.Employee;
import ua.lgs.lessons.ls02_JDBC.crud.repository.EmployeeRepository;
import ua.lgs.lessons.ls02_JDBC.crud.repository.impl.EmployeeRepositoryImpl;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (Connection connection = ConnectionManager.createConnection()) {
            EmployeeRepository repository = new EmployeeRepositoryImpl(connection);

            //write | create
//            Employee employee = new Employee("Myhaylo", "Black");
//            repository.save(employee);

            //read
//            Employee gottenEmployee = repository.read(2);
//            System.out.println(gottenEmployee);

            //update
            Employee employee = new Employee();
            employee.setId(3);
            repository.update(employee);


            //findAll
//            List<Employee> employeeList = repository.findAll();
//            System.out.println("\nlist of employees:");
//            employeeList.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
