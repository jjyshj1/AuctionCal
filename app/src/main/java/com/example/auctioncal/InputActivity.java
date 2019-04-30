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
    int i;
    boolean numredy = false;
    int numcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        act= DataBindingUtil.setContentView(this,R.layout.activity_input);

        moneyinput();

        act.inputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                intmoneycal();

                Intent intent = new Intent();
                intent.putExtra("strmoney",strmoney);
                intent.putExtra("intmoney",intmoney);

                setResult(Activity.RESULT_OK, intent);
                act.deleteBtn.performClick();
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
                //i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();


            }
        });
        act.num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"2";
                act.displayTxt.setText(strmoney);
               // i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"3";
                act.displayTxt.setText(strmoney);
             //   i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"4";
                act.displayTxt.setText(strmoney);
             //   i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"5";
                act.displayTxt.setText(strmoney);
            //    i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"6";
                act.displayTxt.setText(strmoney);
           //    i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"7";
                act.displayTxt.setText(strmoney);
            //    i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"8";
                act.displayTxt.setText(strmoney);
           //     i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"9";
                act.displayTxt.setText(strmoney);
           //     i=Integer.parseInt(strmoney);
                numredy = true;
                numcountCheck();
            }
        });
        act.num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strmoney != "") {
                    strmoney = strmoney + "0";
            //        i=Integer.parseInt(strmoney);
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
                 if (strmoney!="") {

              //      if (i < 22){
            //            intmoney = i*100000000;
                        strmoney = strmoney+"억";
                        act.displayTxt.setText(strmoney);

                        act.hundredMillion.setEnabled(false);
                        numcount=0;
                        act.tenMillion.setEnabled(true);
                        act.oneMillion.setEnabled(true);

             //           act.intmoneyTxt.setText(String.format("%,d",intmoney));
//                    }
//                    else{act.displayTxt.setText("21억 초과 물건은 취급하지 않습니다.");
//                          }
                }
                numredy = false;

            }
        });

        act.tenMillion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numredy==true){
                    //Toast.makeText(InputActivity.this, String.valueOf(numredy), Toast.LENGTH_SHORT).show();

              //      intmoney = intmoney + (i*10000000);

                    strmoney = strmoney + "천";

                    act.displayTxt.setText(strmoney);

                    numcount=0;
                    act.hundredMillion.setEnabled(false);
                    act.tenMillion.setEnabled(false);

             //       act.intmoneyTxt.setText(String.format("%,d",intmoney));
                }
                numredy = false;

            }
        });

        act.oneMillion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  if (numredy == true){

               //     intmoney = intmoney + (i*1000000);

                    strmoney = strmoney + "백만";

                    act.displayTxt.setText(strmoney);

                //    act.intmoneyTxt.setText(String.format("%,d",intmoney));

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



                if(strmoney.length() <= 1){
                    act.deleteBtn.performClick();
                }
                else {
                    act.displayTxt.setText(strmoney.substring(0, strmoney.length() - 1));

                    int ihm = strmoney.indexOf("억");
                    int itm = strmoney.indexOf("천");
                    int im = strmoney.indexOf("백");
                    Toast.makeText(InputActivity.this, String.format("im : %d  / text.length() : %d", ihm, strmoney.length() - 3), Toast.LENGTH_SHORT).show();
                    if (ihm == strmoney.length() - 3) {
                        act.tenMillion.setEnabled(true);
                        act.oneMillion.setEnabled(true);
                    }

                    if(itm == strmoney.length()-3){
                        act.oneMillion.setEnabled(true);
                    }
                }
                strmoney = act.displayTxt.getText().toString();

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

    void intmoneycal(){
        String text = act.displayTxt.getText().toString();
        int ihm = text.indexOf("억");
        int itm = text.indexOf("천");
        int im = text.indexOf("백");

        if(ihm > 0){
            String strhm = text.substring(0,ihm);
            int inthm = Integer.parseInt(strhm);
            intmoney = inthm*100000000;
        }


        if(itm > 0){
            String strtm = text.substring(itm-1,itm);
            int inttm = Integer.parseInt(strtm);
            intmoney = intmoney+(inttm*10000000);
        }

        if(im > 0){
            String strm = text.substring(im-1,im);
            int intm = Integer.parseInt(strm);
            intmoney = intmoney + (intm*1000000);
        }


        //intmoney = (inthm*100000000)+(inttm*10000000)+(intm*1000000);
        Toast.makeText(this, String.valueOf(intmoney), Toast.LENGTH_SHORT).show();

    }
}
