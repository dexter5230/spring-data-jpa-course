package com.example.demo;

import com.example.demo.student.Course;
import com.example.demo.student.Student;
import com.example.demo.student.StudentAccount;
import com.example.demo.student.StudentCard;
import com.example.demo.student.StudentRepositoryV1;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@ComponentScan({"com.example.demo.student"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepositoryV1 studentRepository) {
        return args -> {
//            generateRandomStudents(studentRepository);
//            //sorting(studentRepository);
//            PageRequest pageRequest1 = PageRequest.of(0, 10, Sort.by("lastName").descending());
//            Page<Student> page1 = studentRepository.findAll(pageRequest1);
//            System.out.println(page1);
//            Sort sort = Sort.by("dateOfBirth").ascending().and(Sort.by("lastName").descending());
//            studentRepository.findAll(sort).forEach(com.example.demo.student -> System.out.println(com.example.demo.student.getDateOfBirth()));
//            PageRequest pageRequest = PageRequest.of(0, 5, Sort.by("firstName").ascending());
//            Page<Student> page = studentRepository.findAll(pageRequest);
//            System.out.println(page);
            Faker faker =  new Faker();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@newchannel.edu", firstName, lastName);
            Date date =  faker.date().birthday();
            com.example.demo.student.Student student =  new Student (
                    firstName,
                    lastName,
                    email,
                    date
            );
            student.addBook(new com.example.demo.student.Book("I want to be a better person"));
            student.addBook(new com.example.demo.student.Book("I want to have a job"));
            student.addStudentCard(new StudentCard(123456789L));
            student.addAccount(new StudentAccount("qwer1234", student.getEmail()));
            Course course1 =  new com.example.demo.student.Course("Computer Science");
            Course course2 = new com.example.demo.student.Course("Spring Date JPA");
            student.addEnrolment(new com.example.demo.student.Enrolment(student, course1));
            student.addEnrolment(new com.example.demo.student.Enrolment(student, course2));

//            com.example.demo.student.enrolToCourse(new Course("Computer Science", "IT"));
//            com.example.demo.student.enrolToCourse(new Course("Spring Date JPA", "IT"));
            //StudentIdCard studentIdCard =  new StudentIdCard("123456789",com.example.demo.student);
           // StudentAccount studentAccount = new StudentAccount("qwer1234",com.example.demo.student);
            studentRepository.save(student);
            studentRepository.findById(1L).ifPresent(s-> {
                System.out.println("FetchType is lazy...");
                List<com.example.demo.student.Book> books = student.getBooks();
                books.forEach(book -> {
                    System.out.println(book.getBookName());
                });
            });
//            bookRepository.save(new Book("how to be a jerk", com.example.demo.student));

//            studentAccountRepository.save(studentAccount);
//            studentCardRepository.save(studentIdCard);
            //studentRepository.updateStudentById("wujiaxuanau@gmail.com", 1l);
            //studentAccountRepository.updateStudentAccountById(studentRepository.findById(1l).get().email, 1l);
        };
    }



    private void generateRandomStudents(StudentRepositoryV1 studentRepository) {
        Faker faker =  new Faker();
        for (int i = 0; i < 20; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@newchannel.edu", firstName, lastName);
            Date date =  faker.date().birthday();
           Student student =  new Student (
                    firstName,
                    lastName,
                    email,
                    date
            );
            studentRepository.save(student);
        }
    }
}
