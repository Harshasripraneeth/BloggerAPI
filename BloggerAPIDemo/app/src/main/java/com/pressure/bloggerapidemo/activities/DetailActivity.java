package com.pressure.bloggerapidemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.pressure.bloggerapidemo.R;
import com.pressure.bloggerapidemo.databinding.ActivityDetailBinding;
import com.pressure.bloggerapidemo.model.Item;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding detailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        detailBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail);
        Intent intent = getIntent();
        if(intent.hasExtra("data"))
        {
            Bundle bundle = intent.getBundleExtra("data");
            detailBinding.setDisplayName("DisplayName: "+bundle.getString("DisplayName"));
            detailBinding.setURL(bundle.getString("URL"));
            detailBinding.setPublished(bundle.getString("published"));
            detailBinding.setUpdated(bundle.getString("updated"));
            detailBinding.setContent(bundle.getString("content"));
            detailBinding.setTitle(bundle.getString("title"));
        }


    }
}
