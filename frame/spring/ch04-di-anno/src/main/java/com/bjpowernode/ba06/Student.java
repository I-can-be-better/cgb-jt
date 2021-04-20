package com.bjpowernode.ba06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author X
 * date 2021/4/19 19:40:25
 */



@Component("Students06")
public class Student {
    /**
     * 简单类型的属性赋值
     * 属性:value是String类型的,表示简单类型的属性值
     * 位置:
     *      1.在属性定义的上面,无须set方法,推荐使用
     *      2.在set方法的上面
     */
    @Value(value ="罗翔")
    private String name;
    @Value(value = "19")
    private Integer age;

    /**
     * 应用类型:来自djk中的注释,spring框架提供了对这个注解的功能支持,可以使用他给应用对象赋值
     *      使用的也是自动注入原理,支持byType,byName,默认是byName
     * 位置:
     *      1.在属性定义上,无须set方法,推荐使用
     *      2.在set方法上
     */
    //默认是byName:先使用byName自动注入,如果byNmae赋值失败,在使用byType
    @Resource
    private School school;

    public Student() {
        System.out.println("mystudent06的无参构造");
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
