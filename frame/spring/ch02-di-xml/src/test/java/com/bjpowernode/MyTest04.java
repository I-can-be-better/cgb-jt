package com.bjpowernode;

import com.bjpowerndoe.ba04.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author X
 * date 2021/4/19 15:43:22
 */
public class MyTest04 {
    @Test
    public void test01(){
        String config="ba04/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        Student student=(Student)ac.getBean("mystudent");
        System.out.println("student = " + student);
    }
}
