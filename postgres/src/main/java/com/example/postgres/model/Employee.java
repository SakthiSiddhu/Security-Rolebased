package com.example.postgres.model;


import javax.persistence.*;
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
    @OneToMany(mappedBy = "employee")
    private List<Leave> leaveList;
}
