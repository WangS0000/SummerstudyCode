package day25;

public class Demol_8_02 {
    public static void main(String[] args){
        ThreadGroup tg=new ThreadGroup("我是一个新的线程组!");   //创建新的线程组
        MyRunnable mr=new MyRunnable();                               //创建Runnable的子类对象
        Thread t1=new Thread(tg,mr,"张三");                    //将线程t1放入组中
        Thread t2=new Thread(tg,mr,"李四");                    //将线程t2放入组中
        System.out.println(t1.getThreadGroup().getName()+t1.getName());//获取组名
        System.out.println(t2.getThreadGroup().getName()+t2.getName());//获取组名

        tg.setDaemon(true);         //设置为守护线程
        //tg.setDaemon(false);      //设置为用户线程
        //如果不设置属性，那么默认为用户线程
    }
}
