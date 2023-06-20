package com.example.examiasf.Employee;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository repository;
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }
    public List<Employee> listAll() {
        return (List<Employee>) repository.findAll();
    }
    public void save(Employee employee) {
        repository.save(employee);
    }
}
