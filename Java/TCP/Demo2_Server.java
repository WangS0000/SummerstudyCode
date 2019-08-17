package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo2_Server {
    /**
     * 2.服务端
     * 创建ServerSocket（需要指定端口号）
     * 调用ServerSocket的accept()方法接收一个客户端的请求，得到一个Socket
     * 调用Socket的getInputStream()和getOutputStream()方法获取和客户端相连的IO流
     * 输入流可以读取客户端输出流写入的数据
     * 输出流可以写出数据到客户端的输入流
     * @param args
     */
    public static void main(String[] args) throws IOException {
        ServerSocket sever = new ServerSocket(12345);
        Socket socket = sever.accept();             //服务器接受客户端的请求
        InputStream is = socket.getInputStream();   //获取服务器的输入流
        OutputStream os = socket.getOutputStream(); //获取服务器的输出流
        os.write("百度一下".getBytes());             //服务器向客户端写出数据//将字符串转为字节数组转出去
        byte[] arr=new byte[1024];
        int len = is.read(arr);                     //读取客户端发过来的数据
        System.out.println(new String(arr,0,len));//将数据转换成字符串并打印
        socket.close();
    }
}
