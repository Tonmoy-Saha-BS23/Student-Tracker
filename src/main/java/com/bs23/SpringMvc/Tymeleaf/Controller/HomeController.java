package com.bs23.SpringMvc.Tymeleaf.Controller;

import com.bs23.SpringMvc.Tymeleaf.entity.Student;
import com.bs23.SpringMvc.Tymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/student")
public class HomeController {
    private final Logger myLogger = Logger.getLogger(HomeController.class.toString());
    @Autowired
    private StudentService studentService;

    @GetMapping("/allStudent")
    public String getAll(Model theModel){
        myLogger.info("Getting all the info of user ");
        List<Student> theStudent = studentService.findAll();
        theModel.addAttribute("theData", theStudent);
        myLogger.info("showing all the student");
        return "hello";
    }

    @GetMapping("/student-from")
    public String showForm(Model theModel){
        myLogger.info("Showing the student form");
        Student student = new Student();
        theModel.addAttribute("theStudent", student);
        return "studentForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("theStudent") Student theStudent){
        myLogger.info("saving the student info to DB");
        studentService.create(theStudent);
        myLogger.info("Saved the student successfully");
        myLogger.info("Going back to all employee page");
        return "redirect:/student/allStudent";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("studentId") int studentId, Model theModel){
        myLogger.info("getting student with the id: " + studentId);
        Optional<Student> student = studentService.finById(studentId);
        theModel.addAttribute("theStudent",student);
        myLogger.info("going to update from");
        return "studentForm";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") int id){
        myLogger.info("Deleting the student with id: "+ id);
        studentService.delete(id);
        myLogger.info("Student has been deleted successfully");
        return "redirect:/student/allStudent";
    }
}
