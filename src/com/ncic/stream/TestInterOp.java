package com.ncic.stream;

import com.ncic.stream.pojo.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream流的中间操作
 *
 *  筛选与切片
 *
 */
public class TestInterOp {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("lili",19,160.8),
                new Student("beibei",20,170.8),
                new Student("lili",19,160.8),
                new Student("lili",19,160.8),
                new Student("jingjing",21,160.8),
                new Student("huanhuan",22,167.8),
                new Student("nini",17,150.8),
                new Student("nana",24,190.8),
                new Student("lingling",30,165.8)
                );

        // filter

        //1.创建Stream
        Stream<Student> s1 = list.stream();
        //2.中间操作
        //找年龄大于18的学生
        Stream<Student> s2 = s1.filter((x) -> x.getAge() >= 18);
        //3.终止操作  惰性计算  如果只执行计算的话，不会出现最后结果
        s2.forEach(System.out::println);

        System.out.println("=======================filter=========================");

        //流水线的链式操作

        list.stream()
            .filter((x) -> {
                System.out.println("正在进行过滤！");
                return x.getAge() >= 19;
            }).forEach(System.out::println);

        System.out.println("=======================limit=========================");

        //limit 方法 短路的 （效率高）,只要找到2个满足条件的，后面的迭代操作就不进行了

        list.stream()
            .filter((x)->{
                System.out.println("正在进行过滤");
                return x.getAge()>=19;
            })
            .limit(2)
            .forEach(System.out::println);

        System.out.println("======================skip==========================");

        //skip 方法 跳过前两个满足条件的，对后面进行操作

        list.stream()
                .filter((x)->{
                    System.out.println("正在进行过滤");
                    return x.getAge()>=19;
                })
                .skip(2)
                .forEach(System.out::println);

        System.out.println("======================distinct==========================");

        //distinct 方法 去重 需要重写hashcode和equals方法 distinct 实现时底层调用hashcode和equals方法

        list.stream()
                .distinct() //去重
                .forEach(System.out::println);


    }
}
