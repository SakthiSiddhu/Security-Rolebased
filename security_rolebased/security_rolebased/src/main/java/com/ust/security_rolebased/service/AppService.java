package com.ust.security_rolebased.service;

import com.ust.security_rolebased.entity.Employee;
import com.ust.security_rolebased.entity.Leave;
import com.ust.security_rolebased.entity.LeaveStatus;
import com.ust.security_rolebased.repository.EmployeeRepository;
import com.ust.security_rolebased.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Service
public class AppService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    LeaveRepository leaveRepository;


    public Employee saveEmployee(Employee employee) {

        employee.setEmppassword(
                passwordEncoder.encode(
                        employee.getEmppassword()));

        return employeeRepository.save(employee);
    }

    public Employee getEmployee() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        return employeeRepository.findByEmpname(name).orElse(null);
    }

    public Leave applyForLeave(Leave leave) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Employee employee = employeeRepository.findByEmpname(username).get();
        leave.setEmployee(employee);

        return leaveRepository.save(leave);
    }

    public Leave updateStatus(long leaveid, LeaveStatus status) {

        Leave leave = leaveRepository.findById(leaveid).get();

        leave.setStatus(status);
        return leaveRepository.save(leave);


    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }


    public List<Employee> saveAllEmployees(List<Employee> employees) {
        List<Employee> empList =
                employees.stream()
                        .map(
                                employee -> {
                                    employee.setEmppassword(
                                            passwordEncoder.encode(
                                                    employee.getEmppassword())
                                    );
                                    return employee;
                                }
                        ).toList();
        return employeeRepository.saveAll(empList);
    }

}