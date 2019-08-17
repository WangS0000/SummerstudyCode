import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleServer {
    /**
     *服务器端口
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器的端口号为:6666，正在等待客户端连接...");
        Socket socket =serverSocket.accept();
        Scanner scanner=new Scanner(socket.getInputStream());
        scanner.useDelimiter("\n");
        if(scanner.hasNext()){
            System.out.println("客户端发来消息:  "+scanner.next());
        }
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        printStream.println("客户端你好!我是服务端 : " + serverSocket.getLocalPort());
        serverSocket.close();
    }
}
