package com.edu.Template.Dao;

import com.edu.Template.Student;

import java.util.List;

public interface StudentDao {
    void insert(Student student);
    void update(Student student);
    void delete(int id);
    Student find(int id);
    List<Student> findAll();
}
