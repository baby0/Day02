package com.example.wanglupaiduan;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.wanglupaiduan.fragment.Fragment_gengduo;
import com.example.wanglupaiduan.fragment.Fragment_ider;
import com.example.wanglupaiduan.fragment.Fragment_shichang;
import com.example.wanglupaiduan.fragment.Fragment_shouye;
import com.example.wanglupaiduan.fragment.Fragment_tongzhi;

public class MainActivity extends AppCompatActivity {


    private RadioGroup rg;
    private FragmentManager supportFragmentManager;
    private FragmentTransaction fragmentTransaction;

    Fragment_shouye f1;
    Fragment_ider f2;
    Fragment_shichang f3;
    Fragment_tongzhi f4;
    Fragment_gengduo f5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        supportFragmentManager = getSupportFragmentManager();
        fragmentTransaction = supportFragmentManager.beginTransaction();


        //实例化碎片
        f1 = new Fragment_shouye();


        //默认一个页面
        fragmentTransaction.add(R.id.fl, f1).commit();
        //获取点击事件
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                //隐藏所用的Frangment
                hideFrag();
                //在获取一个开启事务
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                switch (i) {
                    case R.id.rb_shouye:
                        fragmentTransaction.show(f1).commit();
                        break;
                    case R.id.rb_ider:
                        //如果等于空
                        if (f2 == null) {
                            f2 = new Fragment_ider();//实例化一个Frang2
                            fragmentTransaction.add(R.id.fl, f2).commit();//添加布局里
                        } else {
                            fragmentTransaction.show(f2).commit();//有的话就show
                        }
                        break;
                    case R.id.rb_shichang:
                        if (f3 == null) {
                            f3 = new Fragment_shichang();
                            fragmentTransaction.add(R.id.fl, f3).commit();
                        } else {
                            fragmentTransaction.show(f3).commit();
                        }
                        break;

                    case R.id.rb_tongzhi:
                        if (f4 == null) {
                            f4 = new Fragment_tongzhi();
                            fragmentTransaction.add(R.id.fl, f3).commit();
                        } else {
                            fragmentTransaction.show(f3).commit();
                        }
                        break;


                    case R.id.rb_gengduo:
                        if (f5 == null) {
                            f5 = new Fragment_gengduo();
                            fragmentTransaction.add(R.id.fl, f3).commit();
                        } else {
                            fragmentTransaction.show(f3).commit();
                        }
                        break;
                }
            }
        });
    }

    //隐藏所用的Frangment
    private void hideFrag() {
        //在获取一个开启事务
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        //不等于空或者是否添加
        if (f1 != null && f1.isAdded()) {
            fragmentTransaction.hide(f1);//隐藏
        }
        //不等于空或者是否添加
        if (f2 != null && f2.isAdded()) {
            fragmentTransaction.hide(f2);//隐藏
        }
        if (f3 != null && f3.isAdded()) {
            fragmentTransaction.hide(f3);
        }
        fragmentTransaction.commit();
    }
}
