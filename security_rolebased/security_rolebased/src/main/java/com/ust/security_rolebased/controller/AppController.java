
package com.ust.security_rolebased.controller;



import com.ust.security_rolebased.entity.Employee;
import com.ust.security_rolebased.entity.Leave;
import com.ust.security_rolebased.entity.LeaveStatus;
import com.ust.security_rolebased.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    AppService appService;
    @PostMapping("/register")
    public ResponseEntity<Employee> registerEmployee(@RequestBody  Employee employee){

        return ResponseEntity.ok(appService.saveEmployee(employee));
    }

    @PostMapping("/registerall")
    public  ResponseEntity<List<Employee>> registerAll(@RequestBody List<Employee> employees)
    {
        return ResponseEntity.ok(appService.saveAllEmployees(employees));
    }





    @GetMapping("/employee/")

            public ResponseEntity<Employee> getEmployeeById()
    {
        return ResponseEntity.ok(appService.getEmployee());
    }

    @PostMapping("/leave")
    public ResponseEntity<Leave> applyForLeave(@RequestBody Leave leave)
    {
        return ResponseEntity.ok(appService.applyForLeave(leave));
    }

    @GetMapping("/allEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {

        return ResponseEntity.ok(appService.getAllEmployee());
    }



    @PutMapping("/leave/action/{leaveid}/{status}")
    public ResponseEntity<Leave> updateStatus(@PathVariable("leaveid") long leaveid,
                                              @PathVariable("status") LeaveStatus status)
    {

        return ResponseEntity.ok( appService.updateStatus(leaveid,status));
    }
}
