package day25;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Demol_16 {
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
        f.setVisible(true);
    }
}
/*class MyWindowAdapter extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}*/