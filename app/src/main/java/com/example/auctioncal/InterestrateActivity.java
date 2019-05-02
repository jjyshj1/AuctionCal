package com.example.auctioncal;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.auctioncal.databinding.ActivityInterestrateBinding;

public class InterestrateActivity extends AppCompatActivity {

    ActivityInterestrateBinding act;

    float finterest;// =4.5f;
    String newstrinterst;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = DataBindingUtil.setContentView(this,R.layout.activity_interestrate);

        Intent intent = getIntent(); /*데이터 수신*/
        float fpreinterest = intent.getExtras().getFloat("interest");//이율 조정 하는 화면 뜨면 우선 메인에 입력되었던 이율을 가져옴
        int preinterest = (int)(fpreinterest*100);
        act.seekBar.setProgress(preinterest);
        act.interestrateTxt.setText(String.valueOf(fpreinterest));
        finterest = fpreinterest;   //seekbar 값이 변동 없으면 이값을 반영
        act.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 finterest = (float)(progress)/100;
                 act.interestrateTxt.setText(String.format("%5.2f",finterest));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


//        act.interestrateEdt.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if (act.interestrateEdt.getText().toString()!=null) {
//
//                    finterest = Float.parseFloat(act.interestrateEdt.getText().toString());
//                    int intinterest = (int) (finterest * 100);
//
//                    if (finterest >= 0 && finterest <= 6) {
//                        act.seekBar.setProgress(intinterest);
//                    } else {
//                        Toast.makeText(InterestrateActivity.this, "0.01 ~ 6에서만 입력해주세요", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });

        act.interestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("interest",finterest);

                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });


    }
}
