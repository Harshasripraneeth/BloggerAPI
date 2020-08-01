package com.pressure.bloggerapidemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pressure.bloggerapidemo.R;
import com.pressure.bloggerapidemo.databinding.CustomadapterLayoutBinding;
import com.pressure.bloggerapidemo.model.Item;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.viewHolder> {
    private List<Item> posts;
    private Context context;
    private ItemCLicked activity;

    public interface ItemCLicked {
        void onItemClicked(Item item);
    }

    public CustomAdapter(Context context, List<Item> posts) {
        this.context = context;
        this.posts = posts;
        activity = (ItemCLicked) context;
    }

    class viewHolder extends RecyclerView.ViewHolder {
        CustomadapterLayoutBinding customadapterLayoutBinding;

        public viewHolder(@NonNull CustomadapterLayoutBinding itemView) {
            super(itemView.getRoot());
            customadapterLayoutBinding = itemView;
            itemView.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onItemClicked((Item) view.getTag());
                }
            });

        }
    }

    @NonNull
    @Override
    public CustomAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomadapterLayoutBinding adapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.customadapter_layout, parent, false);
        return new viewHolder(adapterLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.viewHolder holder, int position) {
        Item item = posts.get(position);
        holder.itemView.setTag(item);
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

    public void setList(List<Item> list) {
        posts = list;
        notifyDataSetChanged();
    }
}