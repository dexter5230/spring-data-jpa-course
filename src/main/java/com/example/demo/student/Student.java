package com.example.demo.student;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "StudentV1")
@Table ( name = "student_v1"
        ,uniqueConstraints={@UniqueConstraint(name = "unique_email_",columnNames={"email"})})
public class Student {
    @Id
    @SequenceGenerator (name = "student_id_generator", sequenceName = "student_id_generator", allocationSize = 1)
    @GeneratedValue (strategy = SEQUENCE)
    @Column (name = "student_id")
    private Long studentId;

    @Column (name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column (name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column (name = "email", nullable = false, columnDefinition = "TEXT", unique = true)
    @Email
    private String email;

    @Column (name = "date_of_birth", nullable = false, columnDefinition ="DATE")
    private Date dateOfBirth;

    @OneToOne(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private StudentCard studentCard;

    @OneToOne (mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private StudentAccount studentAccount;

    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    List<Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    List<Enrolment> enrolments =new ArrayList<>();

    public void addEnrolment(Enrolment enrolment) {
        if (!enrolments.contains(enrolment)) {
            enrolments.add(enrolment);
        }
    }

    public void removeEnrolment(Enrolment enrolment) {
        if (enrolments.contains(enrolment)) {
            enrolments.remove(enrolment);
        }
    }


    public void addStudentCard(StudentCard studentCard) {
        this.studentCard = studentCard;
        studentCard.setStudent(this);
    }

    public void addAccount(StudentAccount studentAccount) {
        studentAccount.setStudent(this);
        this.studentAccount = studentAccount;

    }

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
        book.setStudent(this);
    }

    public void removeBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
        }
        book.setStudent(null);
    }

    public Student(String firstName, String lastName, String email, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Student() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
