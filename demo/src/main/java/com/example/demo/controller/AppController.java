package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.entity.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employees")
public class AppController {
    
    private List<Employee> employees = createList();

    @GetMapping(produces = "application/json")
    public List<Employee> firstPage(){
        return employees;
    }

    @GetMapping(produces = "application/json")
    @RequestMapping({"/validatelogin"})
    public User validatelogin(){
        return new User("User successfully autenticated");
    }

    @DeleteMapping(path = {"/{id}"})
    public Employee delete(@PathVariable("id") String id){
        Employee currEmployee = null;
        for (Employee employee: employees) {
            if(employee.getId().equals(id)){
                employees.remove(employee);
                currEmployee = employee;
                break;
            }
        }
        return currEmployee;
    }

    @PostMapping
    public Employee create(@RequestBody Employee user){
        employees.add(user);
        System.out.println(employees);
        return user;
    }

    private static List<Employee> createList(){
        List<Employee> tEmployees = new ArrayList<>();
        
        Employee emp1 = new Employee();
        emp1.setName("emp1");
        emp1.setDesignation("manager");
        emp1.setId("1");
        emp1.setSalary(3000);

        Employee emp2 = new Employee();
        emp2.setName("emp2");
        emp2.setDesignation("developer");
        emp2.setId("2");
        emp2.setSalary(1000);

        tEmployees.add(emp1);
        tEmployees.add(emp2);
        return tEmployees;
    }
}
