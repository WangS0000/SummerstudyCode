package day25;

import java.awt.*;

public class Demol_15 {
    public static void main(String[] args){
        Frame f=new Frame("�ҵĵ�һ������");
        f.setSize(400,600);             //���ô����С
        f.setLocation(500,50);                  //���ô���λ��
        f.setIconImage(Toolkit.getDefaultToolkit().createImage("qq.png"));
        Button b1=new Button("��ťһ");
        f.add(b1);
        f.setLayout(new FlowLayout());              //���ò��ֹ�����
        f.setVisible(true);                         //���ô���ɼ�
    }
}
