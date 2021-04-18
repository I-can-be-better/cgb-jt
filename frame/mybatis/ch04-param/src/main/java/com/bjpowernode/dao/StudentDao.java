package com.bjpowernode.dao;

/**
 * @author X
 * date 2021/4/14 19:42:39
 */

import com.bjpowernode.domian.Student;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 接口操作student表
 */

public interface StudentDao {
//    //查询student表中所有数据
//    public List<Student> selStudents();
//    //插入数据
//    public int  insertStudents(Student student);
//
//    public int  deleteStudents(Student student);
//
//    public int updateStudents(Student student);

    /**
     * 一个简单类型的参数
     * 简单类型:mybatis把基本的java基本数据类型和String类型都叫做简单类型,包括基本数据类型的包装类
     *
     * 在mapper文件中,要获取简单类型的一个类型的值,使用 #{任意字符},#叫占位符
     * @param id
     * @return
     */
    public Student selectStudentById(Integer id);

    /**
     * 多个参数:
     *     命名参数,在形参定义的面前加入@Param("自定义参数名称")
     */
     List <Student> selectMulitParam(@Param("myname")String name,@Param("myage")Integer age);

    /**
     * 多个参数,使用java对象作为接口中的方法的参数
     */
    List<Student> selectMultiObject(QueryParam param);

    List<Student> selectMultiStudent(Student student);

    /**
     * 多个参数-按位置传值
     * mybatis3.4之前,使用#{0},#{1}
     * mybatis3.4之后,使用#{arg0},#{arg1}
     */
    List<Student> selectMulitPosition(String name,Integer age);

    /**
     * 多个参数,使用map存放多个值
     */
List<Student>selectMulitByMap( Map<String,Object> map);

    List<Student> selectUse$(@Param("myname") String name);


    List<Student> selectUse$Order(@Param("colName") String colName);
}
