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
    String intmoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        act= DataBindingUtil.setContentView(this,R.layout.activity_input);

        moneyinput();

        act.inputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
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
                act.displayTxt.setText("");
            }
        });
    }




    void moneyinput(){

        act.num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strmoney = strmoney+"1";
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
                intmoney =  String.valueOf(Integer.parseInt(strmoney)*100000000);
                strmoney = strmoney+"억";
                act.displayTxt.setText(strmoney);

            }
        });

        act.tenMillion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intmoney = String.valueOf(Integer.parseInt(strmoney)*10000000);
                strmoney = strmoney+"천만";
                act.displayTxt.setText(strmoney);
            }
        });

        act.oneMillion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intmoney = String.valueOf(Integer.parseInt(strmoney)*1000000);
                strmoney = strmoney+"백만";
                act.displayTxt.setText(strmoney);
            }
        });

    }
}
