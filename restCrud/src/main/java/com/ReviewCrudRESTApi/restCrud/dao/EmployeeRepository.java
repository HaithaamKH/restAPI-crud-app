package com.ReviewCrudRESTApi.restCrud.dao;

import com.ReviewCrudRESTApi.restCrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
}
