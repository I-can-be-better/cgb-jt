package com.bjpowernode;

import com.bjpowerndoe.service.SomeService;
import com.bjpowerndoe.service.iml.SomeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author X
 * date 2021/4/18 17:11:49
 */
public class MyTest {
    @Test
    public void test01(){
        SomeService service = new SomeServiceImpl();
        service.dosome();
    }

    /**
     * spring创建对象的时间:在创建spring的容器时,会创建配置文件的所有对象
     * spring创建对象:默认调用的是无参构造方法
     */
    @Test
    public void test02(){
        //使用spring容器创建的对象
        //1.指定spring配置稳健的名称
        String config="beans.xml";
        //2.创建表示spring容器的对象,ApplicationContext
        //ApplicationContext就是表示spring容器,通过容器获取对象
        //ClassPathXmlApplicationContext:表示从类路径中加载spring的配置文件
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        //从容器中获取某个对象,你要调用的方法
        //getBean("配置文件中的bean的id值")
        SomeService service=(SomeService) ac.getBean("someService");

        //使用spring创建好的对象
        service.dosome();
    }

    /**
     * 获取spring容器中java对象的信息
     */
    @Test
    public void test03(){
        String config="beans.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        //使用spring提供的方法,获取容器中定义的对象的数量
        int nums=ac.getBeanDefinitionCount();
        System.out.println("容器中定义的对象数量是" + nums);
        //容器中每个定义的对象的名称
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
    }

    @Test
    public void test04(){
        String config="beans.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        //使用getBean();
        Date mydate = (Date)ac.getBean("mydate");
        System.out.println("当前时间为" + mydate);
    }
}
