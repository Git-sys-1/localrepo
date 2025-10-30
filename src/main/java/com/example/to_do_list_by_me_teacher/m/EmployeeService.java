package com.example.to_do_list_by_me_teacher.m;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService implements EmployeeServiceInterface {
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository eRepository) {
        employeeRepository = eRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
          Employee employee  = null;
          if(result.isPresent()){
              employee = result.get();
          }else {
              throw new RuntimeException("Employee not found" + id);
          }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isPresent()) {
            employeeRepository.deleteById(id);
        }else {
            throw new RuntimeException("Employee not found" + id);
        }
        System.out.println("Teacher deleted");

    }
}
