package test_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class test2_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(54321);
        System.out.println("��������������54321�˿�");
        while(true){
            Socket socket = server.accept();        //���տͻ��˵�����
           new Thread(){                        //����һ���߳�
               public void run(){
                   try{
                       BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));//��ȡ������
                       PrintStream ps = new PrintStream(socket.getOutputStream());     //��ȡ�����
                       String line = br.readLine();             //���ͻ���д�������ݶ�ȡ����
                       line = new StringBuilder(line).reverse().toString();     //��ʽ���
                       ps.println(line);                //��ת��д��ȥ
                   } catch(IOException e){
                       e.printStackTrace();
                   }
               }
           }.start();
        }
    }
}
