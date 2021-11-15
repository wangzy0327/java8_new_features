package com.ncic.lambda;

public interface MyInterface2 {
    /**
     * 省略类型 -> 类型推断
     * @param num
     */
    void testMethod(int num);
}

class Demo2{
    public static void main(String[] args) {
//        MyInterface2 m = (int num) ->{
//            System.out.println("你好！"+num);
//        };
        MyInterface2 m = num -> System.out.println("你好！"+num);
        m.testMethod(10);
    }
}
