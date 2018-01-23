package com.example.wanglupaiduan.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

/**
 * Created by lenovo on 2017/12/9.
 */

public class Fragment_shouye extends Fragment {

    private ViewPager vp_pager;
 private PagerSlidingTabStrip tabs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view= inflater.inflate(R.l)



//         vp_pager = (ViewPager) view.findViewById(R.id.vp_pager);
//        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);

        vp_pager.setAdapter(new myFragmentPagerAdapter(getActivity().getSupportFragmentManager()));
        tabs.setViewPager(vp_pager);
        return view;
    }

    class myFragmentPagerAdapter extends FragmentPagerAdapter {

        String[] text = {"动态", "热门", "发现"};


        public myFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    frag_dongtai dongtai = new frag_dongtai();
                    return dongtai;
                case 1:
                    frag_remen remen = new frag_remen();
                    return remen;
                case 2:
                    frag_faxian faxian = new frag_faxian();
                    return faxian;
            }
            return null;
        }

        @Override
        public int getCount() {

            return text.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return text[position];
        }
    }
}
