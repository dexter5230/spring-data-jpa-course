package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
@Deprecated
public interface BookRepository extends JpaRepository<Book, Long> {
}
