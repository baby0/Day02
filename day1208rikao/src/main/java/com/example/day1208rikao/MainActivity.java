package com.example.day1208rikao;


import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.day1208rikao.fragment.Fragment_fabu;
import com.example.day1208rikao.fragment.Fragment_faxian;
import com.example.day1208rikao.fragment.Fragment_my;
import com.example.day1208rikao.fragment.Fragment_shouye;
import com.example.day1208rikao.fragment.Fragment_xiaoxi;

public class MainActivity extends FragmentActivity {

    private ViewPager vp;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager) findViewById(R.id.vp);
        rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int i;

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_shouye:
                        RadioButton shoye = (RadioButton) findViewById(R.id.rb_shouye);
                        i = 0;
                        break;
                    case R.id.rb_fabu:
                        RadioButton fabu = (RadioButton) findViewById(R.id.rb_fabu);
                        i = 1;
                        break;
                    case R.id.rb_faxian:
                        RadioButton faxian = (RadioButton) findViewById(R.id.rb_faxian);
                        i = 2;
                        break;
                    case R.id.rb_xiaoxi:
                        RadioButton xioxi = (RadioButton) findViewById(R.id.rb_xiaoxi);
                        i = 3;
                        break;
                    case R.id.rb_my:
                        RadioButton  my= (RadioButton) findViewById(R.id.rb_my);
                        i = 4;
                        break;
                }
            }
        });


        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
                        RadioButton shoye = (RadioButton) findViewById(R.id.rb_shouye);
                        shoye.setChecked(true);
                        break;
                    case 1:
                        RadioButton fabu = (RadioButton) findViewById(R.id.rb_fabu);
                        fabu.setChecked(true);
                        break;
                    case 2:
                        RadioButton faxian = (RadioButton) findViewById(R.id.rb_faxian);
                        faxian.setChecked(true);
                        break;
                    case 3:
                        RadioButton xiaoxi = (RadioButton) findViewById(R.id.rb_xiaoxi);
                        xiaoxi.setChecked(true);
                        break;
                    case 4:
                        RadioButton my = (RadioButton) findViewById(R.id.rb_my);
                        my.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        Fragment_shouye shouye = new Fragment_shouye();
                        return shouye;
                    case 1:
                        Fragment_fabu fabu = new Fragment_fabu();
                        return fabu;
                    case 2:
                        Fragment_faxian faxian = new Fragment_faxian();
                        return faxian;
                    case 3:
                        Fragment_xiaoxi xiaoxi = new Fragment_xiaoxi();
                        return xiaoxi;
                    case 4:
                        Fragment_my my = new Fragment_my();
                        return my;


                }
                return null;
            }

            @Override
            public int getCount() {
                return 5;
            }
        });

    }


}
