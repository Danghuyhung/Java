package java_technology.lab08.controller;

import java_technology.lab08.model.Employee;
import java_technology.lab08.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeController {
    private final EmployeeRepository repo;

    @Autowired
    public EmployeeController(EmployeeRepository repo) {
        this.repo = repo;
    }

    public void init() {
        this.repo.save(new Employee(1, "Thomas Hardy", "thomashardy@mail.com", "89 Chiaroscuro Rd, Portland, USA", "(171) 555-2222"));
        this.repo.save(new Employee(2, "Dominique Perrier", "dominiqueperrier@mail.com", "Obere Str. 57, Berlin, Germany", "(313) 555-5735"));
        this.repo.save(new Employee(3, "Maria Anders", "mariaanders@mail.com", "25, rue Lauriston, Paris, France", "(503) 555-9931"));
        this.repo.save(new Employee(4, "Fran Wilson", "franwilson@mail.com", "C/ Araquil, 67, Madrid, Spain", "(204) 619-5731"));
        this.repo.save(new Employee(5, "Martin Blank", "martinblank@mail.com", "Via Monte Bianco 34, Turin, Italy", "(480) 631-2097"));

    }
    public List<Employee> getEmployees() {
        return (List<Employee>) repo.findAll();
    }

    public Employee findEmployee(int id) {
        Optional<Employee> emp = repo.findById(id);
        return emp.orElse(null);
    }
    public Employee add(Employee employee) {
        return repo.save(employee);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void update(int id, String name, String email, String address, String phone) {
        Employee emp = this.findEmployee(id);
        emp.setName(name);
        emp.setEmail(email);
        emp.setAddress(address);
        emp.setPhone(phone);
        repo.save(emp);
    }

    public void deleteList(List<Integer> Ids) {
        repo.deleteAllById(Ids);
    }
}
