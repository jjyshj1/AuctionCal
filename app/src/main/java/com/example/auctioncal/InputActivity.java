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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        act= DataBindingUtil.setContentView(this,R.layout.activity_input);

        moneyinput();

        act.inputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strintmoney = String.valueOf(intmoney);

                Intent intent = new Intent();
                intent.putExtra("strmoney",displaystrmoney);
                intent.putExtra("strintmoney",strintmoney);

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
            }
        });
    }




    void moneyinput(){

        act.num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    strmoney = strmoney + "1";
                    act.displayTxt.setText(strmoney);

            }
        });
        act.num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"2";
                act.displayTxt.setText(strmoney);
            }
        });
        act.num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"3";
                act.displayTxt.setText(strmoney);
            }
        });
        act.num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"4";
                act.displayTxt.setText(strmoney);
            }
        });
        act.num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"5";
                act.displayTxt.setText(strmoney);
            }
        });
        act.num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"6";
                act.displayTxt.setText(strmoney);
            }
        });
        act.num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"7";
                act.displayTxt.setText(strmoney);
            }
        });
        act.num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"8";
                act.displayTxt.setText(strmoney);
            }
        });
        act.num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"9";
                act.displayTxt.setText(strmoney);
            }
        });
        act.num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strmoney != "") {
                    strmoney = strmoney + "0";

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
                    intmoney = Integer.parseInt(strmoney) * 100000000;
                    displaystrmoney = strmoney + "억";
                    act.displayTxt.setText(displaystrmoney);
                    strmoney = "";
                    act.hundredMillion.setEnabled(false);
                }

            }
        });

        act.tenMillion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intmoney = intmoney + String.valueOf(Integer.parseInt(strmoney)*10000000);

                if (strmoney!="") {
                    intmoney = intmoney + Integer.parseInt(strmoney) * 10000000;
                    displaystrmoney = displaystrmoney + strmoney + "천";
                    act.displayTxt.setText(displaystrmoney);
                    strmoney = "";
                    act.hundredMillion.setEnabled(false);
                    act.tenMillion.setEnabled(false);
                }

            }
        });

        act.oneMillion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intmoney = intmoney + String.valueOf(Integer.parseInt(strmoney)*1000000);

                if (strmoney!="") {
                    intmoney = intmoney + Integer.parseInt(strmoney) * 1000000;
                    displaystrmoney = displaystrmoney + strmoney + "백만";
                    act.displayTxt.setText(displaystrmoney);
                    act.hundredMillion.setEnabled(false);
                    act.tenMillion.setEnabled(false);
                    act.oneMillion.setEnabled(false);
                }
            }
        });

    }
}
