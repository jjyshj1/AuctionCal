package com.example.auctioncal;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.auctioncal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    int gjg, ncg, bjg,monthrent,ron,monthinterest,mymoney,monthincome, yearincome;
    int i;
    int money;
    String newstrbjg;
    String strmoney;
    //String intmoney;
    int intmoney;
    String strinvest;
    float interestrate;
    String strinterestrate;


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

        actm.bjgTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentbjg = new Intent(MainActivity.this, BjgActivity.class);
                startActivityForResult(intentbjg,103);
                //startActivity(intent);
            }
        });

        actm.interestrateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InterestrateActivity.class);
                startActivityForResult(intent, 104);
            }
        });

        actm.calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(actm.descriptionTxt != null){
                    monthrent =((int)((((gjg*0.78)-bjg)*0.045)/12)/10000)*10000;

                    actm.monthrentTxt.setText(String.format("%,d만원",monthrent/10000));


                    ron = (int)(ncg*0.7);

                    actm.ronTxt.setText(String.format("%,d만원", ron/10000));
                    monthinterest =((int)(ron*interestrate/100/12)/10000)*10000;
                    actm.monthinterestTxt.setText(String.format("%,d만원",monthinterest/10000));


                    mymoney = ((int)(ncg*1.04-ron-bjg)/10000)*10000;//낙찰가에 경매비용(세금, 수수료) 반영하고 대출액 빼면 내가 보유해야할 현금
                    actm.mymoneyTxt.setText(String.format("%,d만원",mymoney/10000));

                    monthincome = monthrent-monthinterest;
                    actm.monthincomeTxt.setText(String.format("%,d만원",monthincome/10000));

                    yearincome = monthincome*12;
                    actm.yearincomeTxt.setText(String.format("%,d만원",yearincome/10000));

                    float invest = (float)(yearincome*100)/mymoney;
                    if (invest > 6){
                        strinvest = "적격";
                        actm.descriptionTxt.setBackgroundColor(Color.BLUE);
                        actm.descriptionTxt.setTextColor(Color.WHITE);
                    }
                    else{
                        strinvest = "부적격";
                        actm.descriptionTxt.setBackgroundColor(Color.RED);
                    }

                    actm.descriptionTxt.setText(String.format("년 수익률  %.2f 퍼센트 / 투자 %s", invest, strinvest));

                }

                else{

                }


            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

      if(resultCode == Activity.RESULT_OK){     //두번째 액티비티가 결과값을 넘기지 않고 종료되면 메인액티비티도 종료되버림..이를 방지하기 위함

         if(requestCode==103){
            newstrbjg = data.getStringExtra("strbjg");
            bjg = data.getIntExtra("bjg",0);
            actm.bjgTxt.setText(newstrbjg);

          //   Toast.makeText(this, String.valueOf(bjg), Toast.LENGTH_SHORT).show();
        }


        else if (requestCode==101){
            strmoney = data.getStringExtra("strmoney");
            //intmoney = data.getStringExtra("strintmoney");
            intmoney = data.getIntExtra("intmoney",0);
            // money = Integer.parseInt(intmoney);/////////

            actm.gjgTxt.setText(strmoney);
            //gjg = money;
             gjg = intmoney;
          //  Toast.makeText(this,String.valueOf(gjg), Toast.LENGTH_SHORT).show();
        }
        else if(requestCode==102){
            strmoney = data.getStringExtra("strmoney");
            //intmoney = data.getStringExtra("strintmoney");
             intmoney = data.getIntExtra("intmoney",0);
            //money = Integer.parseInt(intmoney);

            actm.ncgTxt.setText(strmoney);
            //ncg = money;
             ncg=intmoney;
           // Toast.makeText(this,String.valueOf(ncg), Toast.LENGTH_SHORT).show();
        }
         else if(requestCode==104){
             interestrate = data.getFloatExtra("interest",0);

             Toast.makeText(this, String.valueOf(interestrate), Toast.LENGTH_SHORT).show();
             actm.interestrateTxt.setText(String.valueOf(interestrate)+" %");

         }
      }


    }
}
