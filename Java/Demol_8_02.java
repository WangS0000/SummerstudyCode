package day25;

public class Demol_8_02 {
    public static void main(String[] args){
        ThreadGroup tg=new ThreadGroup("����һ���µ��߳���!");   //�����µ��߳���
        MyRunnable mr=new MyRunnable();                               //����Runnable���������
        Thread t1=new Thread(tg,mr,"����");                    //���߳�t1��������
        Thread t2=new Thread(tg,mr,"����");                    //���߳�t2��������
        System.out.println(t1.getThreadGroup().getName()+t1.getName());//��ȡ����
        System.out.println(t2.getThreadGroup().getName()+t2.getName());//��ȡ����

        tg.setDaemon(true);         //����Ϊ�ػ��߳�
        //tg.setDaemon(false);      //����Ϊ�û��߳�
        //������������ԣ���ôĬ��Ϊ�û��߳�
    }
}
