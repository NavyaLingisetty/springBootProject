package com.navya.springboot.crud.dao;

import com.navya.springboot.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Queue;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    //define field for entitymanager
    private EntityManager entityManager;
    //set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //create a query to get result list
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;
    }
}