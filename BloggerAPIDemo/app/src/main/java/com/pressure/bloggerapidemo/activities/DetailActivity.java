package com.pressure.bloggerapidemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.pressure.bloggerapidemo.R;
import com.pressure.bloggerapidemo.apiclient.APIClient;
import com.pressure.bloggerapidemo.apiservice.APIService;
import com.pressure.bloggerapidemo.databinding.ActivityDetailBinding;
import com.pressure.bloggerapidemo.model.BloogerList;
import com.pressure.bloggerapidemo.model.Item;
import com.pressure.bloggerapidemo.utilities.DateConversionUtil;

import retrofit2.Call;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding detailBinding;
    private DateConversionUtil dateConversionUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        detailBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail);
        dateConversionUtil = new DateConversionUtil();
        Intent intent = getIntent();
        if(intent.hasExtra("data"))
        {
            Bundle bundle = intent.getBundleExtra("data");
            detailBinding.setURL("Profile: \n"+bundle.getString("URL"));
            detailBinding.setPublished("Published date:"+dateConversionUtil.dateConversion(bundle.getString("published")));
            detailBinding.setUpdated("Updated date:"+dateConversionUtil.dateConversion(bundle.getString("updated")));
            detailBinding.setContent(bundle.getString("content"));
            detailBinding.setTitle(bundle.getString("title"));
            getSupportActionBar().setTitle(bundle.getString("DisplayName").toUpperCase());
        }


    }
}
