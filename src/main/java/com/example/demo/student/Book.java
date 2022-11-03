package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "BookV1")
@Table(name = "book_v1")
public class Book {
    @Id
    @SequenceGenerator(name = "book_id_generator", sequenceName = "book_id_generator", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE)
    private Long bookId;

    @Column (name = "book_name", nullable = false)
    private String bookName;

    @Column (name = "create_at", nullable = false)
    private LocalDateTime createTime;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "student_id", referencedColumnName = "student_id", foreignKey = @ForeignKey(name = "student_fk"))
    private Student student;

    public Book(Long bookId, String bookName, LocalDateTime createTime, Student student) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.createTime = createTime;
        this.student = student;
    }

    public Book(String bookName) {
        this.bookName = bookName;
        this.createTime = LocalDateTime.now();
    }

    public Book() {
    }

    public Book(String bookName, LocalDateTime createTime, Student student) {
        this.bookName = bookName;
        this.createTime = createTime;
        this.student = student;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
