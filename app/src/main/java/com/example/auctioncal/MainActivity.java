package com.example.auctioncal;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.auctioncal.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    int gjg, ncg, bjg,monthrent,ron,monthinterest,mymoney,monthincome, yearincome;
    int i;




    ActivityMainBinding actm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actm= DataBindingUtil.setContentView(this,R.layout.activity_main);


        actm.gjgTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                startActivityForResult(intent,101);
            }
        });
        actm.ncgTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                startActivityForResult(intent,102);
            }
        });

        actm.calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //gjg = Integer.parseInt(actm.gjgTxt.getText().toString());
                //ncg = Integer.parseInt(actm.ncgTxt.getText().toString());
                bjg = 20000000;

                monthrent =(int)((int)(((int)(gjg*0.78)-bjg)*0.035)/12);
                //String strmonthrent = String.valueOf(monthrent);
                actm.monthrentTxt.setText(String.format("%,d",monthrent));
                //actm.monthrentTxt.setText(String.valueOf(monthrent));

                ron = (int)(ncg*0.07);
                actm.ronTxt.setText(String.valueOf(ron));
                monthinterest = (int)(ron*0.05/12);
                actm.monthinterestTxt.setText(String.valueOf(monthinterest));



            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String strmoney = data.getStringExtra("strmoney");
        String intmoney = data.getStringExtra("strintmoney");
        int money = Integer.parseInt(intmoney);


        if (requestCode==101){
            actm.gjgTxt.setText(strmoney);
            gjg = money;
            Toast.makeText(this,String.valueOf(gjg), Toast.LENGTH_SHORT).show();
        }
        else if(requestCode==102){
            actm.ncgTxt.setText(strmoney);
            ncg = money;
            Toast.makeText(this,String.valueOf(ncg), Toast.LENGTH_SHORT).show();
        }
    }
}
