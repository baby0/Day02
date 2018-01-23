package com.example.lenovo.my_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Zhuce_Activity extends AppCompatActivity {

    /**
     * 请输入用户名...
     */
    private EditText zhuce_Name;
    /**
     * 请输入密码...
     */
    private EditText zhuce_Pass;
    /**
     * 注册
     */
    private Button btn_Denglu;
    private EditText zhuce_name;
    private EditText zhuce_pass;
    private String zname;
    private Button zhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);

        zhuce_name = (EditText) findViewById(R.id.zhuce_name);
        zhuce_pass = (EditText) findViewById(R.id.zhuce_pass);
        zhuce = (Button) findViewById(R.id.but_zhuce);



        /**
         * 注册
         */
        zhuce.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Zhuce_Activity.this, Denglu_Activity.class);
                startActivity(intent);

            }
        });
    }


}
