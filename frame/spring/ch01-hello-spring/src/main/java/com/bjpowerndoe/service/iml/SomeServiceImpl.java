package com.bjpowerndoe.service.iml;

import com.bjpowerndoe.service.SomeService;

/**
 * @author X
 * date 2021/4/18 17:10:19
 */
public class SomeServiceImpl implements SomeService {
    public SomeServiceImpl() {
        System.out.println("无参构造");
    }


    @Override
    public void dosome() {
        System.out.println("执行了someServiceIml的dosome()方法");
    }
}
