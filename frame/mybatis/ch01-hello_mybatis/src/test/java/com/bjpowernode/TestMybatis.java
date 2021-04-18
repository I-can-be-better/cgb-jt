package com.bjpowernode;

import com.bjpowernode.domian.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author X
 * date 2021/4/15 09:56:52
 */
public class TestMybatis {
    //测试方法,测试功能
    private SqlSession sqlSession = null;

    @Test
    public void testInsert() throws IOException {
        //访问Mybatis读取student数据
        //1.定义mybatis主配置文件的名称,从类的路径的跟开始(target/classes)
        String config = "mybatis.xml";
        //2.读取这个config这个表示的文件
        System.out.println("------");
        InputStream in = Resources.getResourceAsStream(config);
        System.out.println("in = " + in);
        //3.创建了sqlSessionFactoryBuild对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        System.out.println("builder = " + builder);
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        System.out.println("factory = " + factory);
        //5.获取SqlSession对象,从SqlSessionFactory中获取SqlSession
        sqlSession = factory.openSession();
        //6.[重要]指定要执行sql语句的标识 sql映射文件中的namespace+"."+标签的id值
        String sqlid = "com.bjpowernode.dao.StudentDao" + "." + "insertstudent";
        //7.[重要]执行sql语句,通过sqlid找到语句
        Student student = new Student();
        student.setId(1004);
        student.setName("黄牛");
        student.setEmail("ll@163.com");
        student.setAge(23);
        int num = sqlSession.insert(sqlid, student);
        /**
         * mybatis默认不是自动提交事务的,所以在insert,update,delete后要手动提交事务
         */
        sqlSession.commit();
        //8.输出结果
        System.out.println("执行insert的结果" + num);
        //9.关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
        //访问Mybatis读取student数据
        //1.定义mybatis主配置文件的名称,从类的路径的跟开始(target/classes)
        String config = "mybatis.xml";
        //2.读取这个config这个表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建了sqlSessionFactoryBuild对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);

        //5.获取SqlSession对象,从SqlSessionFactory中获取SqlSession
        sqlSession = factory.openSession();

        //6.[重要]指定要执行sql语句的标识 sql映射文件中的namespace+"."+标签的id值
        String sqlid = "com.bjpowernode.dao.StudentDao" + "." + "deletestudent";

        //7.[重要]执行sql语句,通过sqlid找到语句

        int num = sqlSession.delete(sqlid, 1004);
        /**
         * mybatis默认不是自动提交事务的,所以在insert,update,delete后要手动提交事务
         */
        sqlSession.commit();
        //8.输出结果
        System.out.println("执行insert的结果" + num);
        //9.关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //访问Mybatis读取student数据
        //1.定义mybatis主配置文件的名称,从类的路径的跟开始(target/classes)
        String config = "mybatis.xml";
        //2.读取这个config这个表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建了sqlSessionFactoryBuild对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5.获取SqlSession对象,从SqlSessionFactory中获取SqlSession
        /**
         * 此时可实现自动提交
         */
        sqlSession = factory.openSession(true);
        //6.[重要]指定要执行sql语句的标识 sql映射文件中的namespace+"."+标签的id值
        String sqlid = "com.bjpowernode.dao.StudentDao" + "." + "updatestudent";
        //7.[重要]执行sql语句,通过sqlid找到语句
        Student student = new Student();
        student.setName("陈晓宇");
        student.setId(1003);
        int num = sqlSession.update(sqlid, student);
        /**
         * mybatis默认不是自动提交事务的,所以在insert,update,delete后要手动提交事务
         */
//        sqlSession.commit();
        //8.输出结果
        System.out.println("执行insert的结果" + num);
        //9.关闭sqlSession对象
        sqlSession.close();
    }
}
