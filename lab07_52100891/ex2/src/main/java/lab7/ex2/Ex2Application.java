package lab7.ex2;

import lab7.ex2.model.Student;
import lab7.ex2.service.StudentService;
import lab7.ex2.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Ex2Application implements CommandLineRunner {
	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(Ex2Application.class, args);
	}
	private void showStudent(){
		List<Student> studentList= (List<Student>) this.studentService.getAllStudents();
		for (Student student:studentList){
			System.out.println(student);
		}
	}

	@Override
	public void run(String... args){
		Student s1=new Student(1L,"Al",18,"abc@gmail.com",9.0);
		Student s2=new Student(2L,"Bl",33,"abc123@gmail.com",4.0);
		Student s3=new Student(3L,"Cl",22,"abc321@gmail.com",5.5);
		this.studentService.save(s1);
		this.studentService.save(s2);
		this.studentService.save(s3);
		showStudent();
		s1.setScore(7.5);
		System.out.println("After update:");
		this.studentService.save(s1);
		showStudent();
		this.studentService.deleteStudent(1L);
		System.out.println("After deleting students: ");
		showStudent();
	}
}
