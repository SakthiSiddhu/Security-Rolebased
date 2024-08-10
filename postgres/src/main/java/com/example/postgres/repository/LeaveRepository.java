package com.example.postgres.repository;


import com.example.postgres.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave,Long> {
}
