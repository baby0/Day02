package com.example.lenovo.my_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
        }
    };
    private TextView tv;
    int time = 5;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);

        sp = getSharedPreferences("zizhu", MODE_PRIVATE);
        edit = sp.edit();

        boolean isfrist = sp.getBoolean("isfrist", false);
        if (isfrist) {
            Intent intent = new Intent(MainActivity.this, Denglu_Activity.class);
            startActivity(intent);
            finish();
            return;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv.setText(time + "秒");
                time--;
                if (time == 0) {
                    Intent intent = new Intent(MainActivity.this, Denglu_Activity.class);
                    startActivity(intent);

                    edit.putBoolean("isfrist", true);
                    edit.commit();
                    finish();
                    return;

                }
                handler.postDelayed(this, 1000);
            }
        }, 1000);


    }
}
