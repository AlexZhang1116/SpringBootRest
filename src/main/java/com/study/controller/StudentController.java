package com.study.controller;

import com.study.pojo.Student;
import com.study.service.StudentService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.PriorityQueue;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    public StudentController(StudentService studentService){
        super();
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
        
        return new ResponseEntity(studentService.getStudentById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") int id){
        return new ResponseEntity<String>("Delete successful!",HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(id,student),HttpStatus.OK);
    }


}
