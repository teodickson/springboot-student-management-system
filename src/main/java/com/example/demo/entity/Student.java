package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // primary key generation strategy
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @NotEmpty(message = "Student email cannot be empty !")
    @Column(name = "email")
    private String email;

    public Student() {
        // Hibernate internally uses proxies to create objects dynamically, so it needs a default constructor
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
