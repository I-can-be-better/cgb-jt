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
    public List<Student> selectStudent();

    //插入数据
    /*
    参数:student,表示要插入到数据库的数据
    返回值:int ,表示执行insert操作后,影响数据库的行数
     */
    public int insertstudent(Student student);

    //删除数据
    public int deletestudent(Student student);

    //更改数据
    public int updatestudent(Student student);
}
