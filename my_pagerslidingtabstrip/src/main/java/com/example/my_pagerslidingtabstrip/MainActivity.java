package com.example.my_pagerslidingtabstrip;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.astuetz.PagerSlidingTabStrip;
import com.example.my_pagerslidingtabstrip.fragment.Fragment1;
import com.example.my_pagerslidingtabstrip.fragment.Fragment2;
import com.example.my_pagerslidingtabstrip.fragment.Fragment3;
import com.example.my_pagerslidingtabstrip.fragment.Fragment4;
import com.example.my_pagerslidingtabstrip.fragment.Fragment5;

public class MainActivity extends AppCompatActivity {

    private PagerSlidingTabStrip tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new myPagerAdapter(getSupportFragmentManager()));
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(viewPager);
    }

    class myPagerAdapter extends FragmentPagerAdapter {
        String[] title = {"项目一", "项目二", "项目三", "项目四", "项目五",};

        Fragment1 fragment1;
        Fragment2 fragment2;
        Fragment3 fragment3;


        public myPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    fragment1 = new Fragment1();
                    return fragment1;
                case 1:
                    fragment2 = new Fragment2();
                    return fragment2;
                case 2:
                    fragment3 = new Fragment3();
                    return fragment3;
                case 3:
                    Fragment4 fragment4 = new Fragment4();
                    return fragment4;
                case 4:
                    Fragment5 fragment5 = new Fragment5();
                    return fragment5;

                default:
                    return null;
            }

        }

        @Override
        public int getCount() {

            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return title[position];
        }
    }
}
