package com.study.pojo;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    @Min(6)
    @Max(18)
    private int age;

    @Column(name = "email", nullable = false)
    @Email
    private String email;



}
