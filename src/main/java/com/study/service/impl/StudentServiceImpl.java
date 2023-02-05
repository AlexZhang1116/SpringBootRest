package com.study.service.impl;

import com.study.dao.StudentDao;
import com.study.exception.StudentNotFoundException;
import com.study.pojo.Student;
import com.study.service.StudentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class StudentServiceImpl implements StudentService {

    StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao){
        super();
        this.studentDao = studentDao;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDao.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDao.deleteById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        Student student = studentDao.findById(id).orElseThrow(() -> new StudentNotFoundException("student", "ID", id));
        return student;
    }

    @Override
    public Student updateStudent(int id, Student student) {
        Optional<Student> byId = studentDao.findById(id);
        if(!byId.isPresent()){
            throw new StudentNotFoundException("student","ID",id);
        }
        Student s = new Student();
        s.setId(id);
        s.setName(student.getName());
        s.setAge(student.getAge());
        s.setEmail(student.getEmail());
        return studentDao.save(s);
    }
}
