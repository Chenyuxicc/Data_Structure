package com.chen.test;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/3/30 on 16:46
 **/
class Apple{
    public int price;
//    public Apple(int price){
//        this.price=price;
//    }
    public Apple(int price){
        this.price=price;
    }
}
//测试方法传入的是地址还是值，引用类型/基本类型/包装类型
//引用类型和包装类型传进来的都是地址，区别在于包装类型是final的，如果需要对其值进行修改，就会新创建一个包装类型对象，并指向该对象
//基本类型传入的是值
public class FunctionTest {
    public static Apple test1(Apple a){
        a.price++;
        System.out.println("test1函数内部:"+a);//test1函数内部:com.chen.test.Apple@73035e27
        return a;
    }
    public static int test2(int a){
        ++a;
        System.out.println("test2 a:"+System.identityHashCode(a));//输出 test2 a:1239731077
        return a;
    }
    public static int test3(Integer a){
        System.out.println("test3 first a:"+System.identityHashCode(a));//输出 test3 first a:42121758
        ++a;
        System.out.println("test3 later a:"+System.identityHashCode(a));//输出 test3 later a:93122545
        return a;
    }
    public static void main(String[] args) {
//        Apple a=new Apple(5);
//        //将实参的传递给了形参,实参是价格为5的这个苹果的地址
//        System.out.println(a); //输出 com.chen.test.Apple@73035e27
//        System.out.println("test:"+test1(a)); //输出 test:com.chen.test.Apple@73035e27
//        System.out.println("price:"+a.price); //输出 price:6

//        int b=5;
//        System.out.println("main b:"+System.identityHashCode(b)); //main b:257895351
//        test2(b);

        Integer b=8;
//        Double c=0.0;
        System.out.println("main b:"+System.identityHashCode(b));//main b:42121758
        test3(b);


    }
}
