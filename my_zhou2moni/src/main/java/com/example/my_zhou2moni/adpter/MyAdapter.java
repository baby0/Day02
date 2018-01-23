package com.example.my_zhou2moni.adpter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my_zhou2moni.MainActivity;
import com.example.my_zhou2moni.MyBean;
import com.example.my_zhou2moni.R;
import com.example.my_zhou2moni.fragment.Fragment_shouye;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

/**
 * Created by lenovo on 2017/12/10.
 */

public class MyAdapter extends BaseAdapter {

    //定义一个上下文
    Context context;
    //集合
    List<MyBean.ResultsBean> list;


    private int TEXT = 0;
    private int IMAGETEXT = 1;
    private final DisplayImageOptions options;

    public MyAdapter(Context context, List<MyBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
        //使用内存缓存
//使用磁盘缓存
//设置正在下载的图片
//url为空或请求的资源不存在时
//下载失败时显示的图片
//设置图片格式
//设置圆角图片
        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//使用内存缓存
                .cacheOnDisk(true)//使用磁盘缓存
                .showImageOnLoading(R.mipmap.ic_launcher)//设置正在下载的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)//url为空或请求的资源不存在时
                .showImageOnFail(R.mipmap.ic_launcher)//下载失败时显示的图片
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片格式
                .displayer(new RoundedBitmapDisplayer(200))//设置圆角图片
                .build();

    }
//重写
    @Override
    public int getItemViewType(int position) {
        List<String> images = list.get(position).getImages();
        if (images == null) {
            return TEXT;
        } else if (images != null && images.size() == 1) {
            return IMAGETEXT;
        } else {
            return TEXT;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

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
        //获取类型
        int type = getItemViewType(position);
        if (type == IMAGETEXT) {
            viewholder1 holder1;
            if (convertView == null) {
                holder1 = new viewholder1();
                convertView = View.inflate(context, R.layout.list_item, null);
                holder1.img = (ImageView) convertView.findViewById(R.id.list_img);
                holder1.tv1 = (TextView) convertView.findViewById(R.id.list_tv1);
                convertView.setTag(holder1);

            } else {
                holder1 = (viewholder1) convertView.getTag();
            }

            holder1.tv1.setText(list.get(position).getDesc());
            ImageLoader.getInstance().displayImage(list.get(position).getImages().get(0), holder1.img, options);
            return convertView;
        } else if (type == TEXT) {
            viewholder2 holder2;
            if (convertView == null) {
                holder2 = new viewholder2();
                convertView = View.inflate(context, R.layout.list_item2, null);
                holder2.tv2 = (TextView) convertView.findViewById(R.id.list_tv2);

                convertView.setTag(holder2);
            } else {
                holder2 = (viewholder2) convertView.getTag();
            }
            holder2.tv2.setText(list.get(position).getDesc());
        }
        return convertView;
    }

    class viewholder1 {
        ImageView img;
        TextView tv1;
    }

    class viewholder2 {
        TextView tv2;
    }
}
