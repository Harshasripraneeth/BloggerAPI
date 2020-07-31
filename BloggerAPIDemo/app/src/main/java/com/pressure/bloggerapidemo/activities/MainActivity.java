package com.pressure.bloggerapidemo.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.pressure.bloggerapidemo.adapters.CustomAdapter;
import com.pressure.bloggerapidemo.R;
import com.pressure.bloggerapidemo.apiclient.APIClient;
import com.pressure.bloggerapidemo.apiservice.APIService;
import com.pressure.bloggerapidemo.model.BloogerList;
import com.pressure.bloggerapidemo.model.Item;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private ProgressBar progressBar;
    private List<Item> postsList;
    private LinearLayoutManager layoutManager;
    private  boolean isScrolling = false;
    int currentSize,totalSize,scrolledOutSize;
    String pageToken="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        postsList = new ArrayList<>();
        adapter = new CustomAdapter(MainActivity.this,postsList);
        recyclerView.setAdapter(adapter);

        /*recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                    isScrolling = true;
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentSize = layoutManager.getChildCount();
                totalSize = layoutManager.getItemCount();
                scrolledOutSize = layoutManager.findFirstVisibleItemPosition();
                if(isScrolling && ((currentSize + scrolledOutSize) == totalSize))
                {
                    isScrolling = false;
                    getData();
                }
            }
        });*/
        getData();
    }
    public void getData()
    {
        String url = APIService.url;
        Log.d("MainActvity","loaded");
        APIClient apiservice = APIService.getClient().create(APIClient.class);
       /* if(pageToken == null)
            return;
        if(pageToken !="")
            url = url+"&pageToken="+pageToken;
*/
        Call<BloogerList> posts = apiservice.getTotalList(url);
        Log.d("MainActvity","response calling");
        posts.enqueue(new Callback<BloogerList>() {
            @Override
            public void onResponse(Call<BloogerList> call, Response<BloogerList> response) {
                if(response.body() != null) {
                    postsList = response.body().getItems();
                  adapter.setList(postsList);

                }

                progressBar.setVisibility(View.GONE);

                Toast.makeText(MainActivity.this, "loaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<BloogerList> call, Throwable t) {

            }
        });
    }
}
