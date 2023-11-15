package lab7.ex3.repository;

import lab7.ex3.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
}
