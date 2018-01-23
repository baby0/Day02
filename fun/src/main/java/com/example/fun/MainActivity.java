package com.example.fun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int netype = Utils.getNetype(this);

        if(netype>-1){
            //解析的数据
//            //获取适配器
//            lv.setAdapter(myadapet);
//            //实力化类并执行；
//            new Myasyntask().execute(Urlhttp);//Urlhttp路径
        }


    }


    public void jiexu(){


    }


}
