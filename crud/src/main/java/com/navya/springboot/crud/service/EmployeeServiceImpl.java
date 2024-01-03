package com.navya.springboot.crud.service;

import com.navya.springboot.crud.dao.EmployeeDAO;
import com.navya.springboot.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    //define entity manager
    private EmployeeDAO employeeDAO;
    // define constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;

    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
