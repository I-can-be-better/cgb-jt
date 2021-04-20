package com.bjpowernode.util;

import java.util.Date;

/**
 * @author X
 * date 2021/4/20 10:55:05
 */
public class ServiceTools {
    public static void dolog(){
        System.out.println("非业务方法,方法的执行时间:"+new Date());
    }
    public static void doTrans(){
        //方法的最后,提交事务
        System.out.println("非业务方法,方法的执行完毕,提交事务");
    }
}
