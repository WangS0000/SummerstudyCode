package day25;

public class Demol_1 {
    /**
     * 单例设计模式：保证类在内存中只有一个对象
     * @param args
     */
    public static void main(String[] args){
        /*Singleton s1=Singleton.s;
        Singleton.s=null;
        Singleton s2=Singleton.s;
        System.out.println(s1==s2);*/
        Singleton s1=Singleton.getInstance();
        Singleton s2=Singleton.getInstance();
        System.out.println(s1==s2);
    }
}
//饿汉式：提前创建对象，浪费空间（内存），不浪费时间（比较好）
class Singleton {
    //私有构造方法，其他类不能访问该构造方法
    private Singleton(){
    }
    private static Singleton s=new Singleton();
    //成员变量被私有了，不能通过类名调用
    public static Singleton getInstance(){
        return s;
    }
}
//懒汉式：随用随创建对象，浪费时间，不浪费空间（不太好）-----------也叫：单例的延迟加载模式
class Singleton2{
    //私有构造方法，其他类不能访问该构造方法
    private Singleton2(){}
    //声明一个引用
    private static Singleton2 s;
    //对外提供公共的访问方法
    public static Singleton2 getInstance(){         //获取实例
        if(s==null){//此处会浪费时间
            s=new Singleton2();
        }
        return s;
    }
}
/**
 * 饿汉式和懒汉式的区别：
 * 1.饿汉式是空间换时间，懒汉式是时间换空间
 * 2.在多线程访问时，饿汉式不会创建多个对象，而懒汉式有可能会创建多个对象
 */
