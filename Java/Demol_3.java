package day25;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demol_3 {
    /**
     * ��ʱ��Timer
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Timer t=new Timer();
        //��һ�������ǰ��ŵ����񣬵ڶ���������ִ�е�ʱ�䣬�����������ǹ��೤ʱ�����ظ�ִ��
        t.schedule(new MyTimerTask(),new Date(119,7,1,19,48,00),3000);
        while(true){
            Thread.sleep(1000);
            System.out.println(new Date());
        }
    }
}
class MyTimerTask extends TimerTask{
    public void run(){
        System.out.println("�𴲱�Ӣ�ﵥ��!");
    }
}
