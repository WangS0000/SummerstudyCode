package day25;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demol_10 {
    /**
     * 线程池
     * public static ExecutorService newFixedThreadPool(int nThreads)
     * public static ExecutorService newSingleThreadExecutor()
     * @param args
     */
    public static void main(String[] args){
        ExecutorService pool= Executors.newFixedThreadPool(2);
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.shutdown();                       //关闭线程池
    }
}
