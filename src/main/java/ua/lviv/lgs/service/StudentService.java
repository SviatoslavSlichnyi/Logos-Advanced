package ua.lviv.lgs.service;


import ua.lviv.lgs.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student create(Student student);

    Optional<Student> findById(Integer id);

    List<Student> findAll();

    void deleteById(Integer id);

    List<Student> findByCource(int cource);

    Student update(Student student);
}
