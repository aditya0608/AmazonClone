package com.aditya.employeeservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name="Employees")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String fName;
   private String lName;
   @Column(nullable = false,unique = true)
   private String email;
   private String departmentCode;

}