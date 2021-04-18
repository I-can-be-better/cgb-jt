package com.bjpowernode.dao;

/**
 * @author X
 * date 2021/4/14 19:42:39
 */

import com.bjpowernode.domian.MyStudent;
import com.bjpowernode.domian.Student;
import com.bjpowernode.vo.QueryParam;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 接口操作student表
 */

public interface StudentDao {
//


    public Student selectStudentById(@Param("studentId") Integer id);


     List <Student> selectMulitParam(@Param("myname")String name,@Param("myage")Integer age);


    List<Student> selectMultiObject(QueryParam param);

    ViewStudent selectStudentResultViewStudent(@Param("sid")Integer id);

    int countStudent();

    //定义一个方法,返回Map
    Map<Object,Object> selectMapById(@Param("stuid") Integer id);

    /**
     * 使用resultMap定义映射关系
     */
    List <Student>selectAllStudents();

    List<MyStudent>selectmystudent();

    List<MyStudent>selectDiffColProperty();

    /**
     * 第一种模糊查询,在java代码中指定like的内容
     */
    List<Student>selectLikeone(@Param("sname") String name);
    /**
     * 第二种方式:在mapper文件中拼接like的内容
     *          在mapper中拼接like "%" 李 "%"
     */
    List<Student>selectLiketwo(@Param("sname1") String name);
}
