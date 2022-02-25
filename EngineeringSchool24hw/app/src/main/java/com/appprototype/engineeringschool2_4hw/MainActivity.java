package com.appprototype.engineeringschool2_4hw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    Button[] btn_num = new Button[10];
    Button[] btn_math = new Button[5];
    TextView tv;
    String num = "";
    Queue<Integer> queue_num = new LinkedList<>();
    Queue<Character> queue_math = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] name = {"div", "mul", "sum", "min", "ans"};
        for(int i = 0; i < btn_num.length; i++){
            int k = getResources().getIdentifier("btn_" + (i), "id", getPackageName());
            btn_num[i] = (Button) findViewById(k);
        }
        for(int i = 0; i < btn_math.length; i++){
            int k = getResources().getIdentifier("btn_" + (name[i]), "id", getPackageName());
            btn_math[i] = (Button) findViewById(k);

        }
        tv = (TextView) findViewById(R.id.tv_ans);
        for(int i = 0; i < btn_num.length; i++){
            final int k = i;
            btn_num[i].setOnClickListener(view -> {
                num = num + k;
                tv.setText(num);
            });
        }
        for(int i = 0; i < btn_math.length; i++){
            final int k = i;
            btn_math[i].setOnClickListener(view -> {
                switch(k){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        if(!num.equals("")) {
                            queue_num.offer(Integer.parseInt(num));
                            queue_math.offer('+');
                            num = "";
                            Toast.makeText(getApplicationContext(), "" + queue_num.peek(), Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 3:
                        break;
                    case 4:
                        int ans = 0;
                        while(!queue_num.isEmpty()){
                            int num1 = -1;
                            if(num1 == -1){
                                num1 = queue_num.poll();
                            }
                            if(queue_math.peek() == '+'){
                                num1 += queue_num.poll();
                                queue_math.poll();
                            }
                            ans = num1;
                        }

                        tv.setText("" + ans);

                        break;
                }
            });
        }


    }
}