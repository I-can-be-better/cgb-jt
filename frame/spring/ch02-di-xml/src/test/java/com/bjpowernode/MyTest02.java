package com.bjpowernode;

import com.bjpowerndoe.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author X
 * date 2021/4/18 17:11:49
 */
public class MyTest02 {

    @Test
    public void test01() {
        String config = "ba02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
//从容器中获取Student对象
        Student mystudent = (Student) ac.getBean("mystudent");
        System.out.println("mystudent = " + mystudent);
        Date time=(Date)ac.getBean("mydate");
        System.out.println("time = " + time);
    }

}
