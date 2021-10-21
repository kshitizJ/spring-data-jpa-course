package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

// Now if we define unique contraints in Table annotation than we have to remove the unique property from Column annotation of that attribute to reflect the name of the unique entity specified in Table annotation.
@Entity(name = "Student")
@Table(name = "student", uniqueConstraints = {
      @UniqueConstraint(name = "student_email_unique", columnNames = "email") })
public class Student {

   @Id
   @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
   @Column(name = "id", updatable = false
   // updatable = false; this means that we don't want anyone to update this column
   // in this table.
   )
   private Long id;

   // nullable = false; this means not null or value cannot be null.
   @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
   private String firstName;

   @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
   private String lastName;

   // unique = true; this means that no two emails can be same.
   // @Column(name = "email", nullable = false, unique = true)
   @Column(name = "email", nullable = false)
   private String email;

   @Column(name = "age", nullable = false)
   private Integer age;

   public Student(String firstName, String lastName, String email, Integer age) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.age = age;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Integer getAge() {
      return age;
   }

   public void setAge(Integer age) {
      this.age = age;
   }

   @Override
   public String toString() {
      return "Student [age=" + age + ", email=" + email + ", firstName=" + firstName + ", id=" + id + ", lastName="
            + lastName + "]";
   }

}
