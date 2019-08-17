import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {
    public static ArrayList<Socket> mSocketList= new ArrayList<>();
    public static void main(String[] args){
        try{
            ServerSocket ss= new ServerSocket(6666);
            while(true){
                Socket s =ss.accept();
                System.out.println("ip: "+s.getInetAddress().getHostAddress()+"加入聊天室");
                mSocketList.add(s);
                new Thread(new ServerThread(s)).start();
            }
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("服务器已崩溃");
            e.printStackTrace();
        }
    }
}
