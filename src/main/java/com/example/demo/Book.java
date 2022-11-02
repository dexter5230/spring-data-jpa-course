package com.example.demo;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "Book")
@Table(name = "book")
public class Book {
    @Id
    @SequenceGenerator(name = "book_id_generator", sequenceName = "book_id_generator", allocationSize = 1)
    @GeneratedValue(strategy = IDENTITY, generator = "book_id_generator")
    @Column(name = "book_id", updatable = false)
    private Long book_id;
    @Column(name = "book_name", nullable = false, columnDefinition = "TEXT")
    private String bookName;
    @Column(name = "create_at", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createAt;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", foreignKey = @ForeignKey(name = "student_id_pk"))
    Student student;

    public Book(String bookName) {
        this.bookName = bookName;
        this.createAt = LocalDateTime.now();
    }

    public Book(String bookName, Student student) {
        this.bookName = bookName;
        this.createAt = LocalDateTime.now();
        this.student = student;
    }

    public Book() {

    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }



    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", bookName='" + bookName + '\'' +
                ", createAt=" + createAt +
                ", student=" + student +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
