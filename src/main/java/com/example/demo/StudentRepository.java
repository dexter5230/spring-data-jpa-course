package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;
@Deprecated
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
    @Query("SELECT s FROM Student s WHERE s.firstName = ?1 AND s.email = ?2")
    Optional<Student> findStudentsByFirstNameEqualsAndEmailEquals(String firstName, String email);
    //native query
    @Query(value = "SELECT * FROM stundet where first_name = ?1 AND email = ?2", nativeQuery = true)
    Optional<Student> findStudentsByFirstNameEqualsAndEmailEqualWithNativeQuery(String firstName, String email);
    @Query("SELECT s FROM Student s WHERE s.firstName = :firstName AND s.email = :email")
    Optional<Student> findByFirstNameAndEmail(@Param("firstName") String firstName, @Param("email") String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM Student n WHERE n.studentId = :id")
    void deleteStudentById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Student u SET u.email = ?1 WHERE u.studentId = ?2")
    void updateStudentById(String email, Long id);

}
