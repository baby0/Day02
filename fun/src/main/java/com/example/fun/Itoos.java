package com.example.fun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lenovo on 2017/12/9.
 */

public class Itoos {
    public static String ioss(String iostring) {

        //全球资源定位器
        StringBuilder out = new StringBuilder();
        try {

            URL url = new URL(iostring);
            //建立管连
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(8000);//获取超时链接
            int responseCode = urlConnection.getResponseCode();//获取状态码

            if (responseCode == 200) {//200成功的状态码
                InputStream inputStream = urlConnection.getInputStream();

                BufferedReader bu = new BufferedReader(new InputStreamReader(inputStream));
                String line = null;
                while ((line = bu.readLine()) != null) {

                    out.append(line);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toString();


    }
}
