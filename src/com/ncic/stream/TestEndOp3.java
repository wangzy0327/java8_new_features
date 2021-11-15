package com.ncic.stream;

import com.ncic.stream.pojo.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 终止操作 收集
 *
 * 用于给Stream中的元素进行汇总
 * <R,A> R collect(Collector<? super<T,A,R>> collector)
 *
 * 方法形参 ： Collector接口
 * 方法的实参：应该是Collector接口的实例 -> 实例如何获取？
 *           有一个类Collectors类，里面提供了各种方法，返回给我们Collector接口的实例
 *
 */
public class TestEndOp3 {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student(1,"lili",19,160.8),
                new Student(2,"beibei",20,170.8),
                new Student(3,"lili",19,160.8),
                new Student(4,"lili",19,160.8),
                new Student(5,"jingjing",21,160.8),
                new Student(6,"huanhuan",22,167.8),
                new Student(7,"nini",17,150.8),
                new Student(8,"nana",24,190.8),
                new Student(9,"lingling",30,165.8)
        );

        System.out.println("=======================collector list=========================");

        //把所有学生的名字进行提取放入指定的List集合:
        List<String> list1 = list.stream()
                .map((x) -> x.getName())
                .collect(Collectors.toList());
        for(String a:list1)
            System.out.println(a);


        //把所有学生的名字进行提取放入指定的Set集合:

        System.out.println("=======================collector set=========================");
        Set<String> set = list.stream()
                .map((x) -> x.getName())
                .collect(Collectors.toSet());
        for(String a:set)
            System.out.println(a);


        //把所有学生的名字进行提取放入指定的Map集合:
        System.out.println("=======================collector map=========================");
        Map<Integer, String> collect = list.stream()
                .collect(Collectors.toMap((x) -> x.getId(), (y) -> y.getName()));

        Set<Map.Entry<Integer, String>> entries = collect.entrySet();
        for(Map.Entry<Integer,String> entry:entries){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }


        //求总人数
        System.out.println("=======================collector counting=========================");
        Long sum = list.stream()
                .collect(Collectors.counting());
        System.out.println(sum);

        System.out.println("=======================collector avg=========================");
        //求身高的平均值
        Double height = list.stream()
                .collect(Collectors.averagingDouble((x) -> x.getHeight()));
        System.out.println("身高平均值: "+height);

        System.out.println("=======================collector sum=========================");
        //求总身高
        Double heightSum = list.stream()
                .collect(Collectors.summingDouble((x) -> x.getHeight()));
        System.out.println("身高总值："+heightSum);

        //求身高最大
        System.out.println("=======================collector max=========================");
        Optional<Student> maxHeight = list.stream()
                .collect(Collectors.maxBy((x, y) -> Double.compare(x.getHeight(), y.getHeight())));
        System.out.println("身高最大："+maxHeight.orElse(new Student()).getHeight());

        System.out.println("=======================collector groupBy Age=========================");
        //根据年龄分组
        Map<Integer, List<Student>> ageMap = list.stream()
                .collect(Collectors.groupingBy((x) -> x.getAge()));

        Set<Map.Entry<Integer, List<Student>>> entries1 = ageMap.entrySet();
        for(Map.Entry<Integer, List<Student>> entry1 : entries1)
            System.out.println(entry1.getKey()+" : "+entry1.getValue());

        System.out.println("=======================collector Partition Age >= 18=========================");
        //分区 满足条件的在一个区，不满足条件的在一个区
        Map<Boolean, List<Student>> partition = list.stream().collect(Collectors.partitioningBy((x) -> x.getAge() >= 18));

        Set<Map.Entry<Boolean, List<Student>>> entries2 = partition.entrySet();

        for(Map.Entry<Boolean,List<Student>> entry:entries2){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }


        System.out.println("=======================name join=========================");
        //连接
        String nameJoin = list.stream()
                .map((x) -> x.getName())
                .collect(Collectors.joining(","));

        System.out.println(nameJoin);



    }
}
