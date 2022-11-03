package com.example.demo.student;

import javax.persistence.*;

@Entity(name = "EnrolmentV1")
@Table(name = "enrolment_v1")
public class Enrolment {
    @EmbeddedId
    private EnrolmentId enrolmentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("studentId")
    @JoinColumn (name = "student_id", foreignKey = @ForeignKey(name = "student_id_fk"))
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId ("courseId")
    @JoinColumn (name = "course_id", foreignKey = @ForeignKey(name = "course_id_fk"))
    private Course course;

    public Enrolment(EnrolmentId enrolmentId, Student student, Course course) {
        this.enrolmentId = enrolmentId;
        this.student = student;
        this.course = course;
    }

    public Enrolment() {
    }

    public Enrolment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.enrolmentId = new EnrolmentId(student.getStudentId(), course.getCourseId());
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
