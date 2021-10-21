package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }

   // CommandLineRunner will run the arguments passed. Here it saves the Student
   // data in the database with the help of StudentRepository interface which
   // extends JpaRepository which in return gives us ample of methods to interact
   // with database.
   @Bean
   CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
      return args -> {
         Student nidhi = new Student("Nidhi", "Singh", "nidhi@mail.com", 5);
         studentRepository.save(nidhi);
      };
   }
}
