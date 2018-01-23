package com.example.lenovo.my_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Denglu_Activity extends AppCompatActivity {


    /**
     * 注册
     */
    private Button btn_Zhuce;
    private Button denglu;
    private EditText ed_name;
    private EditText ed_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        ed_name = (EditText) findViewById(R.id.denglu_name);
        ed_pass = (EditText) findViewById(R.id.denglu_pass);
        btn_Zhuce = (Button) findViewById(R.id.btn_zhuce);

        denglu = (Button) findViewById(R.id.btn_denglu);
/**
 *
 */
        denglu.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String name = ed_name.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(Denglu_Activity.this, "输入框不能为空 ", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(Denglu_Activity.this, ThreeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        /**
         * 注册
         */
        Button zhuce = (Button) findViewById(R.id.btn_zhuce);

        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent zhu_intent = new Intent(Denglu_Activity.this, Zhuce_Activity.class);
                startActivity(zhu_intent);
                finish();
            }
        });

        //initView();
    }

  /*  private void initView() {

    }*/


}

