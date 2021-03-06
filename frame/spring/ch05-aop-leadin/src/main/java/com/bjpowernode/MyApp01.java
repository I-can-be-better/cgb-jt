package com.bjpowernode;



import com.bjpowernode.handler.MyIncationHandler;
import com.bjpowernode.service.SomeService;
import com.bjpowernode.service.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author X
 * date 2021/4/20 10:21:52
 */
public class MyApp01 {
    public static void main(String[] args) {
        //调用dosome方法,doother方法
//        SomeService service = new SomeServiceImpl();
//        service.dosome();
//        System.out.println("-------------");
//        service.doother();

        //使用jdk的proxy创建代理对象
        //创建目标对象
        SomeService target = new SomeServiceImpl();

        //创建InvocationHandler(调用处理程序)对象
        InvocationHandler handler = new MyIncationHandler(target);

        //使用proxy创建代理
        SomeService proxy=(SomeService)Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);
        /**
         * 上面第一个蚕食是目标类的类加载器
         * 第二个参数是目标类实现的接口
         * 第三个参数是代理对象
         */

        //通过代理执行方法,会调用handler中的invoke()
        proxy.dosome();
        System.out.println("==============");
        proxy.doother();
    }
}
