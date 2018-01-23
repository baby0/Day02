package com.example.day1208rikao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.day1208rikao.MainActivity;
import com.example.day1208rikao.R;
import com.example.day1208rikao.image.BannerImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/8.
 */

public class Fragment_shouye extends Fragment {

    private ListView lv;
    private List<String> list;

    int[] imgeid={R.drawable.a,R.drawable.c,R.drawable.d,R.drawable.e};
    private Banner ban;
    private List<String> li;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shouye, container, false);
        lv = (ListView) view.findViewById(R.id.lv);
        ban = (Banner) view.findViewById(R.id.ban);

        li = new ArrayList<String>();
        li.add("http://pic15.nipic.com/20110702/7181642_110249631347_2.jpg");
        li.add("http://pic2.nipic.com/20090424/1468853_230119053_2.jpg");
        li.add("http://img3.3lian.com/2013/s1/20/d/57.jpg");
        li.add("http://pic39.nipic.com/20140226/18071023_164300608000_2.jpg");
        li.add("http://a0.att.hudong.com/15/08/300218769736132194086202411_950.jpg");
        ban.setImageLoader(new BannerImageLoader());
        ban.setImages(li);
        ban.start();


//        ViewPager vip = (ViewPager) view.findViewById(R.id.vip);

      /*  vip.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imgeid.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView img=new ImageView(getActivity());
                img.setImageResource(imgeid[position]);
                img.setScaleType(ImageView.ScaleType.FIT_START);
                container.addView(img);
                return img;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);

            }
        });*/


        initdata();

        lv.setAdapter(new myadpter());
        return view;
    }

    private void initdata() {
        list = new ArrayList<>();
        list.add("上海");
        list.add("北京");
        list.add("三亚");
        list.add("大理");
        list.add("丽江");
        list.add("深圳");
    }

    class myadpter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = new TextView(getActivity());
            tv.setText(list.get(position));
            return tv;
        }
    }
}
