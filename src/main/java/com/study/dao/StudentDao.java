package com.study.dao;

import com.study.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface StudentDao extends JpaRepository<Student, Integer> {
}
