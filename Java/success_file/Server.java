package success_file;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ServerSocket sever = new ServerSocket(12345);
        while(true) {
            final Socket socket = sever.accept();             //服务器接受客户端的请求
            new Thread(){
                public void run(){
                    InputStream is = null;   //获取服务器的输入流
                    try {
                        is = socket.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        OutputStream os = socket.getOutputStream(); //获取服务器的输出流
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //os.write("百度一下\r\n".getBytes());//服务器向客户端写出数据//将字符串转为字节数组转出去
                    //os.write("hello ,我是服务器!\r\n".getBytes());
                    // os.write(" ".getBytes());
                    byte[] arr = new byte[1024];
                    int len = 0;                     //读取客户端发过来的数据
                    try {
                        len = is.read(arr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(new String(arr, 0, len));//将数据转换成字符串并打印
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        }
    }
}
