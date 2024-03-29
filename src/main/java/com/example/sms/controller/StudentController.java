package com.example.sms.controller;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // handler method to handle list students and return model and view
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students"; // return a view
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student(); // Create student object to hold student form data
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result,@RequestParam String action) { // Use @ModelAttribute to bind form data to object
        if(action.equals("add")) {
            if (result.hasErrors()) {
                return "create_student";
            }

            System.out.println("Saving student...");
            studentService.saveStudent(student);
        }

        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @Valid @ModelAttribute("student") Student student, BindingResult result,  Model model, @RequestParam String action) {
        // get student from db by id
        if(action.equals("update")) {
            if(result.hasErrors()) {
                return "create_student";
            }

            Student existingStudent = studentService.getStudentById(id);
            existingStudent.setId(id);
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setEmail(student.getEmail());

            System.out.println("Updating student...");
            // save updated object
            studentService.updateStudent(existingStudent);
        } else if(action.equals("goback")) {
            return "redirect:/students";
        }

        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}/details")
    public String getStudentDetails(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "details";
    }
}
