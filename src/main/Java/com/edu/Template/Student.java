package com.edu.Template;

import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Date born;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", born='" + born + '\'' +
                '}';
    }

    public Student(Integer id, String name, String sex, Date born) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.born = born;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }
}
