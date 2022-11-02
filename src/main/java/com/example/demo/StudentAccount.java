package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "StudentAccount")
@Table(name  = "student_account")
public class StudentAccount {
    @Id
    private Long id;
    @Column(name = "account_name", nullable = false, columnDefinition = "TEXT")
    private String accountName;

    @Column (name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;
    @OneToOne(cascade = {CascadeType.ALL})
    @MapsId
    Student student;

    public StudentAccount(String password, Student student) {
        this.password = password;
        this.student = student;
        this.accountName = student.getEmail();

    }

    public StudentAccount(String password, String email) {
        this.accountName = email;
        this.password = password;

    }

    public StudentAccount() {
    }

    public Long getId() {
        return id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
