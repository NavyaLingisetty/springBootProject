package com.navya.springboot.crud.service;

import com.navya.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
