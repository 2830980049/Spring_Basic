package com.edu.Template.Impl;

import com.edu.Template.Dao.SelectDao;
import com.edu.Template.Selection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("SelectDaoImpl")
public class SelectDaoImpl implements SelectDao {
    @Autowired
    private JdbcTemplate template;
    @Override
    public void insert(List<Selection> selections) {
        String sql ="insert into selection values(?,?,?,?)";
        List<Object[]> list = new ArrayList<Object[]>();
        for (Selection selection:selections){
            Object[] s = new Object[4];
            s[0] = selection.getSid();
            s[1] = selection.getCid();
            s[2] = selection.getSelection_time();
            s[3] = selection.getScore();
            list.add(s);
        }
        template.batchUpdate(sql,list);
    }

    @Override
    public void delete(int sid,int cid) {
        String sql = "delete from selection where student=? and course=?";
        template.update(sql,sid,cid);
    }

    @Override
    public void update(Selection selection) {
        String sql = "update selection set selection_time=?,score=? where student=? and course=?";
        template.update(sql,selection.getSelection_time(),selection.getScore(),selection.getSid(),selection.getCid());
    }

    @Override
    public List<Map<String, Object>> findByStudent(int sid) {
        String sql = "select se.*,stu.name sname,c.name cname from selection se " +
                "left join student stu on se.student=stu.id " +
                "left join course c on se.course=c.id " +
                "where student=?";
        return template.queryForList(sql,sid);
    }

    @Override
    public List<Map<String, Object>> findByCourse(int cid) {
        String sql = "select se.*,stu.name sname,c.name cname from selection se " +
                "left join student stu on se.student=stu.id " +
                "left join course c on se.course=c.id " +
                "where course=?";
        return template.queryForList(sql,cid);
    }
}
