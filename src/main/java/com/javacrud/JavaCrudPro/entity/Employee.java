package com.javacrud.JavaCrudPro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity //identify a class as entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private  String name;
    @Column(name="email_address",nullable = false,unique = true)
    private String email;

//    public Employee(Long id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
