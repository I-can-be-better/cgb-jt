package com.bjpowernode.ba03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author X
 * date 2021/4/19 10:25:14
 */
@Component("school03")
public class School {
    @Value(value ="传智播客*黑马")
    private String name;
    @Value(value ="武汉黄陂")
    private String address;


    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
