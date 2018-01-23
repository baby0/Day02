package com.example.my_zhou2moni.fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.my_zhou2moni.MyBean;
import com.example.my_zhou2moni.R;
import com.example.my_zhou2moni.adpter.MyAdapter;
import com.example.my_zhou2moni.view.XListView;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/12/10.
 */

public class Fragment_shouye extends Fragment {

    String path = "http://gank.io/api/data/Android/10/1";
    private ByteArrayOutputStream baos;
    private int type = 1;
    private int index = 1;
    private List<MyBean.ResultsBean> list = new ArrayList<>();
    private XListView xlv;

   /* Handler handler = new Handler() {
        @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
    }
};*/
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shouye, container, false);
        xlv = (XListView) view.findViewById(R.id.xlv);
        xlv.setPullLoadEnable(true);
        xlv.setPullRefreshEnable(true);

        xlv.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                type = 1;
                String path = "http://gank.io/api/data/Android/10/1";
                new Myaynstask().execute(path);

            }

            @Override
            public void onLoadMore() {

                type = 2;
                index++;
                String path = "http://gank.io/api/data/Android/10/1";
                new Myaynstask().execute(path);

            }

        });

        new Myaynstask().execute(path);
        xlv.setAdapter(adapter);
        return view;
    }

    class Myaynstask extends AsyncTask<String, String, String> {

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
                    baos = new ByteArrayOutputStream();
                    byte[] b = new byte[1024 * 1024];
                    int len;
                    while ((len = stream.read(b)) != -1) {
                        baos.write(b, 0, len);
                    }
                }
            } catch (Exception e) {

                e.printStackTrace();
            }
            return baos.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gs = new Gson();
            MyBean myBean = gs.fromJson(s, MyBean.class);
            // list = myBean.getResults();
            // Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();

            if (type == 1) {
                //清空集合
                list.clear();
                list.addAll(myBean.getResults());
                setAdapter();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xlv.stopRefresh();

                        Date date = new Date(System.currentTimeMillis());
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
                        String s1 = simpleDateFormat.format(date);
                        xlv.setRefreshTime(s1);
                    }
                }, 2000);


            } else if (type == 2) {
                list.addAll(myBean.getResults());
                setAdapter();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xlv.stopLoadMore();
                    }
                }, 1000);
            }
        }
    }

    public void setAdapter() {

        if (adapter == null) {
            adapter = new MyAdapter(getActivity(), list);
            xlv.setAdapter(adapter);

        } else {
            adapter.notifyDataSetChanged();
        }


    }}

