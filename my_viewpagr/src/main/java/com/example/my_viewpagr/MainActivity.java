package com.example.my_viewpagr;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_viewpagr.image.MyBanner;
import com.example.my_viewpagr.view.XListView;
import com.google.gson.Gson;
import com.youth.banner.Banner;

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

public class MainActivity extends AppCompatActivity {

    private Banner ban;
    private ArrayList<String> li;
    private XListView xlv;
    private int type = 1;
    private int index = 1;

    String path = "https://www.toutiao.com/api/pc/focus/";
    private ByteArrayOutputStream bao;
    private List<Bean.DataBean.PcFeedFocusBean> list=new ArrayList<>();
    private Bean be;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ban = (Banner) findViewById(R.id.ban);
        li = new ArrayList<>();

        li.add("http://up.qqya.com/allimg/201610-s/16-101819_2092.jpg");
        li.add("http://e.hiphotos.baidu.com/image/h%3D220/sign=3b660cad2f1f95cab9f595b4f9167fc5/83025aafa40f4bfb57819787094f78f0f636188b.jpg");
        li.add("http://www.huajiang.cc/uploads/allimg/140606/8-140606215538.jpg");
        li.add("http://img4.imgtn.bdimg.com/it/u=1764125465,3932064903&fm=27&gp=0.jpg");
        li.add("http://m.qqzhi.com/upload/img_2_1189860164D2949408858_23.jpg");


        ban.setImageLoader(new MyBanner());
        ban.setImages(li);
        ban.start();

        xlv = (XListView) findViewById(R.id.xlv);

        xlv.setPullLoadEnable(true);
        xlv.setPullRefreshEnable(true);
        xlv.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {

                type = 1;

                index = 1;
                String path = "https://www.toutiao.com/api/pc/focus/" + index;
                new myASytask().execute(path);
            }

            @Override
            public void onLoadMore() {
                type = 2;
                index++;
                String path = "https://www.toutiao.com/api/pc/focus/" + index;
                new myASytask().execute(path);


            }
        });

        new myASytask().execute(path);

    }

    class myASytask extends AsyncTask<String, String, String> {

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
           // Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();

            Gson gs = new Gson();
            Bean bean = gs.fromJson(s, Bean.class);
        //    list = bean.getData().getPc_feed_focus();

            myadpter adpter = new myadpter();

            xlv.setAdapter(adpter);

            if (type == 1) {//代表刷新
                //如果是刷新的话
                list.clear();//清除原有的数据
           //     be = new Bean();
                list.addAll(bean.getData().getPc_feed_focus());//添加新的数据
                adpter.notifyDataSetChanged();
                //关闭xlistview的头部视图--延迟关闭
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xlv.stopRefresh();//关闭
                        // 获得此时此刻时间
                        Date date = new Date(System.currentTimeMillis());
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String s = sdf.format(date);
                        xlv.setRefreshTime(s);//设置刷新时间
                    }
                }, 1000);
            } else if (type == 2) {//代表加载更多
                //得到数据
                boolean b = list.addAll(bean.getData().getPc_feed_focus());//datas.addAll(0,result.getData());//将新请求的数据添加到集合的最前面
//设置适配器
                adpter.notifyDataSetChanged();
                //关闭xlistview的底部视图--延迟关闭
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xlv.stopLoadMore();
                    }
                }, 1000);
            }
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
                TextView tv = new TextView(MainActivity.this);
                tv.setText(list.get(position).getTitle());
                return tv;
            }
        }
    }
}

