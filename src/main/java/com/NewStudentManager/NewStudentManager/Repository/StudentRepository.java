package com.NewStudentManager.NewStudentManager.Repository;

import com.NewStudentManager.NewStudentManager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
