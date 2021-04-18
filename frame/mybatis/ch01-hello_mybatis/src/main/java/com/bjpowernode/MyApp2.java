package com.bjpowernode;


import com.bjpowernode.domian.Student;
import com.bjpowernode.utils.Mybatisutils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * @author X
 * date 2021/4/14 20:31:00
 */
public class MyApp2 {
    public static void main(String[] args) throws IOException {
        //5.获取SqlSession对象,从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession= Mybatisutils.getSqlSession();
        //6.[重要]指定要执行sql语句的标识 sql映射文件中的namespace+"."+标签的id值
        String sqlid="com.bjpowernode.dao.StudentDao"+"."+"selectStudent";
        //7.[重要]执行sql语句,通过sqlid找到语句
        List<Student>studentList= sqlSession.selectList(sqlid);
        //8.输出结果
//        studentList.forEach(stu-> System.out.println(stu));
        for(Student stu:studentList){
            System.out.println("查询的学生"+stu);
        }
        //9.关闭sqlSession对象
        sqlSession.close();
    }
}
