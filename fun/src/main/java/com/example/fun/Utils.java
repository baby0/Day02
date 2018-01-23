package com.example.fun;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by lenovo on 2017/12/9.
 */

public class Utils {


    /**
     * 返回值 -1：没有网络  1：WIFI网络   2：net网络
     */
    public static int getNetype(Context context) {

        //设置一个Int初始值
        int netType = -1;

        //获取一个管理者//getSystemService 网络分析

        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // 计算机网络的设计

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo == null) {
            return netType;
        }
        int nType = networkInfo.getType();
        if (nType == ConnectivityManager.TYPE_MOBILE) {
            netType = 2;
        } else if (nType == ConnectivityManager.TYPE_WIFI) {
            netType = 1;
        }
        return netType;
    }

}
