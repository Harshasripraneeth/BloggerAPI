package com.pressure.bloggerapidemo.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.pressure.bloggerapidemo.R;
import com.pressure.bloggerapidemo.activities.MainActivity;

public class SplashActivity extends AppCompatActivity {
    private ImageView ivSplashLogo;
    private TextView tvSplash;
    private Animation top_animation;
    private Animation bottom_animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        ivSplashLogo = findViewById(R.id.ivSplashLogo);
        tvSplash = findViewById(R.id.tvSplashText);
        top_animation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_animation= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        top_animation.setDuration(1500);
        bottom_animation.setDuration(1500);
        ivSplashLogo.setAnimation(top_animation);
        tvSplash.setAnimation(bottom_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
