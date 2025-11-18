package com.NewStudentManager.NewStudentManager.service;


import com.NewStudentManager.NewStudentManager.Repository.StudentRepository;
import com.NewStudentManager.NewStudentManager.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repo;
    public StudentService(StudentRepository repo) { this.repo = repo; }
    public Student save(Student s) { return repo.save(s); }
    public List<Student> findAll() { return repo.findAll(); }
}
