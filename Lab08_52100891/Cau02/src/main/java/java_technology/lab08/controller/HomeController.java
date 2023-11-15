package java_technology.lab08.controller;

import java_technology.lab08.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    private final EmployeeController empController;
    @Autowired
    public HomeController(EmployeeController empController) {
        this.empController = empController;
    }

    @GetMapping("/")
    public RedirectView index() { return new RedirectView("/employee"); }
    @GetMapping("/employee")
    public String employee(Model model) {
//        empController.init(); //for testing
        List<Employee> employees = empController.getEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/employee/add")
    public String add() { return "add"; }

    @PostMapping("/employee/add")
    @ResponseBody
    public RedirectView addEmployee(@RequestParam("name") String name, @RequestParam("email") String email,
                                @RequestParam("address") String address, @RequestParam("phone") String phone) {
        Employee emp = new Employee(name, email, address, phone);
        empController.add(emp);

        return new RedirectView("/employee");
    }

    @PostMapping("/employee/delete/{id}")
    public RedirectView deleteEmployee(@PathVariable("id") String id) {
        empController.delete(Integer.parseInt(id));
        return new RedirectView("/employee");
    }

    @GetMapping("/employee/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Employee emp = empController.findEmployee(Integer.parseInt(id));
        model.addAttribute("employee", emp);
        return "edit";
    }

    @PostMapping("/employee/edit/{id}")
    public RedirectView editEmployee(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("email") String email,
                                     @RequestParam("address") String address, @RequestParam("phone") String phone) {

        empController.update(Integer.parseInt(id), name, email, address, phone);
        return new RedirectView("/employee");
    }

    @PostMapping("/employee/delete-list")
    public RedirectView deleteEmployees(@RequestParam("ids") String ids) {
        List<Integer> idsList = new ArrayList<>();
        for (String s : ids.split(",")) {
            idsList.add(Integer.parseInt(s));
        }

        empController.deleteList(idsList);

        return new RedirectView("/employee");
    }
}
