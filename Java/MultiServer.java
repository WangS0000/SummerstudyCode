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
         printStream.println("������������������û���:");
        // printStream.println("�û�������username:��userName:��ʽд��");
         if(scanner.hasNextLine()){
             msg=scanner.nextLine();
             Pattern pattern =Pattern.compile("\r");
             Matcher matcher =pattern.matcher(msg);
             msg=matcher.replaceAll("");
             //if(msg.startsWith("userName:")||msg.startsWith("username:")){
               //  String userName = msg.split("\\:")[1];
                 String userName=msg;
                 list.add(userName);//---------------------------------------------------------------ֻ�����һ����������µģ�Ȼ��������Ķ�ɾ��
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
                 //System.out.println("�û���: "+userName+" ע��ɹ�������");
                 printStream.println("�û���: "+userName+",ע��ɹ�������");
                 printStream.println("�ѽ���Ⱥ���죨��ӭʹ�ñ���˾����ϵͳ��ף��ʹ����죩");
                 printStream.println("����˽�ģ�˽�ĸ�ʽΪ��p:+�û���+��-��");
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
                     //System.out.println("�û���: "+userName+" ע��ɹ�������");
                     printStream.println("�û���: "+userName+"ע��ɹ�������");
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
                    /* printStream.println("�����ʽ�����밴�����¸�ʽ����!");
                     printStream.println("ע���û���ʽ����userName:�û�����");
                     printStream.println("Ⱥ�ĸ�ʽ����G:Ⱥ����Ϣ��");
                     printStream.println("˽�ĸ�ʽ����P:userName-˽����Ϣ��");
                     printStream.println("�û��˳���ʽ![����exit����]");
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
                    printStream.println("���Ƚ���ע�����!");
                    printStream.println("ע���ʽΪ:[userName:�û���]");
                }
            }
        }
    }
    private void userRegist(String userName,Socket socket){
        map.put(userName,socket);
        System.out.println("[�û���Ϊ:"+userName+"]ע��ɹ���������[�ͻ���Ϊ:"+socket+"]������");
        System.out.println("��ǰ��������Ϊ:"+map.size()+"��");
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
               // printStream.println(curUser+"˽����˵��"+msg);
               // break;
           // }
       // }
        /*if(i<0){
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            printStream.println("��˽�ĵ��û������ڣ�����");
        }*/
        PrintStream printStream = new PrintStream(client.getOutputStream());
        printStream.println(curUser+"˽����˵��"+msg);
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
        System.out.println("�û�"+userName+"������!");
    }
}
public class MultiServer {
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(6666);
            ExecutorService executorService = Executors.newFixedThreadPool(20);
            for(int i=0;i<20;i++){
                System.out.println("��ӭ����������...");
                Socket socket = serverSocket.accept();
                System.out.println("�������Ѽ���...");
                System.out.println("�û�����ע��...");
                executorService.execute(new Serveres(socket));
            }
            executorService.shutdown();
            serverSocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
