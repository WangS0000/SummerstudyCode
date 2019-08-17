package com.example.notificationtest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private NotificationManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button)findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
        manager =(NotificationManager)getSystemService(NOTIFICATION_SERVICE);//需要一个NotificationManager 来对通知进行管理，可以调用Context 的getSystemService()方法获取到。
        //getSystemService()方法接收一个字符串参数用于确定获取系统的哪个服务， 这里我们传入Context.NOTIFICATION_SERVICE 即可
    }
    @Override
    @RequiresApi(api=Build.VERSION_CODES.O)//放不放没有多大影响
    public void onClick(View view){
        switch(view.getId()){
            case R.id.send_notice:
                Intent intent = new Intent(this,NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
                    //Build.VERSION.SDK_INT的含义：App安装在手机上，该手机对应的操作系统的版本号
                    //Build.VERSION_CODES.O = 26 （操作系统的版本号是26）
                NotificationChannel notificationChannel = new NotificationChannel("channel","channelname",NotificationManager.IMPORTANCE_HIGH);
                manager.createNotificationChannel(notificationChannel);
            }
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"channel")//表示这条消息属于channel渠道(只是一个id，与上文中的channelID是承接关系)
                        .setContentTitle("This is content title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pi)
                        .setAutoCancel(true)
                        .setVibrate(new long[]{0,1000,1000,1000})
                        .setLights(Color.BLUE,1000,1000)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setContentText("Learn how to build notifications ,send and sync data ,and use voice actions")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("Learn how to build notifications ,send and sync data ,and use voice actions ."))
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setPriority(NotificationCompat.PRIORITY_MAX);//横幅
                manager.notify(1,builder.build());
                break;
                default:
                    break;
        }
    }
}
