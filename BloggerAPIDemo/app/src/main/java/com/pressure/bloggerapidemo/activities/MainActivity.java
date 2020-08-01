package com.pressure.bloggerapidemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;

import com.pressure.bloggerapidemo.R;
import com.pressure.bloggerapidemo.databinding.ActivityMainBinding;
import com.pressure.bloggerapidemo.model.Blog;
import com.pressure.bloggerapidemo.utilities.DateConversionUtil;
import com.pressure.bloggerapidemo.viewmodel.MainViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private MainViewModel viewModel;
    private DateConversionUtil dateConversionUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("BLOG DETAILS");
        dateConversionUtil = new DateConversionUtil();
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainBinding.tvVisit.setMovementMethod(LinkMovementMethod.getInstance());

        /**
         * when the View Blog Posts button is clicked it traverses to PostsActivity
         */
        mainBinding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PostsActivity.class);
                startActivity(intent);
            }
        });
        getData();
    }
    public void getData()
    {

        viewModel = ViewModelProviders.of(MainActivity.this).get(MainViewModel.class);
        viewModel.getBlogDetails().observe(this, new Observer<Blog>() {
            @Override
            public void onChanged(Blog blog) {
                if( blog != null)
                {
                    mainBinding.setDetails(blog);
                    try {
                        mainBinding.tvBlogPublish.setText("Published Date: "+ dateConversionUtil.dateConversion(blog.getPublished()));
                        mainBinding.tvBlogUpdated.setText("Last Update: "+dateConversionUtil.dateConversion(blog.getUpdated()));
                        mainBinding.button2.setVisibility(View.VISIBLE);
                    }
                    catch (Exception e)
                    {

                    }
                }
            }
        });
    }
}
