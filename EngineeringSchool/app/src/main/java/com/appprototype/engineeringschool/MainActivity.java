package com.appprototype.engineeringschool;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //여기까지 layout이 로드됨

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setText("안녕하세요");
        btn1.setOnClickListener(view -> {
//            Toast.makeText(getApplicationContext(), "안녕하세요!", Toast.LENGTH_LONG).show();
            btn1.setTextColor(Color.RED);
            android.widget.LinearLayout.LayoutParams lp = new
                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT); // 60 is height you can set it as u need
            btn1.setLayoutParams(lp);
        });
    }
}