package com.study.service;

import com.study.dao.StudentDao;
import com.study.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    void deleteStudent(int id);
    List<Student> getAllStudents();
    Student getStudentById(int id);
    Student updateStudent(int id, Student student);

}
