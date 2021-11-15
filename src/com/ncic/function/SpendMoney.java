package com.ncic.function;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/**
 * 消费型接口 void accept(T t)
 * 供给型接口 T get()
 * 函数型接口 R apply(T t)
 * 断言型接口 boolean test(T t)
 *
 *
 */
public interface SpendMoney {
    void buy(double money);
}

class X{
    public int a = 10;
}

class Test{
//    public static void buySth(double money,SpendMoney s){
//        s.buy(money);
//    }

    public static void buySth(double money,Consumer s){
        s.accept(money);
    }

    public static void main(String[] args) {
//        buySth(4000, new SpendMoney() {
//            @Override
//            public void buy(double money) {
//                System.out.println("问问马老师，为什么花了"+money+"元？？？");
//            }
//        });

//        buySth(4000,new Consumer<Double>(){
//            public void accept(Double money){
//                System.out.println("问问马老师，为什么花了"+money+"元？？？");
//            }
//        });

        //上面省略写法 Consumer

        final X x = new X();
        System.out.println(x.a);
        buySth(4000, money ->{System.out.println("问问马老师，为什么花了"+money+"元？？？");System.out.println(x.a);});
        x.a = 20;
        buySth(4000, money ->{System.out.println("问问马老师，为什么花了"+money+"元？？？");System.out.println(x.a);});

        Semaphore semaphore = new Semaphore(1);
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

    }
}


