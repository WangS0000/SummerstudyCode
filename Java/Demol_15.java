package day25;

import java.awt.*;

public class Demol_15 {
    public static void main(String[] args){
        Frame f=new Frame("我的第一个窗口");
        f.setSize(400,600);             //设置窗体大小
        f.setLocation(500,50);                  //设置窗体位置
        f.setIconImage(Toolkit.getDefaultToolkit().createImage("qq.png"));
        Button b1=new Button("按钮一");
        f.add(b1);
        f.setLayout(new FlowLayout());              //设置布局管理器
        f.setVisible(true);                         //设置窗体可见
    }
}
