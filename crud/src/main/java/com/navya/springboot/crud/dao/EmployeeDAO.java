package com.navya.springboot.crud.dao;

import com.navya.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
