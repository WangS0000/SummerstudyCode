package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demol_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server =new ServerSocket(12345);
        Socket socket = server.accept();            //接收客户端的请求
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //将字节流包装成了字符流
        PrintStream ps = new PrintStream(socket.getOutputStream());
        //PrintStream中有写出换行的方法
        ps.println("欢迎咨询黑马程序员");
        System.out.println(br.readLine());
        ps.println("我想报名黑马程序员");
        System.out.println(br.readLine());
        socket.close();
    }
}
