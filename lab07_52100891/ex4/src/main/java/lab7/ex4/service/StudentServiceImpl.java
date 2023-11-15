package lab7.ex4.service;

import lab7.ex4.model.Student;
import lab7.ex4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

   @Override
   public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }
   @Override
   public Student getStudent(long id) throws Exception {
       return studentRepository.findById(id).orElseThrow(()-> new Exception("Student not found"));
   }

   @Override
   public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
   @Override
   public Student save(Student student) {
       return studentRepository.save(student);
   }

    @Override
    public List<Student> findByAgeGreaterThan(int age) {
        return studentRepository.findByAgeGreaterThan(age);
    }

    @Override
    public List<Student> findByScore(double score) {
        return studentRepository.findByScore(score);
    }

    @Override
    public List<Student> findByNameContaining(String name) {
        return studentRepository.findByNameContaining(name);
    }
}
