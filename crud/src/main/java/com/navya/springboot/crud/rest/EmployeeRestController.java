package com.navya.springboot.crud.rest;

//import com.navya.springboot.crud.dao.EmployeeDAO;
import com.navya.springboot.crud.entity.Employee;
import com.navya.springboot.crud.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // lines are commented because service is used for EmployeeDAO injection  hence we inject EmployeeService
    // in the controller
//    private EmployeeDAO employeeDAO;
//    // inject employee directly and we will later refactor with injecting service layer
//
//    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
//        employeeDAO = theEmployeeDAO;
//    }
//
//    //expose "/employees" and return a list of employees
//    @GetMapping("/employees")
//    public List<Employee> findAll(){
//       return employeeDAO.findAll();
//    }

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
       return employeeService.findAll();
    }

}
