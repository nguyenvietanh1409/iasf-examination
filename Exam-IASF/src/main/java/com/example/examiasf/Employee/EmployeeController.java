package com.example.examiasf.Employee;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public String showUserList(Model model) {
        List<Employee> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        System.out.println(listUsers);
        return "users";
    }


    @GetMapping("/employees/new")
    public String showNewForm(Model model) {
        model.addAttribute("user", new Employee());
        model.addAttribute("pageTitle", "Add new employee");
        return "user_form";
    }

    @PostMapping("/employees/save")
    public String saveUser(Employee user) {
        service.save(user);
        return "redirect:/employees";
    }
}
