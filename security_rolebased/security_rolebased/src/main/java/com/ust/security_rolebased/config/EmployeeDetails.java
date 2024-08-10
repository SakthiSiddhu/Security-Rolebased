package com.ust.security_rolebased.config;

import com.ust.security_rolebased.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeDetails implements UserDetails {

    private String username;
    private String password;
    private boolean isEnabled;
    private Set<SimpleGrantedAuthority> roles;


    EmployeeDetails(Employee employee){
        this.username=employee.getEmpname();
        this.password= employee.getEmppassword();

        this.isEnabled=employee.isEnabled();
        this.roles = Arrays.stream(employee.getRoles()
                        .split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());


    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
