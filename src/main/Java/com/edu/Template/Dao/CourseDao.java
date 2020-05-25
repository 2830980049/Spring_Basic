package com.edu.Template.Dao;

import com.edu.Template.Course;
import com.edu.Template.Student;

import java.util.List;

public interface CourseDao {
    void insert(Course course);
    void update(Course course);
    void delete(int id);
    Course find(int id);
    List<Course> findAll();
}
