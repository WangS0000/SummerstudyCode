package day25;

import java.util.concurrent.*;

public class Demol_11 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool= Executors.newFixedThreadPool(2);
        Future<Integer> f1=pool.submit(new MyCallable(100));
        Future<Integer> f2=pool.submit(new MyCallable(50));
        System.out.println(f1.get());
        System.out.println(f2.get());
        pool.shutdown();
    }
}
class MyCallable implements Callable<Integer>{
    private int num;
    public MyCallable(int num){
        this.num=num;
    }
    @Override
    public Integer call() throws Exception{
        int sum=0;
        for(int i=1;i<=num;i++){
            sum+=i;
        }
        return sum;
    }
}
