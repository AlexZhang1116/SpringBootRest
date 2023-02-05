package com.study;

import com.study.controller.StudentController;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

import com.study.dao.StudentDao;
import com.study.pojo.Student;
import com.study.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.engine.Constants;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMainApplicationTest {

    @MockBean
    private StudentService studentService;

    private MockMvc mockMvc;

    @Test
    public void demos(){
        int a = 10;
        assertTrue(a==10);
        assertFalse(a < 5);
        assertEquals(a,10);
    }


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        StudentController controller = new StudentController(studentService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testGetStudentTest(){
        Student t1 = new Student();
        Student t2 = new Student();
        ArrayList<Student> list= new ArrayList<Student>();
        list.add(t1);
        list.add(t2);
        when(studentService.getAllStudents()).thenReturn(list);
        assertEquals(2,studentService.getAllStudents().size());
    }

    @Test
    public void testGetStudentById(){
        int id = 7;
        Student s = new Student();
        s.setId(7);
        when(studentService.getStudentById(id)).thenReturn(s);
        assertEquals(studentService.getStudentById(id).getId(),s.getId());
    }

    @Test
    public void testSaveStudent(){
        Student temp = new Student();
        temp.setId(50);
        temp.setName("TempTest");
        temp.setAge(18);
        temp.setEmail("temp12345@gmail.com");
        when(studentService.saveStudent(temp)).thenReturn(temp);
        assertEquals(temp,studentService.saveStudent(temp));
    }

    @Test
    public void testDeleteStudent() throws Exception {
        studentService.deleteStudent(10);
        verify(studentService,times(1)).deleteStudent(10);
    }

    @Test
    public void testUpdateStudent(){
        Student temp = new Student();
        temp.setId(50);
        temp.setName("TempTest");
        temp.setAge(18);
        temp.setEmail("temp12345@gmail.com");
        when(studentService.updateStudent(temp.getId(),temp)).thenReturn(temp);
        assertEquals(temp,studentService.updateStudent(50,temp));
    }
}
