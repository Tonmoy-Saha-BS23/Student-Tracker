package com.bs23.SpringMvc.Tymeleaf.repository;

import com.bs23.SpringMvc.Tymeleaf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
