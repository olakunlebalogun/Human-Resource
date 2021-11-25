package com.manpower.hr.dto;

import com.manpower.hr.model.Offices;
import lombok.Data;

@Data
public class EmployeeRequest {
    String firstName;
    String lastName;
    Integer employeeId;
    String jobTitle;
    Integer salary;
    Integer reportTo;
    //Integer officeId;
    Offices office;
}
