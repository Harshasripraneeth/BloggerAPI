package com.pressure.bloggerapidemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.pressure.bloggerapidemo.model.Blog;

public class MainViewModel extends AndroidViewModel {
    private AppRepository repository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new AppRepository(application);
    }
    public LiveData<Blog> getBlogDetails()
    {
        return  repository.getBlogDetails();
    }
}
