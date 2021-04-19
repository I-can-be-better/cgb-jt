package com.bjpowernode;

import com.bjpowerndoe.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author X
 * date 2021/4/19 16:03:44
 */
public class MyTest05 {
    @Test
    public void tset01(){
        String config="ba05/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        Student student=(Student)ac.getBean("mystudent");
        System.out.println("student = " + student);
    }
}
