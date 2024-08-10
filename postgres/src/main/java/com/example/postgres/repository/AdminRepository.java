package com.example.postgres.repository;


import com.example.postgres.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository  extends JpaRepository<Admin,Long> {
}
