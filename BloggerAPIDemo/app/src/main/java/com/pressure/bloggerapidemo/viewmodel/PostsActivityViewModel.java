package com.pressure.bloggerapidemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.pressure.bloggerapidemo.model.BloogerList;

public class PostsActivityViewModel extends AndroidViewModel {
    private AppRepository repository;
    public PostsActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new AppRepository(application);
    }
    public LiveData<BloogerList> getPostsList()
    {
       return repository.getPostsList();
    }
}
