package lab7.ex4.repository;

import lab7.ex4.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    List<Student> findByAgeGreaterThan(int age);
    List<Student> findByScore(double score);
    List<Student> findByNameContaining(String name);
}
