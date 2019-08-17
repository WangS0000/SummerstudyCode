package com.example.pro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =(Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView =(ImageView)findViewById(R.id.image_view);
        progressBar =(ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener((View.OnClickListener) this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                /*if(progressBar.getVisibility()==View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);
                }//显示旋转加载进度
                */
                /*imageView.setImageResource(R.drawable.img_2);
                String inputText = editText.getText().toString();
               Toast.makeText(MainActivity.this, inputText,
                        Toast.LENGTH_SHORT).show();
                int progress = progressBar.getProgress();
                progress = progress + 10;
                progressBar.setProgress(progress);//显示加载进度条，点击更换图片，输出文字
                */
               /* AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.
                        this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something important.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.
                        OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog ,int which){

                    }
                        });
                dialog.setNegativeButton("Cancle",new DialogInterface.
                        OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog,int which){

                    }
                });
                dialog.show();//提示信息yes、no界面
                */
               ProgressDialog progressDialog =new ProgressDialog(MainActivity.this);
               progressDialog.setTitle("This is ProgressDialog");
               progressDialog.setMessage("Loading...");
               progressDialog.setCancelable(true);
               progressDialog.show();
                break;
            default:
                break;
        }
    }
}
