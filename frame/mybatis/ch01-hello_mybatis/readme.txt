ch01-hello_mybatis:第一个入门的mybatis例子

实现步骤:
1.新建student表
2.加入maven的mybatis坐标,mysql驱动的坐标
3.创建实体类,student--保存表中的一行数据的
4.创建持久层的dao接口,定义操作数据库的方法
5.创建一个mybatis使用的配置文件,叫做sql映射文件:
    写sql语句,一般一个表一个sql映射文件,是xml文件
    1.写在接口所在的目录中
    2.文件名称和接口要保持一致
6.创建mybatis的主配置文件:
       一各项目就一个主配置文件
       主配置文件提供了数据库的连接信息和sql映射信息的位置信息
7.创建使用Mybatis类:
    通过mybatis访问数据库

    写工具类简化代码