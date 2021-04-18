package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
//import com.bjpowernode.dao.iml.StudentDaoIml;
import com.bjpowernode.domian.MyStudent;
import com.bjpowernode.domian.Student;
import com.bjpowernode.utils.Mybatisutils;
//import org.apache.ibatis.session.SqlSession;
import com.bjpowernode.vo.QueryParam;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author X
 * date 2021/4/15 09:56:52
 */
public class TestMybatis {
    //测试方法,测试功能
//    private SqlSession sqlSession = null;
    private StudentDao dao;
    private SqlSession sqlSession=null;

    @Test
    public void testSelectStudentById(){
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1001);
        System.out.println("student = " + student);
        sqlSession.close();
    }

    @Test
    public void testselectMulitParam(){
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = dao.selectMulitParam("张三", 20);
        for (Student student : list) {
            System.out.println("student = " + student);
        }
        sqlSession.close();
    }


    @Test
    public void testselectStudentResultViewStudent(){
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        ViewStudent student = dao.selectStudentResultViewStudent(1001);
        System.out.println("student = " + student);
        sqlSession.close();
    }

    @Test
    public void testcountStudent(){
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        int i = dao.countStudent();
        System.out.println("i = " + i);
        sqlSession.close();
    }

    @Test
    public void testselectMapById(){
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        Map<Object, Object> map = dao.selectMapById(1001);
        System.out.println("map = " + map);
        sqlSession.close();
    }

    @Test
    public void testselectAllStudents(){
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectAllStudents();
        System.out.println("students = " + students);
        sqlSession.close();
    }

    @Test
    public void testselectmystudent(){
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> myStudents = dao.selectmystudent();
        for (MyStudent myStudent : myStudents) {
            System.out.println("myStudent = " + myStudent);
        }
        sqlSession.close();
    }

    @Test
    public void testselectDiffColProperty(){
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> myStudents = dao.selectDiffColProperty();
        for (MyStudent myStudent : myStudents) {
            System.out.println("myStudent = " + myStudent);
        }
        sqlSession.close();
    }

    @Test
    public void testselectLikeone(){
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        //准备数组的内容
        String  sname="李%";
        List<Student> lists = dao.selectLikeone(sname);
        for (Student student : lists) {
            System.out.println("student = " + student);
        }
        sqlSession.close();
    }

    @Test
    public void testselectLiketwo(){
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
        //准备数组的内容

        List<Student> lists = dao.selectLiketwo("四");
        for (Student student : lists) {
            System.out.println("student = " + student);
        }
        sqlSession.close();
    }
}
