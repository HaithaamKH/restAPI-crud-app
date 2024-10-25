package com.ReviewCrudRESTApi.restCrud.service;
import java.util.*;

import com.ReviewCrudRESTApi.restCrud.entity.Employee;

public interface EmployeeService {

    public List<Employee> findAll();
    public Employee findById(int id);

    public Employee save(Employee employee);
    public Employee deleteById(int id);

}
