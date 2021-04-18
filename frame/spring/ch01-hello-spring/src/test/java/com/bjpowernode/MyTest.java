package com.bjpowernode;

import com.bjpowerndoe.service.SomeService;
import com.bjpowerndoe.service.iml.SomeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
