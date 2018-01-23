package com.example.lenovo.my_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.lenovo.my_app.adpter.MyAdapter;
import com.example.lenovo.my_app.fragment.Fragment_remen;
import com.example.lenovo.my_app.fragment.Fragment_shouye;
import com.example.lenovo.my_app.fragment.Fragment_wode;

import java.util.ArrayList;
import java.util.List;

public class ThreeActivity extends AppCompatActivity implements View.OnClickListener {



    private ListView lv;

    private FrameLayout mFl;
    /**
     * 首页
     */
    private RadioButton rb_shouye;
    /**
     * 热门
     */
    private RadioButton rb_remen;
    /**
     * 我的
     */
    private RadioButton rb_wode;
    private RadioGroup mRg;
    private ListView mLv;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        initView();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl, new Fragment_shouye()).commit();

        lv = (ListView) findViewById(R.id.lv);

        initdata();
        MyAdapter adpter = new MyAdapter(this, list);
        lv.setAdapter(adpter);
    }

    private void initdata() {

        list = new ArrayList<>();

        list.add("少年漫画");
        list.add("青年漫画");
        list.add("少女漫画");
        list.add("耽美漫画");
        list.add("VIP会员");
        list.add("收藏");
        list.add("我的文件");
        list.add("设置");
        list.add("收藏");
    }

    private void initView() {
        mFl = (FrameLayout) findViewById(R.id.fl);
        rb_shouye = (RadioButton) findViewById(R.id.rb1);
        rb_shouye.setOnClickListener(this);
        rb_remen = (RadioButton) findViewById(R.id.rb2);
        rb_remen.setOnClickListener(this);
        rb_wode = (RadioButton) findViewById(R.id.rb3);
        rb_wode.setOnClickListener(this);
        mRg = (RadioGroup) findViewById(R.id.rg);
        mLv = (ListView) findViewById(R.id.lv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rb1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, new Fragment_shouye()).commit();
                break;
            case R.id.rb2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, new Fragment_remen()).commit();
                break;
            case R.id.rb3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, new Fragment_wode()).commit();
                break;
        }

    }
}


