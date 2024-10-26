package com.example.studentREST.controllers;

import com.example.studentREST.entities.Student;
import com.example.studentREST.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/students/{id}")
    public Optional<Student> getStudentByID(@PathVariable Long id){

        return studentService.getStudentByID(id);
    }

    @GetMapping(path = "/students/report")
    public Map<Integer, Integer> ReportGenereation(){
        return studentService.report();
    }

    @GetMapping(path = "/students/report/paginated")
    public Map<Integer, Integer> getPaginatedResults(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int size){

        return studentService.paginatedReport(page, size);
    }


    @PostMapping(path = "/students")
    public String addStudent(@RequestBody Student student){

        return studentService.addStudent(student);
    }

    @PostMapping(path = "/students/{id}")
    public String update(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping(path = "/students/{id}")
    public boolean delete(@PathVariable Long id){

        return studentService.deleteStudent(id);
    }
}
