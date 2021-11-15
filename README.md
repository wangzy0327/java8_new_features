



## java新特性：Lambda表达式

### lambda表达式本质上就是：接口的实现类的具体的对象

(1) -> 箭头操作符 lambda操作符
(2) () lambda的形参列表 == 接口中的方法的形参列表
(3) {} lambda体 == lambda的方法体内容



### lambda表达式的语法
1) 语法格式1: 无参 无 返回值：
public interface MyInterface{
       void testMethod();
   }

MyInterface m = () -> {System.out.println("在类的复用性少的情况下可以用这种写法我是匿名内部类！！！");}

2) 使用lambda比到达时：接口的实现类的具体的对象 --> 依赖一个接口

这个接口是特殊的接口，这个接口中只有一个抽象方法！！！
只有一个抽象方法的接口 -> 函数式接口


3)内置四大函数式接口：(目的减少同类lambda形参返回形式 冗余接口的书写)

1、消费型接口：interface Consumer<T> void accept(T t)
2、供给型接口：interface Supplier<T> T get()
3、函数型接口：interface Function<T,R> R apply(T t)  y = a*x + b
4、断定型接口（断言式接口）：interface Predicate<T> boolean test(T t) 

用了函数式接口 就可以 ： 再继续考虑是lambda表达式来简化代码


### Stream 流
1) Java8 中有两大最为重要的改变。第一个是Lambda表达式；另外一个则是Stream API
2) Stream API 引入的目的在于弥补Java函数式编程的缺陷
3) 这里的Stream和I/O流不同，它更像具有Iterable的集合类，但行为和集合类又有所不同，Stream 是Java8中处理集合的关键抽象概念，它可以执行
   你希望对集合进行的操作，可以执行非常复杂的查找、过滤和映射数据等操作。使用Stream API对集合数据，在java层面进行操作，就类似于使用SQL
   执行的数据库查询。也可以使用Stream API来并行执行操作。简而言之，Stream API 提供了一种：高效且易于使用的处理数据方式。
4) 为什么要学习 Stream API呢？
   实际开发过程中，项目中多数数据源都是来自于MySQL、Oracle等。但现在数据源可能更多了，有MongoDB、Redis等，而这些NoSQL的数据在数据库中
   查出来，然后就需要Java层面去处理。
5) Stream 和 Collection集合的区别：
   Collection是一种静态的内存数据结构，而Stream是有关计算的。

6) 为什么不在集合类实现这些操作，而是定义了全新的Stream API？Oracle官方给出了几个重要原因：
   一是集合类持有的所有元素都是存储在内存中的，非常巨大的集合类会占用大量的内存，而Stream的元素却是在访问的时候才被计算出来，这种“延迟计算”的特性有点类似Clojure的lazy-seq，占用内存很少。

二是集合类的迭代逻辑是调用者负责，通常是for循环，而Stream的迭代是隐含在对Stream的各种操作中，例如map()。

要理解“延迟计算”，不妨创建一个无穷大小的Stream。

如果要表示自然数集合，显然用集合类是不可能实现的，因为自然数有无穷多个。但是Stream可以做到。

自然数集合的规则非常简单，每个元素都是前一个元素的值+1，因此，自然数发生器用代码实现如下：

```Java
class NaturalSupplier implements Supplier<Long> {

    long value = 0;

    public Long get() {
        this.value = this.value + 1;
        return this.value;
    }
}
```
反复调用get()，将得到一个无穷数列，利用这个Supplier，可以创建一个无穷的Stream：

```java
public static void main(String[] args) {
    Stream<Long> natural = Stream.generate(new NaturalSupplier());
    natural.map((x) -> {
        return x * x;
    }).limit(10).forEach(System.out::println);
}
```

对这个`Stream`做任何`map()`、`filter()`等操作都是完全可以的，这说明Stream API对`Stream`进行转换并生成一个新的`Stream`并非实时计算，而是做了延迟计算。

当然，对这个无穷的`Stream`不能直接调用`forEach()`，这样会无限打印下去。但是我们可以利用`limit()`变换，把这个无穷`Stream`变换为有限的`Stream`。