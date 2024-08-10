package com.ust.security_rolebased.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    EmployeeDetailsService employeeDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(employeeDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable();

      http.authorizeRequests()
              .antMatchers("/api/register","/api/registerall").permitAll()
                      .and()

              .authorizeRequests()
              .antMatchers("/api/allEmployee",
                      "/api/leave/action").hasRole("ADMIN")
              .and()

              .authorizeRequests()
              .antMatchers("/api/employee/**",
              "/api/leave").hasRole("USER")

              .anyRequest().authenticated()
              .and()
              .httpBasic();
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
