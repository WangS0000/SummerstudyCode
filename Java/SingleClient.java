import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleClient{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",6666);
        PrintStream printStream =  new PrintStream(socket.getOutputStream());
        printStream.println("我是客户端"+socket.getLocalPort());
        Scanner scanner = new Scanner(socket.getInputStream());
        scanner.useDelimiter("\n");
        if(scanner.hasNext()){
            System.out.println(scanner.next());
        }
        socket.close();
    }
}

