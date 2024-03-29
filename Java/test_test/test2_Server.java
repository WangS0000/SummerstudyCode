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
        System.out.println("服务器启动，绑定54321端口");
        while(true){
            Socket socket = server.accept();        //接收客户端的请求
           new Thread(){                        //开启一条线程
               public void run(){
                   try{
                       BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));//获取输入流
                       PrintStream ps = new PrintStream(socket.getOutputStream());     //获取输出流
                       String line = br.readLine();             //将客户端写出的数据读取出来
                       line = new StringBuilder(line).reverse().toString();     //链式编程
                       ps.println(line);                //反转后写回去
                   } catch(IOException e){
                       e.printStackTrace();
                   }
               }
           }.start();
        }
    }
}
