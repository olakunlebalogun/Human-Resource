package com.manpower.hr.repo;

import com.manpower.hr.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employees, Integer> {
//    Employees addEmployee();
    Employees getByEmployeeId( Integer id);
}
