package day25;

public class Demol_6 {
    /**
     * 1.在同步代码块中，用哪个对象锁，就用哪个对象调用wait方法
     * 2.为什么wait方法和notify方法定义在Object这类中?
     *      因为锁对象可以是任意对象，Object是所有的类的基类，所以wait方法和notify方法需要定义在Object这个类中
     * 3.sleep方法和wait方法的区别：？
     *      sleep方法必须传入参数，参数就是时间，时间到了自动醒来
     *      wait方法可以传入参数也可以不传入参数，传入参数就是在参数的时间结束后等待，不传入就是直接等待
     *      sleep方法在同步函数或同步代码块中，不释放锁
     *      wait方法在同步函数或者同步代码块中，释放锁
     * @param args
     */
    public static void main(String[] args){

    }
}
