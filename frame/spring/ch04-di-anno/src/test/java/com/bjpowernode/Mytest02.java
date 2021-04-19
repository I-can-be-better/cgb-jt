package com.bjpowernode;

import com.bjpowernode.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author X
 * date 2021/4/19 20:39:54
 */
public class Mytest02 {
    @Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        Student student=(Student)ac.getBean("Student");
        System.out.println("student = " + student);
    }
}
