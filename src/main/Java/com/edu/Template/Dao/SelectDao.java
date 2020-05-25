package com.edu.Template.Dao;

import com.edu.Template.Selection;

import java.util.List;
import java.util.Map;

public interface SelectDao {
    void insert(List<Selection> selections);
    void delete(int sid,int cid);
    void update(Selection selection);
    List<Map<String,Object>> findByStudent(int sid);
    List<Map<String,Object>> findByCourse(int cid);
}
