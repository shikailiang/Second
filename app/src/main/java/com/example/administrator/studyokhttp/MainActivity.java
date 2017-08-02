package com.example.administrator.studyokhttp;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.studyokhttp.bean.Bean;
import com.example.administrator.studyokhttp.iner.GetIner;
import com.example.administrator.studyokhttp.adapter.MyAdapter;
import com.example.administrator.studyokhttp.iner.SetOnClick;
import com.example.administrator.studyokhttp.utils.OkhttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements GetIner, SetOnClick {
    private List<Bean> list;
    private RecyclerView recyclerView;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                MyAdapter myAdapter = new MyAdapter(list, MainActivity.this, MainActivity.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(myAdapter);
            }
        }
    };
    private TextView btn_feature_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_feature_2 = (TextView) findViewById(R.id.btn_feature_2);
        //初始化view
        initdata();
//        OkhttpUtils.getOk("http://news-at.zhihu.com/api/4/news/latest", this);
    }

    private void initdata() {
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    @Override
    public void getData(String data) {
        list = new ArrayList<>();
        //原生解析
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(data);
            JSONArray stories = jsonObject.optJSONArray("stories");
            for (int i = 0; i < stories.length(); i++) {
                JSONObject jsonObject1 = stories.optJSONObject(i);
                JSONArray images = jsonObject1.optJSONArray("images");
                Object o = images.get(0);
                String s = o.toString();
                String title = jsonObject1.optString("title");
                list.add(new Bean(s, title));
            }
            Log.d("zzz", "数据的结果是：" + list.toString());
            mHandler.sendEmptyMessage(1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(MainActivity.this, list.get(position).getTitle(), Toast.LENGTH_LONG).show();
    }
    public void feature2(View view) {
        if (btn_feature_2.getText().toString().equals("功能2")) {
            btn_feature_2.setText("功能3");
        } else {
            btn_feature_2.setText("功能一");
        }
    }
}
