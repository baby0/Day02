package com.example.lenovo.my_app.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.my_app.R;
import com.example.lenovo.my_app.bean.MyBean;
import com.example.lenovo.my_app.image.ImageBanner;
import com.example.lenovo.my_app.utils.NetWorkUtils;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/7.
 */

public class Fragment_shouye extends Fragment {

    String path = "http://japi.juhe.cn/comic/category?key=58f8578b060800e769fbbe1f9c80b0cd";

    private GridView gv;
    private List<String> list;
    private List<String> li2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shouye, container, false);
        Banner ban = (Banner) view.findViewById(R.id.bao);
        gv = (GridView) view.findViewById(R.id.gv);
        List<String> li = new ArrayList<>();
        //添加图片地址
        li.add("http://pic.baike.soso.com/p/20131220/20131220194153-1583037037.jpg");
        li.add("http://img.ph.126.net/x4O-rmOGno5glVxtDbPZDA==/3288190677934796085.jpg");
        li.add("http://2t.5068.com/uploads/allimg/160815/1-160Q50S611.jpg");
        li.add("http://p5.qhmsg.com/t01e5f055f4d123d19a.png");
        li.add("http://img5.duitang.com/uploads/item/201412/01/20141201043159_sFxhm.thumb.700_0.jpeg");
        li.add("http://pic35.photophoto.cn/20150620/0020033073450402_b.jpg");
        li.add("http://2t.5068.com/uploads/allimg/160421/1-1604210Z934.jpg");
        li.add("http://pic36.photophoto.cn/20150715/0017029562661823_b.jpg");
        li.add("http://imgsrc.baidu.com/baike/pichttp://img.ph.126.net/x4O-rmOGno5glVxtDbPZDA==/3288190677934796085.jpg/item/0649363880858f69b9998f20.jpg");
        ban.setImageLoader(new ImageBanner());
        ban.setImages(li);
        ban.start();


        new MyAsytask().execute(path);

        return view;
    }

    private void Initdata() {
        li2 = new ArrayList<>();
        li2.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1306939026,1463178465&fm=27&gp=0.jpg");
        li2.add("http://b.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=d00c3458818ba61edfbbc02b7404bb3c/64380cd7912397ddc07daa965a82b2b7d0a2871f.jpg");
        li2.add("http://d.hiphotos.baidu.com/zhidao/pic/item/c2cec3fdfc03924545e8e1fd8294a4c27c1e25e6.jpg");
        li2.add("http://img0.imgtn.bdimg.com/it/u=3413334778,26049134&fm=27&gp=0.jpg");
        li2.add("http://img4.imgtn.bdimg.com/it/u=4286266624,930690094&fm=27&gp=0.jpg");
        li2.add("http://img5q.duitang.com/uploads/item/201503/22/20150322184851_n2CkP.png");
    }

    class MyAsytask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String json = NetWorkUtils.getstr(params[0]);
            return json;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gs = new Gson();
            MyBean myBean = gs.fromJson(s, MyBean.class);
            list = myBean.getResult();


            gv.setAdapter(new MyAdapter());

            Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
        }
    }

    class MyAdapter extends BaseAdapter {

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
          if (convertView==null){
            convertView=  View.inflate(getActivity(),R.layout.list_item,null);
          }
          TextView list1_tv1= (TextView) convertView.findViewById(R.id.list1_tv1);
           ImageView list1_img1= (ImageView) convertView.findViewById(R.id.list1_img1);
            list1_img1.setImageResource(R.drawable.asg);
           ImageView list1_img2= (ImageView) convertView.findViewById(R.id.list1_img2);
            list1_img2.setImageResource(R.drawable.xe);
           ImageView list1_img3= (ImageView) convertView.findViewById(R.id.list1_img3);
            list1_img3.setImageResource(R.drawable.xd);
           ImageView list1_img4= (ImageView) convertView.findViewById(R.id.list1_img4);
            list1_img4.setImageResource(R.drawable.xc);

          list1_tv1.setText(list.get(position));

            return convertView;
        }
    }
}
