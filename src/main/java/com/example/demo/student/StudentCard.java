package com.example.demo.student;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "StudentCardV1")
@Table(name = "student_card", uniqueConstraints = {@UniqueConstraint(name = "unique_card_number", columnNames = "card_number")} )
public class StudentCard implements Serializable {
    @Column (name = "card_number", nullable = false,updatable = false, unique = true)
    private Long cardNumber;

    @Id
    @OneToOne (cascade = CascadeType.ALL)
    @MapsId("student_id")
    @JoinColumn (name = "student_id", referencedColumnName = "student_id", foreignKey = @ForeignKey(name = "student_fk"))
    private Student student;

    public StudentCard(Long cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public StudentCard(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public StudentCard() {
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCard that = (StudentCard) o;
        return Objects.equals(cardNumber, that.cardNumber) && Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, student);
    }
}
