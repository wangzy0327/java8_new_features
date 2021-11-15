package com.ncic.stream;

import com.ncic.stream.pojo.Student;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * 终止操作 归约
 *
 * 将流中的元素反复结合起来进行运算，得到一个值
 *
 */
public class TestEndOp2 {
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

        System.out.println("=======================reduce=========================");


        List<Integer> list2 = Arrays.asList(1,2,3,4,5);
        //reduce
        Integer sum = list2.stream()
            .reduce(0,(x,y)-> x+y);

        System.out.println(sum);



    }
}
