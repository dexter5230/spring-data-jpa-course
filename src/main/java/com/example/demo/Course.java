package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "Course")
@Table(name = "course")
@Deprecated
public class Course {
    @Id
    @SequenceGenerator(name = "course_id_generator", sequenceName = "course_id_generator", allocationSize = 1)
    @GeneratedValue(strategy = IDENTITY, generator = "course_id_generator")
    @Column(name = "course_id", updatable = false)
    private Long course_id;
    @Column(name = "course_name", nullable = false, columnDefinition = "TEXT")
    private String courseName;
    @Column (name = "department", nullable = false, columnDefinition = "TEXT")
    private String department;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "course"
    )
    private List<Enrolment> enrolments = new ArrayList<>();

    public Course(String courseName, String department) {
        this.courseName = courseName;
        this.department = department;
    }

    public Course() {
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public void addEnrolment(Enrolment enrolment) {
        if (!enrolments.contains(enrolment)) {
            enrolments.add(enrolment);
        }
    }
    public void removeEnrolment(Enrolment e) {
        if (enrolments.contains(e)) {
            enrolments.remove(e);
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", courseName='" + courseName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
