package com.jt;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

public class TestSpring {
    //静态工厂模式的测试
    @Test
    public void test01() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        Calendar sf = (Calendar) ac.getBean("calendar01");
        System.out.println("当前对象" + sf.toString());
    }

    //实例化对象的测试
    @Test
    public void test02() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        Calendar sf = (Calendar) ac.getBean("calendar");
        System.out.println("sf = " + sf);
    }

    //spring工厂模式的测试
    @Test
    public void test03() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        Calendar calendar = (Calendar) ac.getBean("calendar03");
        System.out.println("获取当前时间" + calendar.getTime());
    }

    //懒加载的测试
    @Test
    public void tset04() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        User user = ac.getBean(User.class);
        System.out.println("user = " + user);
    }
}
