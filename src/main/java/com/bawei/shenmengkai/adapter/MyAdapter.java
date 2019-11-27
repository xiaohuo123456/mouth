package com.bawei.shenmengkai.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.shenmengkai.JsWebActivity;
import com.bawei.shenmengkai.R;
import com.bawei.shenmengkai.bean.MyBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MyBean.ResultBean> list;
    private Context context;

    public MyAdapter(List<MyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0){
            View view = LayoutInflater.from(context).inflate(R.layout.one_item_layout, null);
            OneHolder holder = new OneHolder(view);
            return holder;
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.two_item_layout, null);
            TwoHolder holder = new TwoHolder(view);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OneHolder){
            Glide.with(context).load(list.get(position).getMasterPic())
                    .placeholder(R.drawable.ic_launcher_background)
                    .priority(Priority.HIGH)
                    .error(R.drawable.ic_launcher_background)
                    .into(((OneHolder) holder).imageView);
            ((OneHolder) holder).textView.setText(list.get(position).getCommodityName());
        }else {
            Glide.with(context).load(list.get(position).getMasterPic())
                    .placeholder(R.drawable.ic_launcher_background)
                    .priority(Priority.HIGH)
                    .error(R.drawable.ic_launcher_background)
                    .into(((TwoHolder) holder).imageView);
            ((TwoHolder) holder).textView.setText(list.get(position).getCommodityName());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, JsWebActivity.class);
                intent.putExtra("str",list.get(position).getCommodityName());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    class OneHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public OneHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_one);
            textView = itemView.findViewById(R.id.text_one);
        }
    }
    class TwoHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public TwoHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_two);
            textView = itemView.findViewById(R.id.text_two);
        }
    }
}
