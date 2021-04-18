package com.bjpowernode.dao;

/**
 * @author X
 * date 2021/4/14 19:42:39
 */

import com.bjpowernode.domian.Student;

import java.util.List;

/**
 * 接口操作student表
 */

public interface StudentDao {
    //查询student表中所有数据
    public List<Student> selStudents();
    //插入数据
    public int  insertStudents(Student student);

    public int  deleteStudents(Student student);

    public int updateStudents(Student student);
}
