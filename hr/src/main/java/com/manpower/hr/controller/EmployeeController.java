package com.manpower.hr.controller;

import com.manpower.hr.dto.EmployeeRequest;
import com.manpower.hr.dto.EmployeeResponse;
import com.manpower.hr.model.Employees;
import com.manpower.hr.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/sample")
    public ResponseEntity welcomeMessage(){
        return ResponseEntity.ok("This is a good start!");
    }

    @GetMapping("/list")
    @ApiOperation(value = " This fetches all the Employees in the list ", response = EmployeeResponse.class, responseContainer = "List")
    public ResponseEntity employeeList(){
        List<EmployeeResponse> rs = new ArrayList<>();
        List<Employees> ls = employeeService.getEmployeeList();
        for (Employees i : ls){
            EmployeeResponse j = new EmployeeResponse();
            j.setFirstName(i.getFirstName());
            j.setJobTitle(i.getJobTitle());
            j.setLastName(i.getLastName());
            j.setSalary(i.getSalary());
            //j.setReportTo(i.);
            rs.add(j);
        }

        return ResponseEntity.ok(rs);
    }

    @PostMapping("/add")
    @ApiOperation(value="", response = Employees.class)
    public ResponseEntity addEmployee (@RequestBody EmployeeRequest payload){

        return ResponseEntity.ok( employeeService.addEmployee(payload));
    }

    /*
    *
    * @PostMapping("/add")
    * public Customer placeOrder(@RequestBody OrderRequest request){
    *       return customerRepository.save(request.getCustomer());
    * }
    * */


}
