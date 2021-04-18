本模块主要用于优化,练习传递参数(深入了解参数)
传入参数:从java代码中把数据传入到mapper文件中的sql语句中
        1.parameterType:写在mapper文件中的一个属性,表示dao接口中方法的参数的数据类型
            <select id="selectStudentById" resultType="com.bjpowernode.domian.Student" parameterType="java.lang.Integer">
                    select * from student where id=#{id}
            </select>

             一个简单类型的参数
                 * 简单类型:mybatis把基本的java基本数据类型和String类型都叫做简单类型,包括基本数据类型的包装类
                 *
                 * 在mapper文件中,要获取简单类型的一个类型的值,使用 #{任意字符}

             多个参数,使用@param命名参数
                接口public List<Student>selectMulitParam(@param("myname")String name,@param("myage")Integer age)
                使用@param("参数名")String name
                mapper文件:
                    <select>
                        select * from student where name=#{myname} or age=#{myage}
                    </select>

#和$:
        #：占位符，告诉 mybatis 使用实际的参数值代替。并使用 PrepareStatement 对象执行 sql 语句, #{…}代替
            sql 语句的“?”。这样做更安全，更迅速，通常也是首选做法，

            mapper 文件
                <select id="selectById" resultType="com.bjpowernode.domain.Student">
                    select id,name,email,age from student where id=#{studentId}
                </select>
             转为 MyBatis 的执行是：
                String sql=” select id,name,email,age from student where id=?”;
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1,1005);
            解释：
                where id=? 就是 where id=#{studentId}
                ps.setInt(1,1005) , 1005 会替换掉 #{studentId}


        $ 字符串替换，告诉 mybatis 使用$包含的“字符串”替换所在位置。使用 Statement 把 sql 语句和${}的
        内容连接起来。主要用在替换表名，列名，不同列排序等操作。
            例 1： 分别使用 id ， email 列查询 Student
            接口方法：
                Student findById(int id);
                Student findByEmail(String email);
            mapper文件:
                <select id="findById" resultType="com.bjpowernode.domain.Student">
                    select * from student where id=#{studentId}
                </select>
                 <select id="findByEmail" resultType="com.bjpowernode.domain.Student">
                    select * from student where email=#{stuentEmail}
                </select>
            测试方法：
                @Test
                public void testFindStuent(){
                    Student student1 = studentDao.findById(1002);
                    System.out.println("findById:"+student1);
                    Student student2 = studentDao.findByEmail("zhou@126.net");
                    System.out.println("findByEmail:"+student2);
                }
            例 2：通用方法，使用不同列作为查询条件
            接口方法：
                Student findByDiffField(@Param("col") String colunName,@Param("cval") Object
            value);
            mapper 文件：
                <select id="findByDiffField" resultType="com.bjpowernode.domain.Student">
                    select * from student where ${col} = #{cval}
                </select>
            测试方法：
                @Test
                public void testFindDiffField(){
                    Student student1 = studentDao.findByDiffField("id",1002);
                    System.out.println("按 id 列查询:"+student1);
                    Student student2 = studentDao.findByDiffField("email","zhou@126.net");
                    System.out.println("按 email 列查询:"+student2);
                    }

$可以替换表名或者列名,只要数据是安全的,就可以使用$

#和$ 的区别:
    1.#使用?在sql语句中做站位,使用preparedStatement执行sql,效率更高
    2.#能避免sql注入,更安全
    3.$不是占位符,是拼接符,是字符串连接的方式,使用statement对象执行对象,效率低
    4.$有sql注入的风险,缺乏安全性
    5.$可以替换表名或列名

mybatis的输出结果:
    mybatis执行了sql语句,得到java对象
    1)resultType结果类型,指sql语句执行完毕后,数据转为java对象,java对象是任意的
                他的值:1.类型的全限定名 2.类型的别名  3.例如:java.lang.Integer别名是int
        处理方式:
            1.mybatis执行sql语句,然后mybatis调用类的无参构造方法,创建对象
            2.mybatis把resultType指定列值赋给同名的属性

        定义自定义类型的别名:
            1)在mybatis主配置文件中定义,使用<typeAlias>定义别名
            2)可以在resulttype中使用自定义别名

resultMap:结果映射,指定列名和java对象的属性对应关系
       使用的时机:
            1.自定义列值赋值给哪个属性
            2.当你的列名和属性名不一样时,一定要使用resultMap
       resultMap和resultType不要一起用,二选一

动态sql:
        sql语句的内容是变化的,可以根据条件获取到不同的sql语句
         主要是where部分发生变化

   动态sql的实现,使用的是mybatis提供的标签,常用标签为<if> <where> <foreach>
        1)<if>是判断条件的
            语法:<if tset="判断java对象的属性值">
                    部分sql语句
                </if>