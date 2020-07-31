package com.pressure.bloggerapidemo.apiclient;

import com.pressure.bloggerapidemo.R;
import com.pressure.bloggerapidemo.model.BloogerList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIClient {
    @GET
    Call<BloogerList> getTotalList(@Url String url);

}
