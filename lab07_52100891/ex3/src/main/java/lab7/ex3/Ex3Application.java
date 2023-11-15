package lab7.ex3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lab7.ex3.model.Student;
import lab7.ex3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.List;
@SpringBootApplication
public class Ex3Application implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(Ex3Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student(1L,"Alex",18,"alex@stdtu.edu.vn",6.5);
		Student student2 = new Student(2L,"Bob",19,"bob@stdtu.edu.vn",7.0);
		Student student3 = new Student(3L,"Mary",18,"mary@stdtu.edu.vn",7.5);

		this.studentService.save(student1);
		this.studentService.save(student2);
		this.studentService.save(student3);
		student1.setScore(8.0);
		this.studentService.save(student1);
		this.studentService.deleteStudent(1L);
		System.out.println("After deleting students: ");

	}
}
