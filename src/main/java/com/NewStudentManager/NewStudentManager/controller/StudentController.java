package com.NewStudentManager.NewStudentManager.controller;

import com.NewStudentManager.NewStudentManager.Repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.NewStudentManager.NewStudentManager.model.Student;
import com.NewStudentManager.NewStudentManager.service.StudentService;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService service;
    private final StudentRepository studentRepository;

    public StudentController(StudentService service,StudentRepository studentRepository) {
        this.service = service;
        this.studentRepository=studentRepository;
    }

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/register")
    public String showForm(Model m) {
        m.addAttribute("student", new Student());
        return "register"; // ✅ make sure this is "register"
    }


    @PostMapping("/register")
    public String register(@ModelAttribute Student student) {
        service.save(student);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "list"; // this must match list.html in templates
    }
}
