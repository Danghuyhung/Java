package lab7.ex5.service;

import lab7.ex5.model.Student;

import java.util.List;

public interface StudentService {
    public Iterable<Student> getAllStudents();
    public Student getStudent(long id) throws Exception;
    public void deleteStudent(long id);
    public Student save(Student student);
    List<Student> ageGreaterThan(int age);
    List<Student> haveScore(double score);
    List<Student> nameContaining(String name);
}
