package com.mastery.java.task.rest;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping()
    public String getAllEmployees(Model model){
        model.addAttribute("employee", this.employeeDao.getAllEmployees());
        return "/employee";
    }

    @GetMapping("employee/{id}")
    public String getEmployeeById(@PathVariable("id")Long id, Model model){
        model.addAttribute("employee", this.employeeDao.getEmployeeById(id));
        return "employee";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee")Employee employee){
        if (employee.getId() == 0){
            this.employeeDao.addEmployee(employee);
        }else {
            this.employeeDao.updateEmployee(employee);
        }
        return "redirect:/employee";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id){
        this.employeeDao.deleteEmployeeById(id);
        return "redirect:/employee";
    }

    @PatchMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") Long id, Model model){
        model.addAttribute("employee", this.employeeDao.getEmployeeById(id));
        return "redirect:/employee";
    }
}
