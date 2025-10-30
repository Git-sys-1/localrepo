package com.example.to_do_list_by_me_teacher.m;

import java.util.List;

public interface EmployeeServiceInterface {
    public List<Employee> findAll();
    public Employee findById(int id);
    public Employee save(Employee employee);
    public void deleteById(int id);
}
