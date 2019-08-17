import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;

public class ServerThread implements Runnable{
    private Socket mSocket = null;
    private BufferedReader mBufferedReader = null;
    public ServerThread(Socket s)throws IOException{
        mSocket = s;
        mBufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));
    }
    public void run(){
        try{
            String content = null;
            while((content=mBufferedReader.readLine())!=null){
                System.out.println("ip:"+mSocket.getInetAddress().getHostAddress()+":"+content);
                for(Iterator<Socket> it =MyServer.mSocketList.iterator();it.hasNext();){
                    Socket s =it.next();
                    try{
                        OutputStream os =s.getOutputStream();
                        os.write((content+"\n").getBytes("utf-8"));
                    }catch(SocketException e){
                        e.printStackTrace();
                        it.remove();
                    }
                }
            }
        }catch(IOException e){
            System.out.println("接收出错");
            try{
                mSocket.close();
            }catch(IOException e1){
                e1.printStackTrace();
            }
            MyServer.mSocketList.remove(mSocket);
            System.out.println("ip:"+mSocket.getInetAddress().getHostAddress()+"退出聊天室");
        }
    }
}
