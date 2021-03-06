package com.bjpowernode.handler;

import com.bjpowernode.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author X
 * date 2021/4/20 11:10:20
 */
public class MyIncationHandler implements InvocationHandler {
    //目标对象
    private Object target;//SomeServiceImpl类

    public MyIncationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过代理对象,会调用执行这个invoke()
        System.out.println("执行了MyIncationHandler中的invoke()方法");
        System.out.println("method名称:" + method.getName());
        String methodname = method.getName();
        Object res = null;
        if ("dosome".equals(methodname)) {
            ServiceTools.dolog();//在目标方法之前,输出时间
            //执行目标类的方法,通过Method类实现
            res = method.invoke(target, args);//SomeServiceImpl.dosome()
            ServiceTools.doTrans();//在目标方法执行之后,提交事务
        }else{
            res = method.invoke(target, args);//SomeServiceImpl.doother()
        }
        //目标方法的执行结果
        return res;
    }
}
