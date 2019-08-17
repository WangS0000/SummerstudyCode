package day27;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Demol_send {
    /**
     * 1.send
     * 创建DatagramSocket,随机端口号
     * 创建DatagramPacket,指定数据，长度，地址，端口
     * 使用DatagramSocket发送DatagramPacket
     * 关闭DatagramSocket
     * @param args
     */
    public static void main(String[] args) throws IOException {
        String str="what are you doing ？";
        DatagramSocket socket=new DatagramSocket();                 //创建Socket相当于创建码头
        DatagramPacket packet=new DatagramPacket(str.getBytes(),str.getBytes().length, InetAddress.getByName("127.0.0.1"),6666);
        //创建Packet相当于创建集装箱
        socket.send(packet);                                        //发货，将数据发送出去
        socket.close();                                             //关闭码头
    }
}
