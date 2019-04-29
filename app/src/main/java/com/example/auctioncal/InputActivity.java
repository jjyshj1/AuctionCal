package com.example.auctioncal;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.auctioncal.databinding.ActivityInputBinding;

public class InputActivity extends AppCompatActivity {

    ActivityInputBinding act;
    String strmoney = "";
    String displaystrmoney = "";
    int intmoney;
    String strintmoney;
    int i;
    boolean numredy = false;
    int numcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        act= DataBindingUtil.setContentView(this,R.layout.activity_input);

        moneyinput();

        act.inputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //strintmoney = String.valueOf(intmoney);

                Intent intent = new Intent();
                //intent.putExtra("strmoney",displaystrmoney);
                //intent.putExtra("strintmoney",strintmoney);
                intent.putExtra("strmoney",strmoney);
                intent.putExtra("intmoney",intmoney);

                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        act.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney="";
                displaystrmoney="";
                act.displayTxt.setText("");
                act.hundredMillion.setEnabled(true);
                act.tenMillion.setEnabled(true);
                act.oneMillion.setEnabled(true);
                act.num1.setEnabled(true);
                act.num2.setEnabled(true);
                act.num3.setEnabled(true);
                act.num4.setEnabled(true);
                act.num5.setEnabled(true);
                act.num6.setEnabled(true);
                act.num7.setEnabled(true);
                act.num8.setEnabled(true);
                act.num9.setEnabled(true);
                act.num0.setEnabled(true);
                numredy = false;
                numcount = 0;
            }
        });
    }




    void moneyinput(){

        act.num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney + "1";
                act.displayTxt.setText(strmoney);
                i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();


            }
        });
        act.num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"2";
                act.displayTxt.setText(strmoney);
                i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"3";
                act.displayTxt.setText(strmoney);
                i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"4";
                act.displayTxt.setText(strmoney);
                i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"5";
                act.displayTxt.setText(strmoney);
                i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"6";
                act.displayTxt.setText(strmoney);
                i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"7";
                act.displayTxt.setText(strmoney);
                i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"8";
                act.displayTxt.setText(strmoney);
                i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"9";
                act.displayTxt.setText(strmoney);
                i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strmoney != "") {
                    strmoney = strmoney + "0";
                    i=Integer.parseInt(strmoney);
                    numredy = true;
                    numcountCheck();


                } else {
                    strmoney = "";
                }
                act.displayTxt.setText(strmoney);
            }
        });

        act.hundredMillion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intmoney =  String.valueOf(Integer.parseInt(strmoney)*100000000);


                if (strmoney!="") {
                    //intmoney = Integer.parseInt(strmoney) * 100000000;
                    if (i < 22){
                        intmoney = i*100000000;
                        //displaystrmoney = strmoney + "억";
                        strmoney = strmoney+"억";
                        //act.displayTxt.setText(displaystrmoney);
                        act.displayTxt.setText(strmoney);
                        ///////strmoney = "";
                        act.hundredMillion.setEnabled(false);
                        numcount=0;
                        act.tenMillion.setEnabled(true);
                        act.oneMillion.setEnabled(true);

                        act.intmoneyTxt.setText(String.format("%,d",intmoney));
                    }
                    else{act.displayTxt.setText("21억 초과 물건은 취급하지 않습니다.");
                          }
                }
                numredy = false;

            }
        });

        act.tenMillion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intmoney = intmoney + String.valueOf(Integer.parseInt(strmoney)*10000000);

                if (numredy==true){
                    Toast.makeText(InputActivity.this, String.valueOf(numredy), Toast.LENGTH_SHORT).show();
                //if (strmoney!="") {
                    //intmoney = intmoney + Integer.parseInt(strmoney) * 10000000;
                    intmoney = intmoney + (i*10000000);
                    //displaystrmoney = displaystrmoney + strmoney + "천";
                    strmoney = strmoney + "천만";
                    //act.displayTxt.setText(displaystrmoney);
                    act.displayTxt.setText(strmoney);
                    //////strmoney = "";
                    numcount=0;
                    act.hundredMillion.setEnabled(false);
                    act.tenMillion.setEnabled(false);

                    act.intmoneyTxt.setText(String.format("%,d",intmoney));
                }
                numredy = false;

            }
        });

        act.oneMillion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intmoney = intmoney + String.valueOf(Integer.parseInt(strmoney)*1000000);
                  if (numredy == true){
                //if (strmoney!="") {
                    //intmoney = intmoney + Integer.parseInt(strmoney) * 1000000;
                    intmoney = intmoney + (i*1000000);
                    //displaystrmoney = displaystrmoney + strmoney + "백만";
                    strmoney = strmoney + "백만";
                    //act.displayTxt.setText(displaystrmoney);
                    act.displayTxt.setText(strmoney);

                      act.intmoneyTxt.setText(String.format("%,d",intmoney));

                    act.hundredMillion.setEnabled(false);
                    act.tenMillion.setEnabled(false);
                    act.oneMillion.setEnabled(false);
                    act.num1.setEnabled(false);
                    act.num2.setEnabled(false);
                    act.num3.setEnabled(false);
                    act.num4.setEnabled(false);
                    act.num5.setEnabled(false);
                    act.num6.setEnabled(false);
                    act.num7.setEnabled(false);
                    act.num8.setEnabled(false);
                    act.num9.setEnabled(false);
                    act.num0.setEnabled(false);
                }
            }
        });

        act.onedeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = act.displayTxt.getText().toString();

                if(text.length() <= 1){
                    act.deleteBtn.performClick();
                }
                else{
                    act.displayTxt.setText(text.substring(0,text.length()-1));
                    strmoney = act.displayTxt.getText().toString();

                }


            }
        });
    }

    void numcountCheck(){
        numcount=numcount+1;
        if (numcount==2){
            act.tenMillion.setEnabled(false);
            act.oneMillion.setEnabled(false);
        }
    }
}
