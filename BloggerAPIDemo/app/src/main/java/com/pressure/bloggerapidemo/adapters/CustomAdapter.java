package com.pressure.bloggerapidemo.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pressure.bloggerapidemo.R;
import com.pressure.bloggerapidemo.activities.DetailActivity;
import com.pressure.bloggerapidemo.databinding.CustomadapterLayoutBinding;
import com.pressure.bloggerapidemo.model.Item;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.viewHolder> {
    List<Item> posts;
    Context context;
    public CustomAdapter(Context context,List<Item> posts)
    {
        this.context = context;
        this.posts = posts;
    }
    class viewHolder extends RecyclerView.ViewHolder
    {
        CustomadapterLayoutBinding customadapterLayoutBinding;

        public viewHolder(@NonNull CustomadapterLayoutBinding itemView) {
            super(itemView.getRoot());
            customadapterLayoutBinding = itemView;
           itemView.getRoot().setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent = new Intent(context,DetailActivity.class);
                   Bundle bundle = new Bundle();
                   Item item = (Item) view.getTag();
                   Document document = Jsoup.parse(item.getContent());
                   bundle.putString("DisplayName",item.getAuthor().getDisplayName());
                   bundle.putString("URL",item.getAuthor().getUrl());
                   bundle.putString("published",item.getPublished());
                   bundle.putString("updated",item.getUpdated());
                   bundle.putString("content",document.text());
                   bundle.putString("title",item.getTitle());
                   intent.putExtra("data",bundle);
                   context.startActivity(intent);
               }
           });

        }
    }
    @NonNull
    @Override
    public CustomAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomadapterLayoutBinding adapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.customadapter_layout,parent,false);
        return new viewHolder(adapterLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.viewHolder holder, int position) {
    Item item = posts.get(position);
    holder.itemView.setTag(item);
        Document document = Jsoup.parse(item.getContent());
        Elements elements = document.select("img");
    holder.customadapterLayoutBinding.tvTitle.setText(item.getTitle());
    holder.customadapterLayoutBinding.tvDescription.setText(document.text());
        Glide.with(context).load(elements.get(0).attr("src")).into(holder.customadapterLayoutBinding.titleImage);

    }

    @Override
    public int getItemCount() {
     return posts.size();
    }
    public void setList(List<Item> list)
    {
        posts = list;
        notifyDataSetChanged();
    }
}