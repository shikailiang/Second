package com.example.administrator.studyokhttp.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.studyokhttp.R;
import com.example.administrator.studyokhttp.bean.Bean;
import com.example.administrator.studyokhttp.iner.SetOnClick;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myholder> {
    private List<Bean> list;
    private Context context;
    private SetOnClick setOnClick;
    public MyAdapter(List<Bean> list,Context context,SetOnClick setOnClick){
        this.list = list;
        this.context = context;
        this.setOnClick = setOnClick;
    }
    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        Myholder myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(Myholder holder, final int position) {
        Glide.with(context).load(list.get(position).getImages()).into(holder.img);
        holder.t_title.setText(list.get(position).getTitle()+"");
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             setOnClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Myholder extends RecyclerView.ViewHolder{
        private final ImageView img;
        private final TextView t_title;

        public Myholder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.data_img);
            t_title = (TextView) itemView.findViewById(R.id.data_title);
        }
    }
}
