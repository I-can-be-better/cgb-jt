package com.bjpowernode.utils;

/**
 * @author X
 * date 2021/4/15 15:26:44
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 本类为mybatis工具类
 */
public class Mybatisutils {
    private static SqlSessionFactory factory = null;

    static {
        String config = "mybatis.xml";//需要和你的项目的文件名一样
        try {
            InputStream in = Resources.getResourceAsStream(config);
            //创建SqlSessionFactory,使用SqlSessionFactoryBuild
            factory = new SqlSessionFactoryBuilder().build(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取sqlSession的方法
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        if (factory != null) {
            sqlSession = factory.openSession(true);
        }
        return sqlSession;
    }
}
