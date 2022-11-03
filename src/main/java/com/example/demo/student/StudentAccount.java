package com.example.demo.student;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "StudentAccountV1")
@Table(name = "student_account_v1")
public class StudentAccount {
    @Id
    @SequenceGenerator(name = "account_number_generator", sequenceName = "account_number_generator", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE)
    @Column (name = "acccount_number", updatable = false)
    private Long accountNumber;

    @Column (name = "account_name", nullable = false, columnDefinition = "TEXT")
    private String accountName;

    @Column (name = "acc_password", nullable = false, columnDefinition = "TEXT")
    @JsonProperty
    private String password;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "student_id", referencedColumnName = "student_id", foreignKey = @ForeignKey(name = "student_fk"))
    private Student student;

    public StudentAccount() {
    }

    public StudentAccount(String password, Student student) {
        this.password = password;
        this.student = student;
    }

    public StudentAccount(String password) {
        this.password = password;
        this.accountName = student.getEmail();
    }
    public StudentAccount(String password, String email) {
        this.accountName = email;
        this.password = password;

    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

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
