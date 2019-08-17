package day25;

import java.awt.*;
import java.awt.event.*;

public class Demol_18 {
    public static void main(String[] args){
        Frame f=new Frame("我的第一个窗口");
        f.setSize(400,600);
        f.setLocation(500,50);
        f.setIconImage(Toolkit.getDefaultToolkit().createImage("qq.png"));
        Button b1=new Button("按钮一");
        f.add(b1);
        f.setLayout(new FlowLayout());
        //f.addWindowListener(new MyWindowAdapter());
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        b1.addMouseListener(new MouseAdapter() {                    //利用鼠标退出程序
            /*
            @Override
            public void mouseClicked(MouseEvent e){         //单击
                System.exit(0);
            }
             */
            @Override
            public void mouseReleased(MouseEvent e){        //释放
                System.exit(0);
            }
        });
        b1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){            //通过键盘关闭程序
                //System.exit(0);
                //System.out.println(e.getKeyCode());
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    System.exit(0);
                }
            }
        });
        f.setVisible(true);
    }
}
