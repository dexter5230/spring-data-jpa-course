package com.example.demo;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, StudentCardRepository studentCardRepository, Repository studentAccountRepository, BookRepository bookRepository) {
        return args -> {
//            generateRandomStudents(studentRepository);
//            //sorting(studentRepository);
//            PageRequest pageRequest1 = PageRequest.of(0, 10, Sort.by("lastName").descending());
//            Page<Student> page1 = studentRepository.findAll(pageRequest1);
//            System.out.println(page1);
//            Sort sort = Sort.by("dateOfBirth").ascending().and(Sort.by("lastName").descending());
//            studentRepository.findAll(sort).forEach(student -> System.out.println(student.getDateOfBirth()));
//            PageRequest pageRequest = PageRequest.of(0, 5, Sort.by("firstName").ascending());
//            Page<Student> page = studentRepository.findAll(pageRequest);
//            System.out.println(page);
            Faker faker =  new Faker();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@newchannel.edu", firstName, lastName);
            Date date =  faker.date().birthday();
            Student student =  new Student (
                    firstName,
                    lastName,
                    date,
                    email
            );
            student.addBook(new Book("I want to be a better person"));
            student.addBook(new Book("I want to have a job"));
            student.addIdCard(new StudentIdCard("123456789"));
            student.addAccount(new StudentAccount("qwer1234", student.getEmail()));
            student.enrolToCourse(new Course("Computer Science", "IT"));
            student.enrolToCourse(new Course("Spring Date JPA", "IT"));
            //StudentIdCard studentIdCard =  new StudentIdCard("123456789",student);
           // StudentAccount studentAccount = new StudentAccount("qwer1234",student);
            studentRepository.save(student);
            studentRepository.findById(1L).ifPresent(s-> {
                System.out.println("FetchType is lazy...");
                List<Book> books = student.getBooks();
                books.forEach(book -> {
                    System.out.println(book.getBookName());
                });
            });
//            bookRepository.save(new Book("how to be a jerk", student));

//            studentAccountRepository.save(studentAccount);
//            studentCardRepository.save(studentIdCard);
            //studentRepository.updateStudentById("wujiaxuanau@gmail.com", 1l);
            //studentAccountRepository.updateStudentAccountById(studentRepository.findById(1l).get().email, 1l);
        };
    }



    private void generateRandomStudents(StudentRepository studentRepository) {
        Faker faker =  new Faker();
        for (int i = 0; i < 20; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@newchannel.edu", firstName, lastName);
            Date date =  faker.date().birthday();
           Student student =  new Student (
                    firstName,
                    lastName,
                    date,
                    email
            );
            studentRepository.save(student);
        }
    }
}
