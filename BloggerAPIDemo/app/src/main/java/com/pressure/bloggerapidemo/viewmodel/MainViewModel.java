package com.pressure.bloggerapidemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.pressure.bloggerapidemo.model.Blog;
import com.pressure.bloggerapidemo.repository.AppRepository;

public class MainViewModel extends AndroidViewModel {
    private AppRepository repository;
    private LiveData<Blog> liveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new AppRepository(application);
    }

    /**
     * get the LiveData which contains blog details from the repository class
     */
    public LiveData<Blog> getBlogDetails() {
        if(liveData != null)
            return liveData;

        liveData = repository.getBlogDetails();
        return liveData;
    }
}
