package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
//import com.bjpowernode.dao.iml.StudentDaoIml;
import com.bjpowernode.domian.Student;
import com.bjpowernode.utils.Mybatisutils;
//import org.apache.ibatis.session.SqlSession;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
    private SqlSession sqlSession=null;

    @Test
    public void testSelectStudentById(){
        sqlSession = Mybatisutils.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);

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
    public void testselectMulitObject(){
        sqlSession = Mybatisutils.getSqlSession();
        dao =sqlSession.getMapper(StudentDao.class);
        QueryParam queryParam = new QueryParam();
        queryParam.setParamName("张三");
        queryParam.setParamAge(20);
        List<Student> students = dao.selectMultiObject(queryParam);
        for (Student student : students) {
            System.out.println("student = " + student);
        }
        sqlSession.close();
    }

    @Test
    public void testselectMultiStudent(){
        sqlSession = Mybatisutils.getSqlSession();
        dao =sqlSession.getMapper(StudentDao.class);
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(20);
        List<Student> students = dao.selectMultiStudent(stu);
        for (Student student : students) {
            System.out.println("student = " + student);
        }
        sqlSession.close();
    }

    @Test
    public void testselectMulitPosition(){
            sqlSession = Mybatisutils.getSqlSession();
            dao =sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMulitPosition("张三", 20);
        for (Student student : students) {
                System.out.println("student = " + student);
            }
            sqlSession.close();
    }

    @Test
    public void testselectMulitByMap(){
        sqlSession = Mybatisutils.getSqlSession();
        dao =sqlSession.getMapper(StudentDao.class);
        HashMap<String, Object> data = new HashMap<>();
        data.put("myname","张三");
        data.put("age",20);
        List<Student> students = dao.selectMulitByMap(data);
        for (Student student : students) {
            System.out.println("student = " + student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectUse$(){
        sqlSession = Mybatisutils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectUse$("'李四';select * from user");
        //以上操作,执行了两个sql语句,一个查询语句,一个删除表的语句
        for(Student stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectUse$Order(){
        sqlSession = Mybatisutils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectUse$Order("age");

        for(Student stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }


//    @Test
//    public void testinsertStudent(){
//        dao = Mybatisutils.getSqlSession().getMapper(StudentDao.class);
//        stu.setId(1003);
//        stu.setName("赵云");
//        stu.setEmail("zy@163.com");
//        stu.setAge(35);
//        int num = dao.insertStudents(stu);
//        System.out.println("num = " + num);
//    }
//
//    @Test
//    public void testdeleteStudent(){
//        dao = Mybatisutils.getSqlSession().getMapper(StudentDao.class);
//        stu.setId(1003);
//        int num = dao.deleteStudents(stu);
//        System.out.println("num = " + num);
//    }
//
//    @Test
//    public void testupdateStudents(){
//        dao = Mybatisutils.getSqlSession().getMapper(StudentDao.class);
//        stu.setId(1002);
//        stu.setName("老汪");
//        int num = dao.updateStudents(stu);
//        System.out.println("num = " + num);
//    }
}
