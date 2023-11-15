package lab7.ex4;

import lab7.ex4.model.Student;
import lab7.ex4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Ex4Application implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(Ex4Application.class, args);
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
		Student s2=new Student(2L,"Bl",33,"abc123@gmail.com",7.0);
		Student s3=new Student(3L,"Cl",22,"abc321@gmail.com",7.0);
		this.studentService.save(s1);
		this.studentService.save(s2);
		this.studentService.save(s3);
		showStudent();

		System.out.println("List of students age greater than 20:");
		List<Student> yc1 = studentService.findByAgeGreaterThan(20);
		yc1.forEach(System.out::println);
		System.out.println();

		System.out.println("List of students have ielts score is 7.0:");
		List<Student> yc2 = studentService.findByScore(7.0);
		yc2.forEach(System.out::println);
		System.out.println();

		System.out.println("List of students have name containing 'A':");
		List<Student> yc3 = studentService.findByNameContaining("A");
		yc3.forEach(System.out::println);

	}
}
