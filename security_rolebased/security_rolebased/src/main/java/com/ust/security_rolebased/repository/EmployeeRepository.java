package com.ust.security_rolebased.repository;


import com.ust.security_rolebased.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmpname(String name);

    Optional<Employee> findByEmpid(long empid);
}
