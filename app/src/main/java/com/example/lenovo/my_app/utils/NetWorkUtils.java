package com.example.lenovo.my_app.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by lenovo on 2017/12/12.
 */

public class NetWorkUtils {

    private static ByteArrayOutputStream baos;

    public static String getstr(String path) {
        try {
            URL url = new URL(path);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            int code = urlConnection.getResponseCode();
            if (code == 200) {
                InputStream stream = urlConnection.getInputStream();
                baos = new ByteArrayOutputStream();
                byte[] b = new byte[1024 * 1024];
                int len;
                while ((len=stream.read(b))!=-1) {
                    baos.write(b,0,len);
                }
                return baos.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
