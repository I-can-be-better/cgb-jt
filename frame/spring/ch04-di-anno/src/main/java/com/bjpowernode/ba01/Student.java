package com.bjpowernode.ba01;

import org.springframework.stereotype.Component;

/**
 * @author X
 * date 2021/4/19 19:40:25
 */

/**
 * @Component是创建对象的,等同于<bean>的功能
 *  属性:value(就是对象的名称,也就是bean的id值),是唯一值
 *          创建的对象在整个spring容器中就一个
 *  位置:在类的上面
 *
 *  @Component(value="myStudent")
 *  等同于
 *  <bean id="myStudent" class="com.bjpowernode.ba01.Student"/>
 *
 * spring中和@Component功能一致,创建对象的注解还有
 *      1.@Repository(用在持久层类的上面的):放在dao的实现类上面,表示创建dao对象,
 *              dao对象是能访问数据库的(是持久性注解)
 *      2.@Service(用在业务层类的上面的):放在service的实现类上面,创建service,
 *              service对象是做业务处理,可以有事务等功能的
 *      3.@Controller(用在控制器的上面的):放在控制器(处理器)类的上面,创建控制器对象
 *              控制器对象,能够接收用户提交的参数,显示请求的处理结果
 *      以上三个注解的使用语法和@Component一样的,都能创建对象,但是这三个注解还要额外的功能,是给项目的对象分层的
 *
 *      使用@Component的时机:
 *          一个类不是以上三种或者不确定时使用
 *
 */

//使用values属性指定对象的名称,调用的是类的无参构造方法
//@Component(value="myStudent")
//省略value,也可运行
@Component("myStudent")
//不指定对象名称,由spring提供默认名称:类名的首字母小写
//@Component
public class Student {
    private String name;
    private Integer age;

    public Student() {
        System.out.println("mystudent的无参构造");
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
