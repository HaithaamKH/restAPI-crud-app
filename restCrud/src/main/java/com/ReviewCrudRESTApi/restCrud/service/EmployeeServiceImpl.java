package com.ReviewCrudRESTApi.restCrud.service;

import com.ReviewCrudRESTApi.restCrud.dao.EmployeeRepository;
import com.ReviewCrudRESTApi.restCrud.employeeException.EmployeeErrorResponse;
import com.ReviewCrudRESTApi.restCrud.employeeException.EmployeeNotFoundException;
import com.ReviewCrudRESTApi.restCrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    @Autowired
    EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        Optional<Employee> result = this.employeeRepository.findById(id);
        if(result.isPresent()){
            employee=result.get();
        }else{
            throw  new EmployeeNotFoundException("Employee not found"+id);
        }
        return employee;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee deleteById(int id) {
        Employee employee = this.findById(id);
        this.employeeRepository.deleteById(id);
        return employee;
    }
}
