package com.bjpowernode.dao.iml;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domian.Student;
import com.bjpowernode.utils.Mybatisutils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author X
 * date 2021/4/15 16:19:32
 */
public class StudentDaoIml implements StudentDao {

    @Override
    public List<Student> selStudents() {
        System.out.println("--------");
        //5.获取SqlSession对象,从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession= Mybatisutils.getSqlSession();
        System.out.println("sqlSession = " + sqlSession);
        //6.[重要]指定要执行sql语句的标识 sql映射文件中的namespace+"."+标签的id值
        String sqlid="com.bjpowernode.dao.StudentDao"+"."+"selectStudents";
        System.out.println("sqlid = " + sqlid);
        //7.[重要]执行sql语句,通过sqlid找到语句
        List<Student>studentList= sqlSession.selectList(sqlid);
        System.out.println(studentList.size());
        //8.输出结果
//        studentList.forEach(stu-> System.out.println(stu));

        //9.关闭sqlSession对象
        sqlSession.close();
        return studentList;
    }
}
