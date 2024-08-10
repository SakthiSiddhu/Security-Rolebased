package com.ust.security_rolebased.entity;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class
Employee {

    @Id
    private long empid;
    private String empname;
    private String emppassword;
    private String desg;
    private String roles;
    private boolean isEnabled;
    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    private List<Leave> leaveList;
}
