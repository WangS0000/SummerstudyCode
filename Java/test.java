import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test extends Frame {
    /**
     * 目前来说：发送可以实现
     */
    private String username;
    private TextArea viewText;
    private TextArea sendText;
    private TextField tf;
    private Button send;
    public static void main(String[] args){
        new test();
    }
    public test(){
       init();
    }
    public void init(){
        this.setLocation(500,50);        //控制面板的位置（坐标）
        this.setSize(400,600);  //控制面板的大小
        centerPanel();          //发送框和接收框
        southPanel();           //按键布局
        event();                //添加点击事件，也就是为控件添加功能
        this.setVisible(true);  //使画面可显示
    }
    private void centerPanel(){                     //大体布局
        Panel center = new Panel();
        //创建中间的panel面板
        viewText = new TextArea();                   //显示文本区域
        sendText = new TextArea(5,1); //显示发送框区域（行，列）
        center.setLayout(new BorderLayout());        //设置为边界布局管理器
        center.add(sendText,BorderLayout.SOUTH);     //发送框放在南边
        center.add(viewText,BorderLayout.CENTER);    //显示框放在中间
        viewText.setEditable(false);                 //不可以编辑显示框
        viewText.setBackground(Color.white);         //显示框的背景颜色为白色
        sendText.setFont(new Font("xxx",Font.PLAIN,20));        //设置发送框字体:new Font("没多大用"，Font.PLAIN一种字体格式,字体大小);
        viewText.setFont(new Font("yyy",Font.PLAIN,18));        //设置显示框字体:new Font("没多大用"，Font.PLAIN一种字体格式,字体大小);
        //sendText.setText("请输入您聊天时使用的用户名:\n");
        this.add(center,BorderLayout.CENTER);
    }
    public void southPanel(){                        //开始制作控件及其位置
        Panel south = new Panel();
        tf = new TextField(30);
        send = new Button("send");             //制作发送键
        south.add(tf);                                     //按顺序走的，现将发送条放在南方靠左侧
        south.add(send);                                   //之后send发送键，发在tf窗口的后面
        this.add(south,BorderLayout.SOUTH);                //将south加入到容器中 采用边界布局方式 将south居南
    }
    public void event(){
        this.addWindowListener(new WindowAdapter(){         //注册退出功能
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        send.addActionListener(new ActionListener() {       //注册发送功能
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    send();
                } catch (SocketException ex) {
                    ex.printStackTrace();
                } catch (UnknownHostException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        sendText.addKeyListener(new KeyAdapter() {          //键盘监听(快捷键)
            @Override
            public void keyReleased(KeyEvent e){            //键盘事件
                //if(e.getKeyCode()==KeyEvent.VK_ENTER && e.isControlDown())                //按下Enter键和Ctrl键发送
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    try {
                        send();                             //发送（Enter）
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
   /* public String getCurrentTime(){
        Date d = new Date();                        //创建当前日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        return sdf.format(d);
    }*/
    private void send() throws IOException {
        String message = sendText.getText();            //获取发送区域的内容
        String ip = tf.getText();          //获取IP地址
        //DatagramSocket socket=new DatagramSocket();     //随机端口号，相当于是码头
        //DatagramPacket packet=new DatagramPacket(message.getBytes(),message.getBytes().length, InetAddress.getByName(ip),9999);     //相当于集装箱，将信息打包装箱
        //socket.send(packet);                        //发送数据
        //String time=getCurrentTime();               //获取当前时间
        Socket socket = new Socket("127.0.0.1",12345);
        if(message=="\n"){
            System.out.println("\n");
        }
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        viewText.append(username +" : "+message+"\n");                   //将信息添加到显示区域中，以追加的方式，目的是：为了防止信息发送到显示框后，显示框的文字被清除
        sendText.setText("");
    }
}
