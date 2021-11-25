package com.manpower.hr.service;

import com.manpower.hr.dto.EmployeeRequest;
import com.manpower.hr.model.Employees;
import com.manpower.hr.repo.EmployeeRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

//    public ResponseEntity getEmployeeList(){
//        List<Employees> ls = new ArrayList<>();
//             ls = employeeRepo.findAll();
//            return ResponseEntity.ok(ls);
//
////        List<Employer>employers = new ArrayList<>();
////        repository.findAll()
////                .forEach(employers::add);
////        return employers;
//    }

    public List<Employees> getEmployeeList(){
       return employeeRepo.findAll();

    }

    public ResponseEntity addEmployee(@RequestBody, payload EmployeeRequest){
        try{
           // Employees ls = new Employees();
//          Employees  ls = employeeRepo.getByEmployeeId(payload.getEmployeeId());

          //  ls.setJobTitle(pay);

//            if (ls == null){
                Employees em = new Employees();
                em.setEmployeeId(payload.getEmployeeId());
                em.setFirstName(payload.getFirstName());
                em.setLastName(payload.getLastName());
                em.setJobTitle(payload.getJobTitle());
                return  ResponseEntity.ok(employeeRepo.save(em));
//            }
//            else {
//                return ResponseEntity.ok("This is not adding to the database uniquely");
//            }
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok("There was an Error!");

        }
    }


}
