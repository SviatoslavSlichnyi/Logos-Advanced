package ua.lviv.lgs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {

    List<Student> findByCourse(int course);

    List<Student> findByLastNameAndFirstName(String lastName, String firstName);

    List<Student> findByLastNameLike(String lastName);

    @Query("select s from Student s where s.course = ?1 and s.firstName = ?2 and s.lastName = ?3")
    Optional<Student> findCustomStudent(int course, String firstName, String lastName);
}
