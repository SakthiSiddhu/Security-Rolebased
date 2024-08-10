package com.example.postgres.service;
import com.example.postgres.model.Employee;
import com.example.postgres.model.Leave;
import com.example.postgres.model.LeaveStatus;
import com.example.postgres.repository.AdminRepository;
import com.example.postgres.repository.EmployeeRepository;
import com.example.postgres.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class AppService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    LeaveRepository leaveRepository;

    @Autowired
    AdminRepository adminRepository;

    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(long empid) {

        return employeeRepository.findById(empid).orElse(null);
    }

    public Leave applyForLeave(Leave leave) {

       return leaveRepository.save(leave);
    }

    public Leave updateStatus(long leaveid, LeaveStatus status) {

        Leave leave  = leaveRepository.findById(leaveid).get();

        leave.setStatus(status);
        return leaveRepository.save(leave);


    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
