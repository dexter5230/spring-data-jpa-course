package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "CourseV1")
@Table(name = "course_v1",
       uniqueConstraints = {@UniqueConstraint(name = "unique_course_name", columnNames = "course_name")})
public class Course {
    @Id
    @SequenceGenerator(name = "course_id_generator", sequenceName = "course_id_generator", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE)
    @Column (name = "course_id", updatable = false, nullable = false)
    private Long courseId;

    @Column (name = "course_name", nullable = false, unique = true, columnDefinition = "TEXT")
    private String courseName;

    @Column (name = "create_at", nullable = false)
    private LocalDateTime createAt;

    @Column (name = "author", columnDefinition = "TEXT")
    private String author;

    @OneToMany (cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "course")
    List<Enrolment> enrolments = new ArrayList<>();


    public Course(Long courseId, String courseName, LocalDateTime createAt, String author) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.createAt = createAt;
        this.author = author;
    }

    public Course(String courseName) {
        this.courseName = courseName;
        this.createAt = LocalDateTime.now();
        author = null;
    }

    public Course() {
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
