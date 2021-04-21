package com.jt;

import com.jt.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    @Test
    public void test01() {
        String config = "application.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        User user = (User) ac.getBean("user01");
        user.say();
    }


}
