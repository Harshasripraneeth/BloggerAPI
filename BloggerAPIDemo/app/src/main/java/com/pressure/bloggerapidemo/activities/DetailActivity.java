package com.pressure.bloggerapidemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.pressure.bloggerapidemo.R;
import com.pressure.bloggerapidemo.databinding.ActivityDetailBinding;
import com.pressure.bloggerapidemo.utilities.DateConversionUtil;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding detailBinding;
    private DateConversionUtil dateConversionUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        detailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        dateConversionUtil = new DateConversionUtil();

        /**
         *  Post details which are sent from the PostsActivity is retrieved and displayed
         *  using DataBinding.
         */
        Intent intent = getIntent();
        if (intent.hasExtra("data")) {
            Bundle bundle = intent.getBundleExtra("data");
            detailBinding.setURL("Profile: \n" + bundle.getString("URL"));
            detailBinding.setPublished("Published date:" + dateConversionUtil.dateConversion(bundle.getString("published")));
            detailBinding.setUpdated("Updated date:" + dateConversionUtil.dateConversion(bundle.getString("updated")));
            detailBinding.setContent(bundle.getString("content"));
            detailBinding.setTitle(bundle.getString("title"));
            getSupportActionBar().setTitle(bundle.getString("DisplayName").toUpperCase());
        }


    }
}
