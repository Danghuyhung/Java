package lab7.ex6;

import lab7.ex6.model.Student;
import lab7.ex6.repository.StudentPaging;
import lab7.ex6.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import java.util.List;

@SpringBootApplication
public class Ex6Application implements CommandLineRunner {
	@Autowired
	private StudentPaging studentPaging;
	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(Ex6Application.class, args);
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
		Student s4=new Student(4L,"Aka",56,"abc@gmail.com",3.0);
		Student s5=new Student(5L,"Da",35,"abc123@gmail.com",4.0);
		Student s6=new Student(6L,"Boo",21,"abc321@gmail.com",5.0);
		this.studentService.save(s1);
		this.studentService.save(s2);
		this.studentService.save(s3);
		this.studentService.save(s4);
		this.studentService.save(s5);
		this.studentService.save(s6);
		showStudent();

		System.out.println("\nList Student sorted:");
		List<Student> nameThenIelts = (List<Student>) studentPaging.findAll(Sort.by(Sort.Direction.DESC, "age").and(Sort.by("name").and(Sort.by("Score"))));
		nameThenIelts.forEach(System.out::println);

		System.out.println("\nList Student id between 3 and 4:");
		Pageable pageBetween3and4 = PageRequest.of(1, 2);
		Page<Student> lst = studentPaging.findAll(pageBetween3and4);

		lst.forEach(System.out::println);

	}
}
