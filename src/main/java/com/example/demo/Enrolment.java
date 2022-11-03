package com.example.demo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Enrolment")
@Table (name = "enrolment")
public class Enrolment {
    @EmbeddedId
    private EnrolmentId enrolmentId;

    @ManyToOne
    @MapsId ("studentId")
    @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "student_id_fk"))
    private Student student;
    @ManyToOne
    @MapsId ("courseId")
    @JoinColumn(name = "course_id", foreignKey = @ForeignKey (name = "course_id_fk"))
    private Course course;

    @Column (name = "create_time", nullable = false, updatable = false)
    private LocalDateTime createTime;
    public Enrolment(Student student, Course course) {
        this.student = student;
        this.course = course;
        createTime = LocalDateTime.now();
    }

    public Enrolment(EnrolmentId enrolmentId, Student student, Course course) {
        this.enrolmentId = enrolmentId;
        this.student = student;
        this.course = course;
        this.createTime = LocalDateTime.now();
    }


    public Enrolment() {
    }

    public EnrolmentId getEnrolmentId() {
        return enrolmentId;
    }

    public void setEnrolmentId(EnrolmentId enrolmentId) {
        this.enrolmentId = enrolmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
