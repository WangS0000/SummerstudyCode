import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class test2 {
    public static void main(String[] args) throws IOException {
        ServerSocket sever = new ServerSocket(12345);
        Socket socket = sever.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        os.write("百度一下".getBytes());
        byte[] arr=new byte[1024];
        int len = is.read(arr);
        System.out.println(new String(arr,0,len));
        socket.close();
    }
}
