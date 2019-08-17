package day25;

public class Demol_8 {
    /**
     * 线程组
     * Java中使用ThreadGroup来表示线程组，它可以对一批线程进行分类管理，Java允许程序直接对线程组进行控制。
     * 默认情况下，所有的线程都属于主线程组
     * public final ThreadGroup getThreadGroup()//通过线程对象获取他属于的组
     * public final String getName()//通过线程组对象获取他组的名字
     * @param args
     */
    public static void main(String[] args){
        MyRunnable mr=new MyRunnable();
        Thread t1=new Thread(mr,"张三");
        Thread t2=new Thread(mr,"李四");
        ThreadGroup tg1=t1.getThreadGroup();
        ThreadGroup tg2=t1.getThreadGroup();
        System.out.println(tg1.getName());//默认主线程
        System.out.println(tg2.getName());//默认主线程
    }
}
class MyRunnable implements Runnable{
    public void run(){
        for(int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"..."+i);
        }
    }
}
