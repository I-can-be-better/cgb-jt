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
public class MyTest01 {
   @Test
    public void test01(){
       String config="ba01/applicationContext.xml";
       ApplicationContext ac=new ClassPathXmlApplicationContext(config);
       //从容器中获取student对象
       Student student=(Student)ac.getBean("mystudent");
      Date mydate = (Date)ac.getBean("mydate");
      System.out.println("student对象= " + student);
      System.out.println("当前时间:" + mydate);
   }
}
