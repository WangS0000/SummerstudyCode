package com.example.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private StringBuffer sb=new StringBuffer();
    private StringBuffer str=new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button0=findViewById(R.id.button0);
        Button button1=findViewById(R.id.button1);
        Button button2=findViewById(R.id.button2);
        Button button3=findViewById(R.id.button3);
        Button button4=findViewById(R.id.button4);
        Button button5=findViewById(R.id.button5);
        Button button6=findViewById(R.id.button6);
        Button button7=findViewById(R.id.button7);
        Button button8=findViewById(R.id.button8);
        Button button9=findViewById(R.id.button9);
        Button buttonj=findViewById(R.id.buttonj);
        Button buttonjian=findViewById(R.id.buttonjian);
        Button buttonzuokuo=findViewById(R.id.buttonzuokuo);
        Button buttonyoukuo=findViewById(R.id.buttonyoukuo);
        Button buttonchenG=findViewById(R.id.buttonchenG);
        Button buttonc=findViewById(R.id.buttonc);
        Button buttond=findViewById(R.id.buttond);
        Button buttonDot=findViewById(R.id.buttonDot);
        Button buttons=findViewById(R.id.buttons);
        Button buttonchufa=findViewById(R.id.buttonchufa);
        textView =findViewById(R.id.text_view);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonc.setOnClickListener(this);
        buttonchufa.setOnClickListener(this);
        buttonchenG.setOnClickListener(this);
        buttonjian.setOnClickListener(this);
        buttonj.setOnClickListener(this);
        buttond.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttons.setOnClickListener(this);
        buttonzuokuo.setOnClickListener(this);
        buttonyoukuo.setOnClickListener(this);
    }
    private int count_negative=0;
    private boolean equals=false;
    private int count_bracket_left=0;
    private int count_bracket_right=0;
    private int a=0;
    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.button0:
                if(equals){
                    sb =sb.delete(0,sb.length());
                    equals=false;
                }
                if(sb.length()==0){
                    sb.append("0");
                }else{
                    if(sb.charAt(sb.length()-1)==')'){
                        sb.append("*0");
                    }
                    else{
                        sb.append("0");
                    }
                }
                textView.setText(sb.toString());
                break;
            case R.id.button1:
                if(equals){
                    sb=sb.delete(0,sb.length());
                    equals=false;
                }
                if(sb.length()==0){
                    sb.append("1");
                }else{
                    if(sb.charAt(sb.length()-1)==')'){
                        sb.append("*1");
                    }
                    else{
                        sb.append("1");
                    }
                }
                textView.setText(sb.toString());
                break;
            case R.id.button2:
                if(equals){
                    sb=sb.delete(0,sb.length());
                    equals=false;
                }
                if(sb.length()==0){
                    sb.append("2");
                }else{
                    if(sb.charAt(sb.length()-1)==')'){
                        sb.append("*2");
                    }
                    else{
                        sb.append("2");
                    }
                }
                textView.setText(sb.toString());
                break;
            case R.id.button3:
                if(equals){
                    sb=sb.delete(0,sb.length());
                    equals=false;
                }
                if(sb.length()==0){
                    sb.append("3");
                }else{
                    if(sb.charAt(sb.length()-1)==')'){
                        sb.append("*3");
                    }
                    else{
                        sb.append("3");
                    }
                }
                textView.setText(sb.toString());
                break;
            case R.id.button4:
                if(equals){
                    sb=sb.delete(0,sb.length());
                    equals=false;
                }
                if(sb.length()==0){
                    sb.append("4");
                }else{
                    if(sb.charAt(sb.length()-1)==')'){
                        sb.append("*4");
                    }
                    else{
                        sb.append("4");
                    }
                }
                textView.setText(sb.toString());
                break;
            case R.id.button5:
                if(equals){
                    sb=sb.delete(0,sb.length());
                    equals=false;
                }
                if(sb.length()==0){
                    sb.append("5");
                }else{
                    if(sb.charAt(sb.length()-1)==')'){
                        sb.append("*5");
                    }
                    else{
                        sb.append("5");
                    }
                }
                textView.setText(sb.toString());
                break;
            case R.id.button6:
                if(equals){
                    sb=sb.delete(0,sb.length());
                    equals=false;
                }
                if(sb.length()==0){
                    sb.append("6");
                }else{
                    if(sb.charAt(sb.length()-1)==')'){
                        sb.append("*6");
                    }
                    else{
                        sb.append("6");
                    }
                }
                textView.setText(sb.toString());
                break;
            case R.id.button7:
                if(equals){
                    sb=sb.delete(0,sb.length());
                    equals=false;
                }
                if(sb.length()==0){
                    sb.append("7");
                }else{
                    if(sb.charAt(sb.length()-1)==')'){
                        sb.append("*7");
                    }
                    else{
                        sb.append("7");
                    }
                }
                textView.setText(sb.toString());
                break;
            case R.id.button8:
                if(equals){
                    sb=sb.delete(0,sb.length());
                    equals=false;
                }
                if(sb.length()==0){
                    sb.append("8");
                }else{
                    if(sb.charAt(sb.length()-1)==')'){
                        sb.append("*8");
                    }
                    else{
                        sb.append("8");
                    }
                }
                textView.setText(sb.toString());
                break;
            case R.id.button9:
                if(equals){
                    sb=sb.delete(0,sb.length());
                    equals=false;
                }
                if(sb.length()==0){
                    sb.append("9");
                }else{
                    if(sb.charAt(sb.length()-1)==')'){
                        sb.append("*9");
                    }
                    else{
                        sb.append("9");
                    }
                }
                textView.setText(sb.toString());
                break;
            case R.id.buttons:
                if(equals){
                    equals=false;
                }
                if(sb.length()!=0&&a==0){
                    if(sb.charAt(sb.length()-1)=='-'&&sb.charAt(sb.length()-2)=='('||sb.charAt(sb.length()-1)=='.'&&sb.charAt(sb.length()-2)=='0'){
                        sb=sb.deleteCharAt(sb.length()-1);
                        sb=sb.deleteCharAt(sb.length()-1);
                    }else{
                        sb=sb.deleteCharAt(sb.length()-1);
                    }
                }
                else if(sb.length()!=0&&a==1){
                    sb=sb.delete(0,sb.length());
                }
                textView.setText(sb.toString());
                a=0;
                break;
            case R.id.buttonc:
                if(equals){
                    equals=false;
                }
                sb=sb.delete(0,sb.length());
                textView.setText(sb.toString());
                break;
            case R.id.buttonzuokuo:
                if(equals){
                    equals=false;
                }
                if(sb.length()>0&&(sb.charAt(sb.length()-1)>='0'&&sb.charAt(sb.length()-1)<='9')){
                    sb=sb.append("*(");
                }
                if(sb.length()==0){
                    sb.append("(");
                }
                if(sb.length()>0&&(sb.charAt(sb.length()-1)=='*'||sb.charAt(sb.length()-1)=='/'||sb.charAt(sb.length()-1)=='+'||sb.charAt(sb.length()-1)=='-')){
                    sb=sb.append("(");
                }
                textView.setText(sb.toString());
                break;
            case R.id.buttonyoukuo:
                if(equals){
                    equals=false;
                }
                int count_num=0;
                int Sum=0;
                int num=0;
                count_bracket_left=count_bracket_right=0;
                if(sb.length()!=0){
                    for(int i=sb.length()-1;i>=0;i--){
                        if(count_bracket_left==0&&(sb.charAt(i)>='0'&&sb.charAt(i)<='9')){
                            count_num++;
                        }
                        if(sb.charAt(i)=='('){
                            count_bracket_left++;

                        }
                        if(sb.charAt(i)==')'){
                            count_bracket_right++;
                        }
                    }
                    if((count_bracket_left>count_bracket_right)&&count_num>0){
                        if(sb.charAt(sb.length()-1)!='-'&&sb.charAt(sb.length()-1)!='+'&&sb.charAt(sb.length()-1)!='*'&&sb.charAt(sb.length()-1)!='/'){
                            sb.append(")");
                        }
                    }
                }
                textView.setText(sb.toString());
                break;
            case R.id.buttonj:
                if(equals){
                    equals=false;
                }
                if(sb.length()!=0){
                    if(sb.charAt(sb.length()-1)>='0'&&sb.charAt(sb.length()-1)<='9'||sb.charAt(sb.length()-1)=='.'){
                        if(sb.charAt(sb.length()-1)>='0'&&sb.charAt(sb.length()-1)<='9'){
                            sb.append("+");
                        }
                        if(sb.charAt(sb.length()-1)=='.'){
                            sb.append("0+");
                        }
                    }
                    if(sb.charAt(sb.length()-1)==')'){
                        sb.append("+");
                    }
                }
                a=0;
                textView.setText(sb.toString());
                break;
            case R.id.buttonjian:
                if(equals){
                    equals=false;
                }
                if(sb.length()!=0){
                    if(sb.charAt(sb.length()-1)>='0'&&sb.charAt(sb.length()-1)<='9'||sb.charAt(sb.length()-1)=='.'){
                        if(sb.charAt(sb.length()-1)>='0'&&sb.charAt(sb.length()-1)<='9'){
                            sb.append("-");
                        }
                        if(sb.charAt(sb.length()-1)=='.'){
                            sb.append("0-");
                        }
                    }
                    else if(sb.charAt(sb.length()-1)==')'){
                        sb.append("-");
                    }
                    else if(sb.charAt(sb.length()-1)=='('){
                        sb.append("(-");
                    }
                    else if(sb.charAt(sb.length()-1)=='+'||sb.charAt(sb.length()-1)=='-'||sb.charAt(sb.length()-1)=='*'||sb.charAt(sb.length()-1)=='/'){
                        sb.append("(-");
                    }
                }
                else{
                    sb.append("(-");
                }
                a=0;
                textView.setText(sb.toString());
                break;
            case R.id.buttonchenG:
                if(equals){
                    equals=false;
                }
                if(sb.length()!=0){
                    if(sb.charAt(sb.length()-1)>='0'&&sb.charAt(sb.length()-1)<='9'||sb.charAt(sb.length()-1)=='.'){
                        if(sb.charAt(sb.length()-1)>='0'&&sb.charAt(sb.length()-1)<='9'){
                            sb.append("*");
                        }
                        if(sb.charAt(sb.length()-1)=='.'){
                            sb.append("0*");
                        }
                    }
                    if(sb.charAt(sb.length()-1)==')'){
                        sb.append("*");
                    }
                }
                a=0;
                textView.setText(sb.toString());
                break;
            case R.id.buttonchufa:
                if(equals){
                    equals=false;
                }
                if(sb.length()!=0){
                    if(sb.charAt(sb.length()-1)>='0'&&sb.charAt(sb.length()-1)<='9'||sb.charAt(sb.length()-1)=='.'){
                        if(sb.charAt(sb.length()-1)>='0'&&sb.charAt(sb.length()-1)<='9'){
                            sb.append("/");
                        }
                        if(sb.charAt(sb.length()-1)=='.'){
                            sb.append("0/");
                        }
                    }
                    if(sb.charAt(sb.length()-1)==')'){
                        sb.append("/");
                    }
                }
                a=0;
                textView.setText(sb.toString());
                break;
            case R.id.buttonDot:
                int apps=0;
                if(equals){
                    equals=false;
                }
                if(sb.length()!=0){
                    if(sb.charAt(sb.length()-1)>='0'&&sb.charAt(sb.length()-1)<='9'){
                        for(int i=sb.length()-2;i>=0;i--){
                            if(sb.charAt(i)=='.'){
                                apps=1;
                                break;
                            }
                            else if(sb.charAt(i)=='('||sb.charAt(i)=='+'||sb.charAt(i)=='-'||sb.charAt(i)=='*'||sb.charAt(i)=='/'){
                                break;
                            }
                        }
                        if(apps==0){
                            sb.append(".");
                        }
                    }
                    if(sb.charAt(sb.length()-1)=='('||sb.charAt(sb.length()-1)==')'){
                        if(sb.charAt(sb.length()-1)==')'){
                            sb.append("*0.");
                        }else{
                            sb.append("0.");
                        }
                    }
                    if(sb.charAt(sb.length()-1)=='*'||sb.charAt(sb.length()-1)=='/'||sb.charAt(sb.length()-1)=='+'||sb.charAt(sb.length()-1)=='-'){
                        sb.append("0.");
                    }
                }
                else{
                    sb.append("0.");
                }
                textView.setText(sb.toString());
                break;
            case R.id.buttond:
                int count_left=0;
                int count_right=0;
                if(equals){
                    equals=false;
                }
                if(sb.length()!=0){
                    for(int i=sb.length()-1;i>=0;i--){
                        if(sb.charAt(i)==')'){
                            count_right++;
                        }
                        if(sb.charAt(i)=='('){
                            count_left++;
                        }
                    }
                    if(count_left!=count_right){
                        Toast.makeText(MainActivity.this, "请注意括号匹配！！！", Toast.LENGTH_SHORT).show();
                    }
                    if(count_left==count_right&&(sb.charAt(sb.length()-1)>='0'&&sb.charAt(sb.length()-1)<='9')||sb.charAt(sb.length()-1)==')'){
                        try{
                            textView.setText(InfixToSuffix.Cal(InfixToSuffix.Suffix(sb)));
                            a=1;
                            //利用类名两次调用静态方法，将后缀表达式的结果输出在屏幕上
                            sb=sb.delete(0,sb.length());
                            sb.append(textView.getText().toString());
                        }catch(Exception e){
                            textView.setText("Error!!!");
                            sb=sb.delete(0,sb.length());
                        }
                    }
                }
                break;
            default:
                break;
        }
    }
}//如果等号前面是小数点的话，就在小数点后补0

