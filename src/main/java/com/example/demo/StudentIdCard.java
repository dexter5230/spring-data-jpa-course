package com.example.demo;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;
@Deprecated
@Entity(name = "StudentIdCard")
@Table(name = "student_id_card",
        uniqueConstraints = {@UniqueConstraint(name = "unique_student_card_number", columnNames = "card_number")})

public class StudentIdCard {
    @Id
    @SequenceGenerator (name = "student_card_id_sequence", sequenceName = "student_card_id_sequence",allocationSize = 1)
    @GeneratedValue (strategy = SEQUENCE, generator = "student_id_card_id_sequence")
    @Column(name = "id", updatable = false)
    Long cardId;

    @Column(name = "card_number", updatable = false, length = 15)
    private String cardNumber;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "student_id",
                referencedColumnName = "student_id")
    private Student student;

    public Long getCardId() {
        return cardId;
    }

    public StudentIdCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public StudentIdCard(Long cardId, String cardNumber) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public StudentIdCard() {
    }
}
