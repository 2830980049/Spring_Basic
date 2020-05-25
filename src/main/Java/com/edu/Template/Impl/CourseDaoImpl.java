package com.edu.Template.Impl;

import com.edu.Template.Course;
import com.edu.Template.Dao.CourseDao;
import com.edu.Template.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import sun.util.resources.cldr.pl.TimeZoneNames_pl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("CourseDaoImpl")
public class CourseDaoImpl implements CourseDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void insert(Course course) {
        String sql = "insert into course values(?,?,?)";
        jdbcTemplate.update(sql,course.getId(),course.getName(),course.getScore());
    }
    @Override
    public void update(Course course) {
        String sql = "update course set name=?,score=? where id=?";
        jdbcTemplate.update(sql,course.getName(),course.getScore(),course.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from course where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public Course find(int id) {
        String sql = "select * from course where id=?";
        return jdbcTemplate.queryForObject(sql,new RowMappers(),id);
    }

    @Override
    public List<Course> findAll() {
        String sql = "select * from course";
        return jdbcTemplate.query(sql,new RowMappers());
    }

    private class RowMappers implements RowMapper<Course>{

        @Override
        public Course mapRow(ResultSet resultSet, int i) throws SQLException {
            Course course = new Course();
            course.setId(resultSet.getInt("id"));
            course.setName(resultSet.getString("name"));
            course.setScore(resultSet.getInt("score"));
            return course;
        }
    }
}
