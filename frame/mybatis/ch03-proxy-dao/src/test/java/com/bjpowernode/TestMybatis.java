package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
//import com.bjpowernode.dao.iml.StudentDaoIml;
import com.bjpowernode.domian.Student;
import com.bjpowernode.utils.Mybatisutils;
//import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author X
 * date 2021/4/15 09:56:52
 */
public class TestMybatis {
    //测试方法,测试功能
//    private SqlSession sqlSession = null;
    private StudentDao dao;
    private Student stu=new Student();

    @Test
    public void testSelectStudent(){
        dao = Mybatisutils.getSqlSession().getMapper(StudentDao.class);
        System.out.println("dao = " + dao);
        /**
         * 使用mybatis动态代理,使用sqlSession.getMapper(dao接口)
         * getMapper能获取dao接口对应的实现类
         */
//        dao = new StudentDaoIml();
        /**
         * List<Student> stuList = dao.selStudents();调用
         * 1.dao对象,类型是StudentDao,全限定名称是com.bjpowernode.dao.StudentDao
         *                              和namespace是一样的
         * 2.方法名称,selectStudents这个方法就是mapper文件中的id值selectStudents
         *
         * 3.通过dao中的方法的返回值也可以确定mybatis要调用的方法
         *          如果返回值时List,调用的是sqlSession.select()方法
         *          如果是返回值是int,或是非List,则看mapper文件中的标签,调用对应的方法
         *
         *mybatis的动态代理:
         *          mybatis根据dao的方法调用,获取执行sql语句的信息
         *          mybatis会根据你的dao接口,创建出一个dao接口的实现类,并创建出这个类的对象
         *          完成sqlSession调用方法,访问数据库
         */
        List<Student> stuList = dao.selStudents();
        for(Student stu:stuList){
            System.out.println(stu);
        }

    }

    @Test
    public void testinsertStudent(){
        dao = Mybatisutils.getSqlSession().getMapper(StudentDao.class);
        stu.setId(1003);
        stu.setName("赵云");
        stu.setEmail("zy@163.com");
        stu.setAge(35);
        int num = dao.insertStudents(stu);
        System.out.println("num = " + num);
    }

    @Test
    public void testdeleteStudent(){
        dao = Mybatisutils.getSqlSession().getMapper(StudentDao.class);
        stu.setId(1003);
        int num = dao.deleteStudents(stu);
        System.out.println("num = " + num);
    }

    @Test
    public void testupdateStudents(){
        dao = Mybatisutils.getSqlSession().getMapper(StudentDao.class);
        stu.setId(1002);
        stu.setName("老汪");
        int num = dao.updateStudents(stu);
        System.out.println("num = " + num);
    }
}
