package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.iml.StudentDaoIml;
import com.bjpowernode.domian.Student;
import com.bjpowernode.utils.Mybatisutils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author X
 * date 2021/4/15 09:56:52
 */
public class TestMybatis {
    //测试方法,测试功能
    private SqlSession sqlSession = null;

    @Test
    public void testSelectStudent(){
//        StudentDao dao = Mybatisutils.getSqlSession().getMapper(StudentDao.class);
        StudentDao dao = new StudentDaoIml();
        List<Student> stuList = dao.selStudents();
        System.out.println("====================");
        for(Student stu:stuList){
            System.out.println(stu);
        }
        System.out.println("====================");
    }


}
