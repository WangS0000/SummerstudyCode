package TCP_new;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_Scanner {
    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1",11111);
        while(true){
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            String message1 = sc.nextLine();
            byte[] arr = new byte[1024];
            int len = is.read(arr);
            os.write(message1.getBytes());
            System.out.println(new String (arr,0,len));
        }
    }
}
