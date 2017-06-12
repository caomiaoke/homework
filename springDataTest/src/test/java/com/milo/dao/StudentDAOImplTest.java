package com.milo.dao;

import com.milo.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * Created by milo on 17-6-11.
 */
public class StudentDAOImplTest {
    @Test
    public void testQuery(){
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.query();

        for (Student student : students){
            System.out.println("id: " + student.getId()
                    + " ,name: " + student.getName()
                    + ", password: " + student.getPassword()
                    + ", age: "  + student.getAge()
            );
        }
    }

    @Test
    public void testSave(){
        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = new Student();
        student.setName("test");
        student.setPassword("123456");
        student.setAge(56);

        studentDAO.save(student);
    }
}
