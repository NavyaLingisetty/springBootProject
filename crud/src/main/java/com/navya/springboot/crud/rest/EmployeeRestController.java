package com.navya.springboot.crud.rest;

//import com.navya.springboot.crud.dao.EmployeeDAO;
import com.navya.springboot.crud.entity.Employee;
import com.navya.springboot.crud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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
    //

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
       return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        return theEmployee;
    }

    //mapping for adding new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //set id to 0 so that the employee is saved instead of update
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // maping for updating existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }


    @DeleteMapping("employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);
        if(tempEmployee == null){
            throw new RuntimeException("Employee Id not found - "+ employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted Employee id- " + employeeId;
    }


}
