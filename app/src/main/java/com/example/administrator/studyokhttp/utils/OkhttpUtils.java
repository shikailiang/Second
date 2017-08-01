package com.example.administrator.studyokhttp.utils;

import android.util.Log;

import com.example.administrator.studyokhttp.iner.GetIner;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/7/31.
 * 网络请求工具类
 */

public class OkhttpUtils {
    public static void getOk(String url, final GetIner getIner){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder url1 = new Request.Builder().url(url);
        Request build = url1.build();
        Call call = okHttpClient.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                getIner.getData(string);
            }
        });

    }
}
