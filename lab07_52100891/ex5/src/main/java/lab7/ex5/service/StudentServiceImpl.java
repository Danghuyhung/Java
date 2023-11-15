package lab7.ex5.service;

import lab7.ex5.model.Student;
import lab7.ex5.repository.StudentRepository;
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
    public List<Student> ageGreaterThan(int age) {
        return studentRepository.ageGreaterThan(age);
    }

    @Override
    public List<Student> haveScore(double score) {
        return studentRepository.haveScore(score);
    }

    @Override
    public List<Student> nameContaining(String name) {
        return studentRepository.nameContaining(name);
    }


}
