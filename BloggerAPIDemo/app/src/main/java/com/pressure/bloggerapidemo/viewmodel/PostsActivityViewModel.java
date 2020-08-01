package com.pressure.bloggerapidemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.pressure.bloggerapidemo.model.BloogerList;
import com.pressure.bloggerapidemo.repository.AppRepository;

public class PostsActivityViewModel extends AndroidViewModel {
    private AppRepository repository;
    private LiveData<BloogerList> liveData;
    public PostsActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new AppRepository(application);
    }

    /**
     * returns the LiveData which contains lists of posts in the mentioned blogId.
     */
    public LiveData<BloogerList> getPostsList() {
        if(liveData == null)
            liveData = repository.getPostsList();
        return liveData;
    }
}
