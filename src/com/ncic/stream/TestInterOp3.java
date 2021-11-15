package com.ncic.stream;

import com.ncic.stream.pojo.Student;

import java.util.Arrays;
import java.util.List;

/**
 * Stream流的中间操作
 *
 *  排序
 *
 */
public class TestInterOp3 {
    public static void main(String[] args) {

        List<Student> list = Arrays.asList(
                new Student("lili",19,160.8),
                new Student("beibei",20,170.8),
                new Student("lili",19,160.8),
                new Student("blili",19,160.8),
                new Student("jingjing",21,160.8),
                new Student("huanhuan",22,167.8),
                new Student("nini",17,150.8),
                new Student("nana",24,190.8),
                new Student("lingling",30,165.8)
        );

        List<Integer> list2 = Arrays.asList(1,4,7,2,3,9,8);

        // sort

        System.out.println("=======================sort=========================");
        /*
        * 自然排序 -》 底层按照内部比较器进行排序 -》 Comparable接口 -》compareTo方法
        * */

        list2.stream()
            .sorted()
            .forEach(System.out::println);


        System.out.println("=======================by yourself sort=========================");

        /*
         * 自定义排序 -》 底层按照外部比较器进行排序 -》 Comparator接口 -》compare方法
         * */
        list.stream()
            .sorted((s1,s2)->{
                if(s1.getAge() == s2.getAge()){
                    return s1.getName().compareTo(s2.getName());
                }else
                    return s1.getAge() - s2.getAge();
            })
            .forEach(System.out::println);


    }
}
