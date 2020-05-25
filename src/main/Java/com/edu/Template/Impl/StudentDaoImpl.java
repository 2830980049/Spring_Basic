package com.edu.Template.Impl;

import com.edu.Template.Dao.StudentDao;
import com.edu.Template.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("StudentDaoImpl")
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void insert(Student student) {
        String sql = "insert into student(name,sex,born) values(?,?,?)";
        jdbcTemplate.update(sql,student.getName(),student.getSex(),student.getBorn());
    }

    @Override
    public void update(Student student) {
        String sql = "update student set name=?,sex=?,born=? where id=?";
        jdbcTemplate.update(sql,student.getName(),student.getSex(),student.getBorn(),student.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from student where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public Student find(int id) {
        String sql = "select * from student where id=?";
        return jdbcTemplate.queryForObject(sql,new RowMappers(),1);
    }

    @Override
    public List<Student> findAll() {
        String sql = "select * from student";
        return jdbcTemplate.query(sql,new RowMappers());
    }

    private class RowMappers implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setSex(resultSet.getString("sex"));
            student.setBorn(resultSet.getDate("born"));
            return student;
        }
    }
}
