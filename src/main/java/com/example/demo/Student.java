package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity(name = "Student")
@Table (name = "student",
        uniqueConstraints = @UniqueConstraint(name = "student_email_unique", columnNames = {"email"})
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
    @Column (name = "date_of_birth", nullable = false, columnDefinition = "Date")
    Date dateOfBirth;
    @Column (name = "email", nullable = false, columnDefinition = "TEXT")
    @Email
    String email;
    @OneToOne(mappedBy = "student", orphanRemoval = true)
    private StudentAccount studentAccount;
    @OneToOne(mappedBy = "student", orphanRemoval = true)
    private StudentIdCard studentIdCard;

    public Student(String firstName, String lastName, Date dateOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)  {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date_of_birth=" + dateOfBirth +
                ", email='" + email + '\'' +
                '}';
    }
}
