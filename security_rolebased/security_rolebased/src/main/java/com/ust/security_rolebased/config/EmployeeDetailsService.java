package com.ust.security_rolebased.config;

import com.ust.security_rolebased.entity.Employee;
import com.ust.security_rolebased.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeDetailsService implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String name)
            throws UsernameNotFoundException {

        Optional<Employee> employee = employeeRepository.findByEmpname(name);

        return employee.map(EmployeeDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("not found"));




    }
}

