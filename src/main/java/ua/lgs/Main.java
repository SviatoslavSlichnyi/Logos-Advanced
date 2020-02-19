package ua.lgs;

import ua.lgs.crud.connection.ConnectionManager;
import ua.lgs.crud.entity.Employee;
import ua.lgs.crud.repository.EmployeeRepository;
import ua.lgs.crud.repository.impl.EmployeeRepositoryImpl;

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
            Employee empl = new Employee();
            empl.setId(3);
            repository.update(empl);


            //findAll
//            List<Employee> employeeList = repository.findAll();
//            System.out.println("\nlist of employees:");
//            employeeList.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
