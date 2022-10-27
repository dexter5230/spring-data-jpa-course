package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface Repository extends JpaRepository <Student, Long> {
    @Query ("SELECT u FROM Student u WHERE u.studentId = :id")
    Optional<Student> findStudentById(@Param("id") Long id);
    @Query (value = "SELECT * FROM stundet WHERE email = :email",
            nativeQuery = true)
    Optional<Student> findStudentByEmail(@Param("email") String email);
    @Transactional
    @Modifying
    @Query ("DELETE FROM Student s WHERE s.studentId = :id")
    int deleteStudentById(@Param("id") Long id);
}
