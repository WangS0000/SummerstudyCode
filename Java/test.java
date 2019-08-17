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
     * Ŀǰ��˵�����Ϳ���ʵ��
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
        this.setLocation(500,50);        //��������λ�ã����꣩
        this.setSize(400,600);  //�������Ĵ�С
        centerPanel();          //���Ϳ�ͽ��տ�
        southPanel();           //��������
        event();                //��ӵ���¼���Ҳ����Ϊ�ؼ���ӹ���
        this.setVisible(true);  //ʹ�������ʾ
    }
    private void centerPanel(){                     //���岼��
        Panel center = new Panel();
        //�����м��panel���
        viewText = new TextArea();                   //��ʾ�ı�����
        sendText = new TextArea(5,1); //��ʾ���Ϳ������У��У�
        center.setLayout(new BorderLayout());        //����Ϊ�߽粼�ֹ�����
        center.add(sendText,BorderLayout.SOUTH);     //���Ϳ�����ϱ�
        center.add(viewText,BorderLayout.CENTER);    //��ʾ������м�
        viewText.setEditable(false);                 //�����Ա༭��ʾ��
        viewText.setBackground(Color.white);         //��ʾ��ı�����ɫΪ��ɫ
        sendText.setFont(new Font("xxx",Font.PLAIN,20));        //���÷��Ϳ�����:new Font("û�����"��Font.PLAINһ�������ʽ,�����С);
        viewText.setFont(new Font("yyy",Font.PLAIN,18));        //������ʾ������:new Font("û�����"��Font.PLAINһ�������ʽ,�����С);
        //sendText.setText("������������ʱʹ�õ��û���:\n");
        this.add(center,BorderLayout.CENTER);
    }
    public void southPanel(){                        //��ʼ�����ؼ�����λ��
        Panel south = new Panel();
        tf = new TextField(30);
        send = new Button("send");             //�������ͼ�
        south.add(tf);                                     //��˳���ߵģ��ֽ������������Ϸ������
        south.add(send);                                   //֮��send���ͼ�������tf���ڵĺ���
        this.add(south,BorderLayout.SOUTH);                //��south���뵽������ ���ñ߽粼�ַ�ʽ ��south����
    }
    public void event(){
        this.addWindowListener(new WindowAdapter(){         //ע���˳�����
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        send.addActionListener(new ActionListener() {       //ע�ᷢ�͹���
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
        sendText.addKeyListener(new KeyAdapter() {          //���̼���(��ݼ�)
            @Override
            public void keyReleased(KeyEvent e){            //�����¼�
                //if(e.getKeyCode()==KeyEvent.VK_ENTER && e.isControlDown())                //����Enter����Ctrl������
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    try {
                        send();                             //���ͣ�Enter��
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
   /* public String getCurrentTime(){
        Date d = new Date();                        //������ǰ���ڶ���
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm");
        return sdf.format(d);
    }*/
    private void send() throws IOException {
        String message = sendText.getText();            //��ȡ�������������
        String ip = tf.getText();          //��ȡIP��ַ
        //DatagramSocket socket=new DatagramSocket();     //����˿ںţ��൱������ͷ
        //DatagramPacket packet=new DatagramPacket(message.getBytes(),message.getBytes().length, InetAddress.getByName(ip),9999);     //�൱�ڼ�װ�䣬����Ϣ���װ��
        //socket.send(packet);                        //��������
        //String time=getCurrentTime();               //��ȡ��ǰʱ��
        Socket socket = new Socket("127.0.0.1",12345);
        if(message=="\n"){
            System.out.println("\n");
        }
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        viewText.append(username +" : "+message+"\n");                   //����Ϣ��ӵ���ʾ�����У���׷�ӵķ�ʽ��Ŀ���ǣ�Ϊ�˷�ֹ��Ϣ���͵���ʾ�����ʾ������ֱ����
        sendText.setText("");
    }
}
