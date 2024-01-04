package com.navya.springboot.crud.dao;

import com.navya.springboot.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // no need to write any code
    // no need of any implementation classes
}
