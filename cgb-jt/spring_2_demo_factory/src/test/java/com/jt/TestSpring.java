package com.jt;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

public class TestSpring {

    @Test
    public void test01(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("application.xml");
        Calendar sf=ac.getBean(Calendar.class);
        System.out.println("当前对象" + sf.toString());
    }

    @Test
    public void test02(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("application.xml");
        Calendar sf= (Calendar) ac.getBean("calendar");
        System.out.println("sf = " + sf);
    }
}
