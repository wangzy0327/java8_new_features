package com.ncic.lambda;

//一般可以在函数式接口前加入一个注解进行限制：@FunctionalInterface
@FunctionalInterface
public interface MyInterface3 {
    int testMethod(int num1,int num2);
}


class Demo3{
    public static void main(String[] args) {
        MyInterface3 m = (x,y) -> {
            System.out.println("第一句话"+x);
            System.out.println("第一句话"+y);
            return 666;
        };
        m.testMethod(10,20);
    }
}