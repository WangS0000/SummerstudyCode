package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo2_Server {
    /**
     * 2.�����
     * ����ServerSocket����Ҫָ���˿ںţ�
     * ����ServerSocket��accept()��������һ���ͻ��˵����󣬵õ�һ��Socket
     * ����Socket��getInputStream()��getOutputStream()������ȡ�Ϳͻ���������IO��
     * ���������Զ�ȡ�ͻ��������д�������
     * ���������д�����ݵ��ͻ��˵�������
     * @param args
     */
    public static void main(String[] args) throws IOException {
        ServerSocket sever = new ServerSocket(12345);
        Socket socket = sever.accept();             //���������ܿͻ��˵�����
        InputStream is = socket.getInputStream();   //��ȡ��������������
        OutputStream os = socket.getOutputStream(); //��ȡ�������������
        os.write("�ٶ�һ��".getBytes());             //��������ͻ���д������//���ַ���תΪ�ֽ�����ת��ȥ
        byte[] arr=new byte[1024];
        int len = is.read(arr);                     //��ȡ�ͻ��˷�����������
        System.out.println(new String(arr,0,len));//������ת�����ַ�������ӡ
        socket.close();
    }
}
