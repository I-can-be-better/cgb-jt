package com.bjpowerndoe.ba04;

/**
 * @author X
 * date 2021/4/19 09:06:55
 */
public class Student {
    private String name;
    private int age;

    //声明一个引用类型
    private School school;

    public Student() {
        System.out.println("spring会调用类的无参构造方法创建对象");
    }

    /**
     * 采用set注入的方式对对象进行赋值时,类中必须有相对应的set方法,不然就会报错
     * spring调用的只是set方法,哪怕实体类中没有这个属性,也会执行,只是输出的对象中没有这个属性
     * @param name
     */
    public void setName(String name) {
        System.out.println("setname:"+name);
        this.name = name.toUpperCase();
    }

    public void setAge(int age) {
        System.out.println("setsge:"+age);
        this.age = age;
    }
    public void setemail(String email){
        System.out.println("setemail:"+email);
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
