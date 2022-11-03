package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;
@Deprecated
public interface Repository extends JpaRepository <StudentAccount, Long> {
    @Query ("SELECT u FROM StudentAccount u WHERE u.id = :id")
    Optional<Student> findStudentAccountById(@Param("id") Long id);
//    @Query (value = "SELECT * FROM stundet WHERE email = :email",
//            nativeQuery = true)
//    Optional<Student> findStudentByEmail(@Param("email") String email);
//    @Transactional
//    @Modifying
//    @Query ("DELETE FROM Student s WHERE s.studentId = :id")
//    int deleteStudentById(@Param("id") Long id);
    @Transactional
    @Modifying
    @Query ("UPDATE StudentAccount u SET u.accountName = :username WHERE u.id = :id")
    void updateStudentAccountById(@Param("username")String username,@Param("id") Long id);
}
