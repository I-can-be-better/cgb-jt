package com.bjpowernode;

import com.bjpowerndoe.ba06.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author X
 * date 2021/4/19 17:00:54
 */
public class MyTest06 {
    @Test
    public void test01(){
        String config= "ba06/total.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        Student student=(Student)ac.getBean("mystudent");
        System.out.println("student = " + student);
    }
}
