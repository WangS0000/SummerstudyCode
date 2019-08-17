package day25;

public class Demol_1_02 {
    public static void main(String[] args){
        Singleton3 s1=Singleton3.s;
        Singleton3 s2=Singleton3.s;
        System.out.println(s1==s2);
    }
}
class Singleton3{
    //1.私有构造方法，其他类不能访问该构造方法了
    private Singleton3 (){}
    //2.声明一个引用
    public static final Singleton3 s=new Singleton3();
}