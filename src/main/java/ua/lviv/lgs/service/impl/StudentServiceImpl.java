package ua.lviv.lgs.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.lgs.entity.Student;
import ua.lviv.lgs.repository.StudentRepository;
import ua.lviv.lgs.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        List<Student> result = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(result::add);
        return result;
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findByCource(int cource) {
        return studentRepository.findByCourse(cource);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }
}
