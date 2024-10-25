package com.ReviewCrudRESTApi.restCrud.rest;

import com.ReviewCrudRESTApi.restCrud.employeeException.EmployeeNotFoundException;
import com.ReviewCrudRESTApi.restCrud.entity.Employee;
import com.ReviewCrudRESTApi.restCrud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRest {
    private EmployeeService employeeService;

    EmployeeRest(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return this.employeeService.findAll();
    }
    @GetMapping("/employees/{id}")
    public Employee findAll(@PathVariable int id) {
        int size = this.employeeService.findAll().size();
        if(id>size || id<0){
            throw new EmployeeNotFoundException("id not found in the database");
        }
        return this.employeeService.findById(id);
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee){
        employee.setId(0);
        this.employeeService.save(employee);
        return employee;
    }
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
        return this.employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public Employee delete(@PathVariable int id){
        return this.employeeService.deleteById(id);
    }
}
