package com.bjpowernode;

import com.bjpowernode.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author X
 * date 2021/4/19 20:01:05
 */

public class MyTest01 {

    /**
     * 本方法测试注解@Component
     */
    @Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        //指定value
//        Student student=(Student)ac.getBean("myStudent");
        //不指定value,由spring提供默认名称
        Student student=(Student)ac.getBean("student01");
        System.out.println("student = " + student);
    }
}
