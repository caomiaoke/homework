package com.milo.dao;

import com.milo.domain.Student;

import java.util.List;

/**
 * Created by milo on 17-6-11.
 */
public interface StudentDAO {
    /**
     * query all students
     * @return
     */
    List<Student>  query();

    public void save(Student student);
}
