package com.bjpowernode.ba03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author X
 * date 2021/4/19 19:40:25
 */



@Component("mystudent")
public class Student {
    /**
     * 简单类型的属性赋值
     * 属性:value是String类型的,表示简单类型的属性值
     * 位置:
     *      1.在属性定义的上面,无须set方法,推荐使用
     *      2.在set方法的上面
     */
    @Value(value ="张三")
    private String name;
    @Value(value = "19")
    private Integer age;

    /**
     * 引用类型
     * @Autowired:spring框架提供的注解,实现应用类型的赋值
     * spring中通过注解给引用类型赋值,使用的是自动注入原理,支持byName,byType
     *
     * @Autowired:默认使用的是byType自动注入
     * 位置:
     *      1.在属性定义的上面,无须set方法,推荐使用
     *      2.在set方法的上面
     */
    @Autowired
    private School school;

    public Student() {
        System.out.println("mystudent的无参构造");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
