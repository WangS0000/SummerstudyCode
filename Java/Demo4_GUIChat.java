import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Demo4_GUIChat extends Frame {
    /**
     * GUI����
     * @param args
     */
    private TextField tf;
    private Button send;
    private Button clear;
    private Button shake;
    private Button log;
    private TextArea viewText;
    private TextArea sendText;
    private BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        new Demo4_GUIChat();
    }
    public Demo4_GUIChat() throws IOException {
       init();
       southPanel();
       centerPanel();
       event();
    }
    public void event() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                try {
                    bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    send();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    logFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewText.setText("");
            }
        });
        sendText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()== KeyEvent.VK_ENTER ){
                    try {
                        send();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
    private void logFile() throws IOException {
        bw.flush();                 //ˢ�»�����
        FileInputStream fis=new FileInputStream("config.txt");
        ByteArrayOutputStream baos=new ByteArrayOutputStream();         //���ڴ��д���������
        int len;
        byte[] arr=new byte[8192];
        while((len=fis.read(arr))!=-1){
            baos.write(arr,0,len);
        }
        String str=baos.toString();//���ڴ��е�����ת�������ַ���
        viewText.setText(str);
        fis.close();
    }
    private String getCurrentTime(){
        Date d=new Date();      //������ǰ���ڶ���
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
        return sdf.format(d);       //��ʱ���ʽ��
    }
    public void send() throws IOException {
        String message=sendText.getText();                  //��ȡ�������������
        String ip=tf.getText();                             //��ȡIP��ַ
        ip=ip.trim().length()==0 ? "255,255,255,255":ip;
        DatagramSocket socket = new DatagramSocket();       //����˿ں�
        DatagramPacket packet = new DatagramPacket(message.getBytes(),message.getBytes().length, InetAddress.getByName(ip),9999);
        socket.send(packet);                                //��������
        //viewText.setText(message);//�����꣬���Ϳ�������ٷ�ʱ����ʾ�����һ����Ϣ��ɾ���ˡ�-------------������
        String time = getCurrentTime(); //��ȡ��ǰʱ��
        String str=time + "�Ҷ�"+(ip.equals("255,255,255,255")? "������" : ip)+"˵\r\n"+message+"\r\n\r\n";
        viewText.append(str+"\n");
        bw.write(str);
        sendText.setText("");
        socket.close();
    }
    private void centerPanel() {
        Panel center = new Panel();     //�����м��Panel
        viewText =new TextArea();      //��ʾ���ı�����
        sendText =new TextArea(5,1);      //���͵��ı�����
        center.setLayout(new BorderLayout());   //����Ϊ�߽粼�ֹ�����
        center.add(sendText,BorderLayout.SOUTH);//���͵��ı���������ϱ�
        center.add(viewText,BorderLayout.CENTER);//��ʾ��������м�
        viewText.setEditable(false);            //���ò����Ա༭
        viewText.setBackground(Color.white);    //���ñ�����ɫ
        sendText.setFont(new Font("xxx",Font.PLAIN,20));
        viewText.setFont(new Font("yyy",Font.PLAIN,18));
        this.add(center,BorderLayout.CENTER);
    }
    private void southPanel() {
        Panel south=new Panel();            //�����ϱߵ�panel
        tf = new TextField(15);       //�����ı��ֶδ洢IP��ַ
        tf.setText("127.0.0.1");
        send=new Button("send");
        log =new Button("log");       //������¼��ť
        clear=new Button("clear");
        shake=new Button("shake");
        south.add(tf);
        south.add(send);
        south.add(log);
        south.add(clear);
        south.add(shake);
        this.add(south,BorderLayout.SOUTH);         //��Panel����Frame���ϱ�
    }
    public void init() throws IOException {
        this.setLocation(500,50);
        this.setSize(400,600);
        new Receive().start();
        bw=new BufferedWriter(new FileWriter("config.txt",true));//��Ҫ��β��׷��
        this.setVisible(true);
    }
    private class Receive extends Thread{       //���պͷ�����Ҫͬʱִ�У����Զ���ɶ��߳�
        public void run(){
            try {
                DatagramSocket socket = new DatagramSocket(9999);
                DatagramPacket packet = new DatagramPacket(new byte[8192],8192);
                while(true) {
                    socket.receive(packet);             //������Ϣ
                    byte[] arr = packet.getData();        //��ȡ�ֽ�����
                    int len = packet.getLength();       //��ȡ��Ч���ֽ�����
                    String message = new String(arr, 0, len);//ת�����ַ���
                    String time = getCurrentTime();//��ȡ��ǰʱ��
                    String ip = packet.getAddress().getHostAddress();        //��ȡIP��ַ
                    String str=time + " " + ip + " ����˵��\r\n" + message + "\r\n\r\n";
                    viewText.append(str);
                    bw.write(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
