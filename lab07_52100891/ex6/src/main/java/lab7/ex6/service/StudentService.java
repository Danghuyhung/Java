package lab7.ex6.service;

import lab7.ex6.model.Student;

import java.util.List;

public interface StudentService {
    public Iterable<Student> getAllStudents();
    public Student getStudent(long id) throws Exception;
    public void deleteStudent(long id);
    public Student save(Student student);

}
