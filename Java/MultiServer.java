import success_file.Server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Serveres implements Runnable{
   // StringBuffer s = new StringBuffer();
    ArrayList<String> list=new ArrayList<>();
    int i;
    private static Map<String,Socket> map=new ConcurrentHashMap<>();
    private Socket socket;
    public Serveres(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run(){
     try{
         Scanner scanner = new Scanner(socket.getInputStream());
         String msg=null;
         PrintStream printStream = new PrintStream(socket.getOutputStream());
         printStream.println("请输入您用于聊天的用户名:");
        // printStream.println("用户名需以username:或userName:格式写入");
         if(scanner.hasNextLine()){
             msg=scanner.nextLine();
             Pattern pattern =Pattern.compile("\r");
             Matcher matcher =pattern.matcher(msg);
             msg=matcher.replaceAll("");
             //if(msg.startsWith("userName:")||msg.startsWith("username:")){
               //  String userName = msg.split("\\:")[1];
                 String userName=msg;
                 list.add(userName);//---------------------------------------------------------------只能添加一个，添加最新的，然后把其他的都删了
             System.out.println(list.toString());
             System.out.println(list.size());
              //  s.append(userName);
//             for(int j=list.size()-1;j>=0;j--){
//                    System.out.println(list.get(j));
//                }
           /*  char charArr[] =s.toString().toCharArray();
             for(char c : charArr){
                 System.out.println(c);
             }*/
                 userRegist(userName,socket);
                 //System.out.println("用户名: "+userName+" 注册成功！！！");
                 printStream.println("用户名: "+userName+",注册成功！！！");
                 printStream.println("已进入群聊天（欢迎使用本公司聊天系统，祝您使用愉快）");
                 printStream.println("若想私聊，私聊格式为：p:+用户名+“-”");
            // }
         }
         while(true){
             if(scanner.hasNextLine()){
                 msg=scanner.nextLine();
                 Pattern pattern =Pattern.compile("\r");
                 Matcher matcher =pattern.matcher(msg);
                 msg=matcher.replaceAll("");
                 /*if(msg.startsWith("userName:")||msg.startsWith("username:")){
                     String userName = msg.split("\\:")[1];
                     userRegist(userName,socket);
                     //System.out.println("用户名: "+userName+" 注册成功！！！");
                     printStream.println("用户名: "+userName+"注册成功！！！");
                     continue;
                 }*/
                /* if(msg.startsWith("G:")){
                     firstStep(socket);
                     String str = msg.split("\\:")[1];
                     groupChat(socket,str);
                     continue;
                 }*/
                 if((msg.startsWith("P:")||msg.startsWith("p:"))&&msg.contains("-")){
                     firstStep(socket);
                     String userName = msg.split("\\:")[1].split("-")[0];
                     String str=msg.split("\\:")[1].split("-")[1];
                     privateChat(socket,userName,str);
                     continue;
                 }
                 else if(msg.contains("exit")){
                     firstStep(socket);
                     userExit(socket);
                     continue;
                 }
                 else{
                     //PrintStream printStream = new PrintStream(socket.getOutputStream());
                    /* printStream.println("输入格式错误！请按照以下格式输入!");
                     printStream.println("注册用户格式：【userName:用户名】");
                     printStream.println("群聊格式：【G:群聊信息】");
                     printStream.println("私聊格式：【P:userName-私聊信息】");
                     printStream.println("用户退出格式![包含exit即可]");
                     continue;*/
                     firstStep(socket);
                     String str = msg;
                     groupChat(socket,str);
                     continue;
                 }
             }
         }
     }catch(IOException e){
         e.printStackTrace();
     }
    }
    private void firstStep(Socket socket) throws IOException{
        Set<Map.Entry<String,Socket>> set = map.entrySet();
        for(Map.Entry<String,Socket>entry:set){
            if(entry.getValue().equals(socket)){
                if(entry.getKey()==null){
                    PrintStream printStream= new PrintStream(socket.getOutputStream());
                    printStream.println("请先进行注册操作!");
                    printStream.println("注册格式为:[userName:用户名]");
                }
            }
        }
    }
    private void userRegist(String userName,Socket socket){
        map.put(userName,socket);
        System.out.println("[用户名为:"+userName+"]注册成功！！！，[客户端为:"+socket+"]上线了");
        System.out.println("当前在线人数为:"+map.size()+"人");
    }
    private void groupChat(Socket socket,String msg)throws IOException{
        Set<Map.Entry<String,Socket>> set=map.entrySet();
        String userName=null;
        for(Map.Entry<String,Socket>entry:set){
            if(entry.getValue().equals(socket)){
                userName=entry.getKey();
                break;
            }
        }
        for(Map.Entry<String,Socket> entry:set){
            Socket client = entry.getValue();
            PrintStream printStream = new PrintStream(client.getOutputStream());
            printStream.println(userName+":"+msg);
        }
    }
    private void privateChat(Socket socket,String userName ,String msg)throws IOException{
        String curUser=null;
        Set<Map.Entry<String,Socket>> set =map.entrySet();
        for(Map.Entry<String,Socket>entry:set){
            if(entry.getValue().equals(socket)){
                curUser=entry.getKey();
                break;
            }
        }
        Socket client =map.get(userName);
        //for(i=list.size()-1;i>=0;i--){

           // System.out.println(list.get(i));
           // if((list.get(i)).equals(client)){
                //PrintStream printStream = new PrintStream(client.getOutputStream());
               // printStream.println(curUser+"私聊你说："+msg);
               // break;
           // }
       // }
        /*if(i<0){
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            printStream.println("您私聊的用户不存在！！！");
        }*/
        PrintStream printStream = new PrintStream(client.getOutputStream());
        printStream.println(curUser+"私聊你说："+msg);
    }
    private void userExit(Socket socket){
        String userName=null;
        for(String key:map.keySet()){
            if(map.get(key).equals(socket)){
                userName=key;
                break;
            }
        }
        map.remove(userName,socket);
        System.out.println("用户"+userName+"已下线!");
    }
}
public class MultiServer {
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(6666);
            ExecutorService executorService = Executors.newFixedThreadPool(20);
            for(int i=0;i<20;i++){
                System.out.println("欢迎来到聊天室...");
                Socket socket = serverSocket.accept();
                System.out.println("有新朋友加入...");
                System.out.println("用户正在注册...");
                executorService.execute(new Serveres(socket));
            }
            executorService.shutdown();
            serverSocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
