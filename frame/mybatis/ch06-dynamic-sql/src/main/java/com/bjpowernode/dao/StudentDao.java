package com.bjpowernode.dao;

/**
 * @author X
 * date 2021/4/14 19:42:39
 */


import com.bjpowernode.domian.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 接口操作student表
 */

public interface StudentDao {
    //动态sql,使用java对象作为参数
    List<Student>selectStudentIf(Student student);

    //where使用
    List<Student>selectStudentwhere(Student student);

    //foreach用法1
    List<Student>selectForeachone(List<Integer>idlist);

    //foreach用法
    List<Student>selectForeachtwo(List<Student>stulist);

    //查询所有的id
    Integer[] selectAllID(@Param("names") List list);

    //使用pagehelper分页数据
    List<Student>selectAll();

    //增加多条记录
    int  insertstudent( List<Student> studentList);

    //删除多条数据
    int deletestudent(@Param("delstu") List<Student>list);

    //更改多条数据
    int updatestudentage(@Param("updateage")Map map);
}
