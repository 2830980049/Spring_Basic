import com.edu.Template.Course;
import com.edu.Template.Dao.CourseDao;
import com.edu.Template.Dao.SelectDao;
import com.edu.Template.Dao.StudentDao;
import com.edu.Template.Selection;
import com.edu.Template.Student;
import com.edu.Template.StudentRowMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Template {
    @Test
    public void demo1(){
        String sql = "insert into student(name,sex) values(?,?)";
        ApplicationContext context = new ClassPathXmlApplicationContext("template.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        jdbcTemplate.update(sql,new Object[]{"苏苏","女"});
    }

    @Test
    public void demo2(){
        String sql = "update student set name = ? where id=?";
        ApplicationContext context = new ClassPathXmlApplicationContext("template.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        jdbcTemplate.update(sql,"苏酒儿",1);
    }

    @Test
    public void demo3(){
        String[] sql = {
                "insert into student(name,sex) values('苏苏','女')",
                "insert into student(name,sex) values('艾萨','女')",
                "update student set name = '酒儿' where id=1"
        };
        ApplicationContext context = new ClassPathXmlApplicationContext("template.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        jdbcTemplate.batchUpdate(sql);
    }

    @Test
    public void demo4(){
        String sql = "insert into selection(student,course) values(?,?)";
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{1,1001});
        list.add(new Object[]{1,1003});
        ApplicationContext context = new ClassPathXmlApplicationContext("template.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        jdbcTemplate.batchUpdate(sql,list);
    }

    @Test
    public void select(){
        String sql = "select count(*) from student";
        ApplicationContext context = new ClassPathXmlApplicationContext("template.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }

    @Test
    public void selects(){
        String sql = "select name from student where sex = ?";
        ApplicationContext context = new ClassPathXmlApplicationContext("template.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        List<String> names = jdbcTemplate.queryForList(sql,String.class,"女");
        System.out.println(names);
    }

    @Test
    public void MapSelect(){
        String sql = "select * from student where id = ?";
        ApplicationContext context = new ClassPathXmlApplicationContext("template.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        Map<String,Object> stu = jdbcTemplate.queryForMap(sql,2);
        System.out.println(stu);
    }

    @Test
    public void MapSelects(){
        String sql = "select * from student";
        ApplicationContext context = new ClassPathXmlApplicationContext("template.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        List<Map<String,Object>> stus = jdbcTemplate.queryForList(sql);
        System.out.println(stus);
    }

    @Test
    public void EntitySelect(){
        String sql = "select * from student where id = ?";
        ApplicationContext context = new ClassPathXmlApplicationContext("template.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        Student stus = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), 2);
        System.out.println(stus.getName());
    }

    @Test
    public void EntitySelects(){
        String sql = "select * from student";
        ApplicationContext context = new ClassPathXmlApplicationContext("template.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        List<Student> stus = jdbcTemplate.query(sql,  new StudentRowMapper());
        for (Student student:stus)
            System.out.println(student.getName());
    }

    @Test
    public void Students() throws ParseException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("template.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = sdf.format(new Date());
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        Student student1 = new Student(null,"提莫","男", date);
        Student student2 = new Student(1,"苏苏","女生", date);
        StudentDao studentDao = (StudentDao)applicationContext.getBean("StudentDaoImpl");
        studentDao.insert(student1);
        studentDao.update(student2);
        studentDao.delete(4);
        System.out.println(studentDao.find(1));
        System.out.println(studentDao.findAll());
    }

    @Test
    public void Courses() throws ParseException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("template.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        Course course1 = new Course(null,"电影",2);
        Course course2 = new Course(1001,"英语",4);
        CourseDao courseDao = (CourseDao)applicationContext.getBean("CourseDaoImpl");
        courseDao.insert(course1);
        courseDao.update(course2);
        courseDao.delete(1004);
        System.out.println(courseDao.find(1001));
        System.out.println(courseDao.findAll());
    }

    @Test
    public void Selections() throws ParseException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("template.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        List<Selection> selection1 = new ArrayList<Selection>();
        selection1.add(new Selection(2,1003,new Date(),90));
        Selection selection2 = new Selection(1,1003,new Date(),80);
        SelectDao selectDao = (SelectDao)applicationContext.getBean("SelectDaoImpl");
        selectDao.insert(selection1);
        selectDao.update(selection2);
        selectDao.delete(1,1001);
        System.out.println(selectDao.findByCourse(1002));
        System.out.println(selectDao.findByStudent(1));
    }


}
