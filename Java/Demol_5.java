package day25;

public class Demol_5 {
    public static void main(String[] args){
        final Printer2 p=new Printer2();
        new Thread(){
            public void run(){
                while(true){
                    try {
                        p.print1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread(){
            public void run(){
                while(true){
                    try {
                        p.print2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread(){
            public void run(){
                while(true){
                    try {
                        p.print3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
class Printer2{
    private int flag=1;
    public void print1() throws InterruptedException {
        synchronized (this){
            while(flag!=1){
                this.wait();
            }
            System.out.print("黑");
            System.out.print("马");
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.print("\r\n");
            flag=2;
            this.notifyAll();
        }
    }
    public void print2() throws InterruptedException {
        synchronized (this){
            while(flag!=2){
                this.wait();
            }
            System.out.print("传");
            System.out.print("智");
            System.out.print("播");
            System.out.print("客");
            System.out.print("\r\n");
            flag=3;
            this.notifyAll();
        }
    }
    public void print3() throws InterruptedException {
        synchronized (this){
            while(flag!=3){
                this.wait();
            }
            System.out.print("a");
            System.out.print("b");
            System.out.print("c");
            System.out.print("d");
            System.out.print("e");
            System.out.print("\r\n");
            flag=1;
            this.notifyAll();
        }
    }
}
