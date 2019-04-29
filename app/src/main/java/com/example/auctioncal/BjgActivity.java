package com.example.auctioncal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.auctioncal.databinding.ActivityBjgBinding;

public class BjgActivity extends AppCompatActivity {
    ActivityBjgBinding actg;

   String strbjg="2천만원";
   int bjg=20000000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actg = DataBindingUtil.setContentView(this,R.layout.activity_bjg);

        actg.bjgradiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(actg.btn1.isChecked()){
                    strbjg = "3천만원";
                    bjg = 30000000;
                }
                else if(actg.btn2.isChecked()){
                    strbjg = "2천만원";
                    bjg = 20000000;
                }
                else if(actg.btn3.isChecked()){
                    strbjg = "1천만원";
                    bjg = 10000000;
                }

            }
        });



        actg.bjgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentbjg = new Intent();
                //intentbjg = intentbjg.putExtra("strbjg", strbjg);
                intentbjg = intentbjg.putExtra("strbjg",strbjg);
                intentbjg = intentbjg.putExtra("bjg",bjg);
                setResult(Activity.RESULT_OK, intentbjg);
                //Toast.makeText(BjgActivity.this, strbjg, Toast.LENGTH_SHORT).show();
                finish();
            }
        });





    }
}
