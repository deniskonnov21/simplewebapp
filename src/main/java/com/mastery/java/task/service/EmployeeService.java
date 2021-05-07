package com.mastery.java.task.service;


import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements iEmployeeService{

    private EmployeeDao employeeDao;
    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
      return this.employeeDao.getAllEmployees();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(Long id) {
        return this.employeeDao.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        this.employeeDao.addEmployee(employee);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        return this.employeeDao.updateEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(Long id) {
        this.employeeDao.deleteEmployeeById(id);
    }
}
