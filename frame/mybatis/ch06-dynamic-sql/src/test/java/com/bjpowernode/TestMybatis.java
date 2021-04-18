package com.bjpowernode;


import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domian.Student;
import com.bjpowernode.utils.Mybatisutils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author X
 * date 2021/4/15 09:56:52
 */
public class TestMybatis {
    //测试方法,测试功能
//    private SqlSession sqlSession = null;
    private StudentDao dao;
    private SqlSession sqlSession = null;

    @Test
    public void testselectStudentIf() {
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(19);
        List<Student> students = dao.selectStudentIf(stu);
        System.out.println("students = " + students);
        sqlSession.close();
    }

    @Test
    public void testselectStudentwhere() {
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(19);
        List<Student> students = dao.selectStudentwhere(stu);
        System.out.println("students = " + students);
        sqlSession.close();
    }

    @Test
    public void testfor() {
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        String sql = "select * from student where id in";

        StringBuilder builder = new StringBuilder();
        int init = 0;
        int len = list.size();
        //添加开始的小括号
        builder.append("(");
        for (Integer i : list) {
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        //循环结尾
        builder.append(")");
        sql = sql + builder.toString();
        System.out.println("sql = " + sql);
    }

    @Test
    public void testselectForeachone() {
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);

        List<Student> students = dao.selectForeachone(list);
        for (Student student : students) {
            System.out.println("student = " + student);
        }
        sqlSession.close();
    }

    @Test
    public void testselectForeachtwo() {
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        List<Student> stulist = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1002);
        stulist.add(s1);
        s1 = new Student();
        s1.setId(1001);
        stulist.add(s1);

        List<Student> students = dao.selectForeachtwo(stulist);
        for (Student student : students) {
            System.out.println("student = " + student);
        }
        sqlSession.close();
    }

    @Test
    public void testselectAllpagehelper() {
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        /*
        加入pagehelper的方法,分页
        pageNum:第几页,从1开始
        pageSize:一页中有多少行数据
         */
        PageHelper.startPage(1, 3);
        List<Student> students1 = dao.selectAll();
        for (Student student : students1) {
            System.out.println("student = " + student);
        }
        sqlSession.close();
    }

    @Test
    public void testinsertstudent() {
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setId(1007);
        student.setName("陈赫");
        student.setEmail("ch@sine.com");
        student.setAge(28);
        list.add(student);
//        student = new Student();
//        student.setId(1006);
//        student.setName("弹一闪");
//        student.setEmail("tys@ad.com");
//        student.setAge(36);
//        list.add(student);

        int num = dao.insertstudent(list);
        System.out.println("num = " + num);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testdeletestudent() {
        sqlSession = Mybatisutils.getSqlSession();
        System.out.println("=================sqlSession = " + sqlSession);
        dao = sqlSession.getMapper(StudentDao.class);
        System.out.println("===============================dao = " + dao);
        List<Student> ids = new ArrayList<>();
        Student student = new Student();
        student.setId(1001);
        ids.add(student);
        student=new Student();
        student.setId(1002);
        ids.add(student);
        int count = dao.deletestudent(ids);
        if(count>0){
            sqlSession.commit();
            System.out.println("删除成功!");
        }else{
            System.out.println("删除失败!");
        }
        sqlSession.close();
    }

    @Test
    public void testupdateage(){
        sqlSession=Mybatisutils.getSqlSession();
        dao=sqlSession.getMapper(StudentDao.class);
        HashMap<String[], String[]> map = new HashMap<>();
        String[]ids={"20","1003"};
        map.put(ids,ids);
        ids= new String[]{"25", "1004"};
        map.put(ids,ids);
        int count = dao.updatestudentage(map);
        System.out.println("count = " + count);
        sqlSession.commit();
        sqlSession.close();
    }

//    @Test
//    public void tsetselectAllID(){
//        sqlSession=Mybatisutils.getSqlSession();
//        dao=sqlSession.getMapper(StudentDao.class);
//        List lists=new ArrayList();
//        lists.add("");
//        dao.selectAllID();
//
//        System.out.println("list = ");
//        sqlSession.close();
//    }
}
