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
     * GUI聊天
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
        bw.flush();                 //刷新缓冲区
        FileInputStream fis=new FileInputStream("config.txt");
        ByteArrayOutputStream baos=new ByteArrayOutputStream();         //在内存中创建缓冲区
        int len;
        byte[] arr=new byte[8192];
        while((len=fis.read(arr))!=-1){
            baos.write(arr,0,len);
        }
        String str=baos.toString();//将内存中的内容转换成了字符串
        viewText.setText(str);
        fis.close();
    }
    private String getCurrentTime(){
        Date d=new Date();      //创建当前日期对象
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return sdf.format(d);       //将时间格式化
    }
    public void send() throws IOException {
        String message=sendText.getText();                  //获取发送区域的内容
        String ip=tf.getText();                             //获取IP地址
        ip=ip.trim().length()==0 ? "255,255,255,255":ip;
        DatagramSocket socket = new DatagramSocket();       //随机端口号
        DatagramPacket packet = new DatagramPacket(message.getBytes(),message.getBytes().length, InetAddress.getByName(ip),9999);
        socket.send(packet);                                //发送数据
        //viewText.setText(message);//发送完，发送框不清除，再发时，显示框的上一条信息，删除了。-------------不合适
        String time = getCurrentTime(); //获取当前时间
        String str=time + "我对"+(ip.equals("255,255,255,255")? "所有人" : ip)+"说\r\n"+message+"\r\n\r\n";
        viewText.append(str+"\n");
        bw.write(str);
        sendText.setText("");
        socket.close();
    }
    private void centerPanel() {
        Panel center = new Panel();     //创建中间的Panel
        viewText =new TextArea();      //显示的文本区域
        sendText =new TextArea(5,1);      //发送的文本区域
        center.setLayout(new BorderLayout());   //设置为边界布局管理器
        center.add(sendText,BorderLayout.SOUTH);//发送的文本区域放在南边
        center.add(viewText,BorderLayout.CENTER);//显示区域放在中间
        viewText.setEditable(false);            //设置不可以编辑
        viewText.setBackground(Color.white);    //设置背景颜色
        sendText.setFont(new Font("xxx",Font.PLAIN,20));
        viewText.setFont(new Font("yyy",Font.PLAIN,18));
        this.add(center,BorderLayout.CENTER);
    }
    private void southPanel() {
        Panel south=new Panel();            //创建南边的panel
        tf = new TextField(15);       //创建文本字段存储IP地址
        tf.setText("127.0.0.1");
        send=new Button("send");
        log =new Button("log");       //创建记录按钮
        clear=new Button("clear");
        shake=new Button("shake");
        south.add(tf);
        south.add(send);
        south.add(log);
        south.add(clear);
        south.add(shake);
        this.add(south,BorderLayout.SOUTH);         //将Panel放在Frame的南边
    }
    public void init() throws IOException {
        this.setLocation(500,50);
        this.setSize(400,600);
        new Receive().start();
        bw=new BufferedWriter(new FileWriter("config.txt",true));//需要在尾部追加
        this.setVisible(true);
    }
    private class Receive extends Thread{       //接收和发送需要同时执行，所以定义成多线程
        public void run(){
            try {
                DatagramSocket socket = new DatagramSocket(9999);
                DatagramPacket packet = new DatagramPacket(new byte[8192],8192);
                while(true) {
                    socket.receive(packet);             //接收信息
                    byte[] arr = packet.getData();        //获取字节数据
                    int len = packet.getLength();       //获取有效的字节数据
                    String message = new String(arr, 0, len);//转换成字符串
                    String time = getCurrentTime();//获取当前时间
                    String ip = packet.getAddress().getHostAddress();        //获取IP地址
                    String str=time + " " + ip + " 对我说：\r\n" + message + "\r\n\r\n";
                    viewText.append(str);
                    bw.write(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
