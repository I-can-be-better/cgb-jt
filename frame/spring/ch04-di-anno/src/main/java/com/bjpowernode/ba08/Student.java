package com.bjpowernode.ba08;

import com.bjpowernode.ba07.School;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author X
 * date 2021/4/19 19:40:25
 */

/**
 * 测试$在注解中的使用
 */

@Component("Students08")
public class Student {
    /**
     * 简单类型的属性赋值
     * 属性:value是String类型的,表示简单类型的属性值
     * 位置:
     *      1.在属性定义的上面,无须set方法,推荐使用
     *      2.在set方法的上面
     */
    @Value("${myname}")
    private String name;
    @Value("${myage}")
    private Integer age;



    public Student() {
        System.out.println("mystudent08的无参构造");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
