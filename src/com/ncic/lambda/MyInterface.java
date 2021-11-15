package com.ncic.lambda;

public interface MyInterface {
    void testMethod();
}

//class MyClass implements MyInterface{
//
//    @Override
//    public void testMethod() {
//        System.out.println("我实现了接口中的方法！！！");
//    }
//}

class Demo{
    public static void main(String[] args) {
        //创建一个实现类的具体的对象
//        MyClass mc = new MyClass();
//        mc.testMethod();

        //匿名类
//        MyInterface m = new MyInterface() {
//            @Override
//            public void testMethod() {
//                System.out.println("在类的复用性少的情况下可以用这种写法我是匿名内部类！！！");
//            }
//        };
        //lambda 表达式就是匿名类的简写形式
        MyInterface m = () -> System.out.println("在类的复用性少的情况下可以用这种写法我是匿名内部类！！！");
        m.testMethod();
    }
}
