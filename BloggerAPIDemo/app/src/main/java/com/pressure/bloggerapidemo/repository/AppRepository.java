package com.pressure.bloggerapidemo.repository;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.pressure.bloggerapidemo.R;
import com.pressure.bloggerapidemo.api.APIClient;
import com.pressure.bloggerapidemo.api.APIService;
import com.pressure.bloggerapidemo.model.Blog;
import com.pressure.bloggerapidemo.model.BloogerList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {
    private Application application;

    public AppRepository(Application application) {
        this.application = application;
    }

    /**
     * This function helps to get Blog details and returns the livedata.
     */
    public LiveData<Blog> getBlogDetails() {
        Context context = application.getApplicationContext();
        final MutableLiveData<Blog> liveData = new MutableLiveData<>();
        APIClient apiservice = APIService.getClient().create(APIClient.class);

        Call<Blog> details = apiservice.getBlogDetails(context.getString(R.string.blogId), context.getString(R.string.label)
                , context.getString(R.string.api_key));
        details.enqueue(new Callback<Blog>() {
            @Override
            public void onResponse(Call<Blog> call, Response<Blog> response) {
                if (response != null) {
                    liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Blog> call, Throwable t) {
                liveData.setValue(null);

            }
        });
        return liveData;
    }

    /**
     * this function returns the livedata which consists of the Items or posts in the blog
     * respective to the mentioned Blog Id.
     */
    public LiveData<BloogerList> getPostsList() {
        Context context = application.getApplicationContext();
        final MutableLiveData<BloogerList> mutableLiveData = new MutableLiveData<>();
        APIClient apiservice = APIService.getClient().create(APIClient.class);
        Call<BloogerList> posts = apiservice.getTotalList(context.getString(R.string.blogId), context.getString(R.string.label)
                , context.getString(R.string.api_key));
        Log.d("MainActvity", "response calling");
        posts.enqueue(new Callback<BloogerList>() {
            @Override
            public void onResponse(Call<BloogerList> call, Response<BloogerList> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());

                }
                mutableLiveData.setValue(null);
            }

            @Override
            public void onFailure(Call<BloogerList> call, Throwable t) {
                Log.d("postsList", "failed");
            }
        });
        return mutableLiveData;
    }
}

