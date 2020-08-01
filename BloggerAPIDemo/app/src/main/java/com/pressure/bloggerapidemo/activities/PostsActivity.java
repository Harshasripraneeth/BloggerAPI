package com.pressure.bloggerapidemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.pressure.bloggerapidemo.R;
import com.pressure.bloggerapidemo.adapters.CustomAdapter;
import com.pressure.bloggerapidemo.databinding.ActivityPostsBinding;
import com.pressure.bloggerapidemo.model.BloogerList;
import com.pressure.bloggerapidemo.model.Item;
import com.pressure.bloggerapidemo.viewmodel.PostsActivityViewModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;

public class PostsActivity extends AppCompatActivity implements CustomAdapter.ItemCLicked {

    private CustomAdapter adapter;
    private List<Item> postsList;
    private PostsActivityViewModel viewModel;
    private ActivityPostsBinding postsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postsBinding = DataBindingUtil.setContentView(PostsActivity.this, R.layout.activity_posts);
        getSupportActionBar().setTitle("Posts");
        postsBinding.rcView.setHasFixedSize(true);
        postsBinding.rcView.setLayoutManager(new LinearLayoutManager(this));
        postsBinding.progressBar.setVisibility(View.VISIBLE);
        postsList = new ArrayList<>();
        adapter = new CustomAdapter(PostsActivity.this, postsList);
        postsBinding.rcView.setAdapter(adapter);
        viewModel = ViewModelProviders.of(PostsActivity.this).get(PostsActivityViewModel.class);
        getData();
    }

    public void getData() {
        viewModel.getPostsList().observe(this, new Observer<BloogerList>() {
            @Override
            public void onChanged(BloogerList bloogerList) {
                if (bloogerList != null) {
                    postsList = bloogerList.getItems();
                }
                adapter.setList(postsList);
                postsBinding.progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onItemClicked(Item item) {
        Intent intent = new Intent(this, DetailActivity.class);
        Bundle bundle = new Bundle();
        Document document = Jsoup.parse(item.getContent());
        bundle.putString("DisplayName", item.getAuthor().getDisplayName());
        bundle.putString("URL", item.getAuthor().getUrl());
        bundle.putString("published", item.getPublished());
        bundle.putString("updated", item.getUpdated());
        bundle.putString("content", document.text());
        bundle.putString("title", item.getTitle());
        intent.putExtra("data", bundle);
        startActivity(intent);
    }
}

