package com.bjpowernode.service.impl;

import com.bjpowernode.service.SomeService;
import com.bjpowernode.util.ServiceTools;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author X
 * date 2021/4/20 10:18:28
 */

//service类的代码不修改,也能够增加输出时间,事务
public class SomeServiceImpl implements SomeService {


    @Override
    public void dosome() {
//        System.out.println("当前时间:"+new Date());
        ServiceTools.dolog();
        System.out.println("执行业务方法dosome()");

        //方法的最后,提交事务
//        System.out.println("方法执行完毕,提交事务");
        ServiceTools.doTrans();
    }

    @Override
    public void doother() {
//        System.out.println("当前时间:"+new Date());
        ServiceTools.dolog();
        System.out.println("执行业务方法doother()");

        //方法的最后,提交事务
//        System.out.println("方法执行完毕,提交事务");
        ServiceTools.doTrans();
    }
}