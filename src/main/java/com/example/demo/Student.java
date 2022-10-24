package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
@Entity(name = "Student")
@Table (name = "student",
        uniqueConstraints = @UniqueConstraint(name = "studnet_email_unique", columnNames = {"email"})
)
public class Student {
    @Id
    @SequenceGenerator(name = "student_id", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column (name = "student_id", updatable = false, nullable = false)
    Long studentId;
    @Column(name = "firs_name", nullable = false, columnDefinition = "TEXT")
    String firstName;
    @Column (name = "last_name", nullable = false,columnDefinition = "TEXT")
    String lastName;
    @Column (name = "date_of_birth", nullable = false)
    LocalDate date_of_birth;
    @Column (name = "email", nullable = false, columnDefinition = "TEXT")
    @Email
    String email;

    public Student(String firstName, String lastName, LocalDate date_of_birth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date_of_birth = date_of_birth;
        this.email = email;
    }

    public Student() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long customerId) {
        this.studentId = customerId;
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

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
