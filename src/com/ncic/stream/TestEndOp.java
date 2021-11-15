package com.ncic.stream;

import com.ncic.stream.pojo.Student;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.IntStream.of;

/**
 * 终止操作 查找 与 匹配
 */
public class TestEndOp {
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

        System.out.println("=======================allMatch=========================");

        //是不是所有的人都是大于18岁的
        boolean b = list.stream()
            .allMatch((x) -> x.getAge()>=18);

        System.out.println(b);

        System.out.println("=======================anyMatch=========================");


        //只要有一个大于18岁就可以了
        boolean b2 = list.stream()
            .anyMatch((x) -> x.getAge() >= 18);

        System.out.println(b2);

        System.out.println("=======================noneMatch=========================");

        //所有都没有匹配的 返回 就是 true
        boolean b3 = list.stream().noneMatch((x) -> x.getAge() >= 18);
        System.out.println(b3);


        System.out.println("=======================findFirst=========================");
        //找到第一个匹配的
        Optional<Student> first = list.stream()
                .sorted((x, y) -> x.getAge() - y.getAge())
                .findFirst();
        System.out.println(first.get());


        Optional<Student> fir = new LinkedList<Student>().stream()
                .sorted((x, y) -> x.getAge() - y.getAge())
                .findFirst();

        System.out.println(fir.orElseGet(()-> new Student("null",0,0.0)));

        Optional<Student> s = Optional.ofNullable(null);
        System.out.println(s.orElse(null));

        System.out.println("=======================count=========================");

        // 返回流中的元素数
        long count = list.stream().count();
        System.out.println(count);

        System.out.println("=======================max=========================");

        // 返回流中的最大元素
        Optional<Student> max = list.stream().max((x,y)->{
            return x.getAge() - y.getAge();
        });
        System.out.println(max.orElse(null));

        System.out.println("=======================min=========================");

        // 返回流中的最小元素
        Optional<Student> min = list.stream().min((x,y)->{
            return x.getAge() - y.getAge();
        });
        System.out.println(min.orElse(null));

        System.out.println("=======================forEach=========================");

        list.stream()
            .forEach(System.out::println);

    }
}
