package com.ncic.stream;

import com.ncic.stream.pojo.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * Stream流的中间操作
 *
 *  映射
 *
 */
public class TestInterOp2 {
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

        List<String> list2 = Arrays.asList(
                "aa",
                "bb",
                "cc"
                );

        // map

        list2.stream()
            .map((x) -> x.toUpperCase())
            .forEach(System.out::println);

        System.out.println("=======================upperCase=========================");

        list.stream()
            .map(x -> x.getName())
            .forEach(System.out::println);

        System.out.println("=======================Student -> String =========================");

        list.stream()
                .map(Student::getName)
                .forEach(System.out::println);

        System.out.println("=======================Student -> age>=18 -> String(name) =========================");

        list.stream()
                .filter(x -> x.getAge()>=18)
                .map(Student::getName)
                .forEach(System.out::println);

    }
}
