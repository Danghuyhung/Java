package lab7.ex4.service;

import lab7.ex4.model.Student;

import java.util.List;

public interface StudentService {
    public Iterable<Student> getAllStudents();
    public Student getStudent(long id) throws Exception;
    public void deleteStudent(long id);
    public Student save(Student student);
    List<Student> findByAgeGreaterThan(int age);
    List<Student> findByScore(double score);
    List<Student> findByNameContaining(String name);
}
