package lab7.ex5.repository;

import lab7.ex5.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    @Query(value = "SELECT * FROM Student WHERE age > :age", nativeQuery = true)
    List<Student> ageGreaterThan(@Param("age") int age);
    @Query(value = "SELECT * FROM Student WHERE score = :score", nativeQuery = true)
    List<Student> haveScore(@Param("score") double score);
    @Query(value = "SELECT * FROM Student WHERE name like %:name%", nativeQuery = true)
    List<Student> nameContaining(@Param("name") String name);
}
