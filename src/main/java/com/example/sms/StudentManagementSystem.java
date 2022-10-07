package com.example.sms;

import com.example.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystem implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystem.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        /**Student student1 = new Student("John","Serry","john123@gmail.com");
        studentRepository.save(student1);

        Student student2 = new Student("Eddy","Fernando","eddy_f33@gmail.com");
        studentRepository.save(student2);

        Student student3 = new Student("Sky","Smith","ss56@gmail.com");
        studentRepository.save(student3);**/
    }
}
