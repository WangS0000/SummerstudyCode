package day25;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demol_3 {
    /**
     * 计时器Timer
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Timer t=new Timer();
        //第一个参数是安排的任务，第二个参数是执行的时间，第三个参数是过多长时间再重复执行
        t.schedule(new MyTimerTask(),new Date(119,7,1,19,48,00),3000);
        while(true){
            Thread.sleep(1000);
            System.out.println(new Date());
        }
    }
}
class MyTimerTask extends TimerTask{
    public void run(){
        System.out.println("起床背英语单词!");
    }
}
