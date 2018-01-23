package com.example.my_zhou2moni;

import android.content.Context;
import android.graphics.ImageFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.my_zhou2moni.fragment.Fragment_shichang;
import com.example.my_zhou2moni.fragment.Fragment_shouye;
import com.example.my_zhou2moni.fragment.Fragment_tongzhi;

public class MainActivity extends AppCompatActivity {
    private FrameLayout fl;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //网络判断的权限
         //<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"></uses-permission>
        //得到网络判断的系统服务
        ConnectivityManager manager = (ConnectivityManager) MainActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        //得到网络信息类
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()) {
            Toast.makeText(MainActivity.this, "----网络开启----", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "----网络关闭----", Toast.LENGTH_SHORT).show();
        }




        fl = (FrameLayout) findViewById(R.id.fl);
        rg = (RadioGroup) findViewById(R.id.rg);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl, new Fragment_shouye()).commit();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId){
            case R.id.rb_shouye:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, new Fragment_shouye()).commit();
                break;
            case R.id.rb_shichang:
            getSupportFragmentManager().beginTransaction().replace(R.id.fl, new Fragment_shichang()).commit();
                break;
            case R.id.rb_tongzhi:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, new Fragment_tongzhi()).commit();
              break;
        }
            }
        });


    }


}
