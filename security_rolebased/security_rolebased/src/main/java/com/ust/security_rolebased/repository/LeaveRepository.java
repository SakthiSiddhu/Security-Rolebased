package com.ust.security_rolebased.repository;



import com.ust.security_rolebased.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LeaveRepository extends JpaRepository<Leave,Long> {
}
