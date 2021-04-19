package com.bjpowernode;

import com.bjpowerndoe.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.Date;

/**
 * @author X
 * date 2021/4/18 17:11:49
 */
public class MyTest03 {
    //使用conctrutor-arg标签
    @Test
    public void test01() {
        String config = "ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取student对象
        Student student = (Student) ac.getBean("mystudent");
        Date mydate = (Date) ac.getBean("mydate");
        System.out.println("student对象= " + student);
        System.out.println("当前时间:" + mydate);
    }

    //使用index属性
    @Test
    public void test02() {
        String config = "ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("mystudent2");
        System.out.println("student = " + student);
    }

    //省略index
    @Test
    public void test03() {
        String config = "ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("mystudent3");
        System.out.println("student = " + student);
    }

    @Test
    public void test04(){
        String config="ba03/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        File myfile = (File) ac.getBean("myfile");
        System.out.println("myfile = " + myfile.getName());
    }


}
