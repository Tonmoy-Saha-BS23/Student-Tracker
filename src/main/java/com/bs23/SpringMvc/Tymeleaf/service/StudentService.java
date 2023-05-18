package com.bs23.SpringMvc.Tymeleaf.service;

import com.bs23.SpringMvc.Tymeleaf.entity.Student;
import com.bs23.SpringMvc.Tymeleaf.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    public Student create(Student student){
        return studentRepository.save(student);
    }
    public void update(Student student, int id){
        student.setId(id);
        studentRepository.save(student);
    }
    public Optional<Student> finById(int id){
        return studentRepository.findById(id);
    }
    public void delete(int id){
        studentRepository.deleteById(id);
    }
}
