package com.example.postgres.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;



@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor

public class Leave {

    @Id
    @GeneratedValue

    private long leaveId;
    private String reason;
    @Column(columnDefinition = "integer DEFAULT '0'")
    private LeaveStatus status;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Employee employee;
}
