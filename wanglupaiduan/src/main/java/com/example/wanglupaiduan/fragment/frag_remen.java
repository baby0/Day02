package com.example.wanglupaiduan.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.my_moni2.MyAdapter;
import com.example.my_moni2.MyBean;
import com.example.my_moni2.R;
import com.example.my_moni2.view.XListView;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/12/9.
 */

public class frag_remen extends Fragment {

    static String path = "http://gank.io/api/data/Android/10/1";
    private ByteArrayOutputStream bao;

    private int type = 1;
    private int index = 1;
    private List<MyBean.ResultsBean> list=new ArrayList<>();
    private MyAdapter adapter;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private XListView xlv;
    private MyAdapter adapter1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_remen, container, false);
        xlv = (XListView) view.findViewById(R.id.xlv);
        xlv.setPullLoadEnable(true);
        xlv.setPullRefreshEnable(true);
        xlv.setXListViewListener(new XListView.IXListViewListener() {
            //刷新时
            @Override
            public void onRefresh() {
                //上拉刷新时当type==1,根据地址去加载数据
                type = 1;

                String path = "http://gank.io/api/data/Android/10/" + index;
                //运行asytask
                new myasytask().execute(path);


            }

            @Override
            public void onLoadMore() {
                //下拉加载的时候，当type=2；index++,加载地址，并运行
                type = 2;
                index++;
                String path = "http://gank.io/api/data/Android/10/" + index;
                new myasytask().execute(path);

            }
        });

        new myasytask().execute(path);
       // adapter = new MyAdapter(getActivity(),list);
       // xlv.setAdapter(adapter);
        return view;
    }

    class myasytask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {

            try {
                URL url = new URL(params[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setConnectTimeout(5000);
                int code = urlConnection.getResponseCode();
                if (code == 200) {
                    InputStream stream = urlConnection.getInputStream();
                    bao = new ByteArrayOutputStream();
                    byte[] b = new byte[1024 * 1024];
                    int len;
                    while ((len = stream.read(b)) != -1) {

                        bao.write(b, 0, len);
                    }
                    return bao.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return bao.toString();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Gson gs = new Gson();
            MyBean myBean = gs.fromJson(s, MyBean.class);
            //list = myBean.getResults();

            if (type == 1) {
                list.clear();
                //添加新数据
                list.addAll(myBean.getResults());
               // adapter.notifyDataSetChanged();
                  setAdpter();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //当前时间
                        Date date = new Date(System.currentTimeMillis());
                        SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String say = fo.format(date);
                        xlv.setRefreshTime(say);
                    }
                }, 2000);
            }else if (type==2){
                list.addAll(myBean.getResults());
                //adapter.notifyDataSetChanged();
                setAdpter();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        xlv.stopLoadMore();
                    }
                }, 1000);
            }



        }
    }

    public void setAdpter(){
        if (adapter==null){
            adapter1 = new MyAdapter(getActivity(), list);

            xlv.setAdapter(adapter1);

        }else {
            adapter.notifyDataSetChanged();

        }
    }
}
