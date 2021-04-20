package com.bjpowernode;

import com.bjpowernode.ba08.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author X
 * date 2021/4/20 09:32:43
 */
public class MyTest08 {
    @Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        Student student=(Student)ac.getBean("Students08");
        System.out.println("student = " + student);
    }
}
