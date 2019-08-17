package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Demo1_Client {
    /**
     * 1.客户端
     * 创建Socket连接服务端（指定ip地址，端口号）通过ip地址找对应的服务器
     * 调用Socket的getInputStream()和getOutputStream()方法获取和服务端相连的IO流
     * 输入流可以读取服务器端输出流写出的数据
     * 输出流可以写出数据到服务端的输入流
     * @param args
     */
    public static void main(String[] args) throws IOException {

            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您聊天应用的用户名：");
            String username = sc.nextLine();
            System.out.println("欢迎使用本公司的会话系统");
            System.out.println("已进入聊天室，请输入会话:");
            while(true) {
                Socket socket = new Socket("127.0.0.1", 12345);
                String message = sc.nextLine();
                if(message=="\n"){
                    System.out.println("\n");
                }
                InputStream is = socket.getInputStream();           //获取客户端的输入流
                OutputStream os = socket.getOutputStream();         //获取客户端的输出流
               // byte[] arr = new byte[1024];
                //int len = is.read(arr);                             //读取服务器发过来的数据
               // System.out.println(new String(arr, 0, len));   //将数据转换成字符串并打印
                os.write((username+" : "+message).getBytes());             //客户端向服务器写数据
            }
    }
}
