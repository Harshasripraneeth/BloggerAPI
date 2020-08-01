package com.pressure.bloggerapidemo.apiclient;

import com.pressure.bloggerapidemo.R;
import com.pressure.bloggerapidemo.model.Blog;
import com.pressure.bloggerapidemo.model.BloogerList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIClient {
    @GET("{blogid}/posts/search")
    Call<BloogerList> getTotalList(@Path("blogid") String blogid,@Query("label") String label,@Query("key") String api_key);
    @GET("{blogid}/posts/{postid}")
    Call<BloogerList> getPostById(@Path("blogid") String blogid,@Path("postid") String postid,@Query("label") String label,@Query("key") String api_key);
    @GET("{blogid}/posts/{postid}/comments")
    Call<BloogerList> getComments(@Path("blogid") String blogid,@Path("postid") String postid,@Query("label") String label,@Query("key") String api_key);
    @GET("{blogid}")
    Call<Blog> getBlogDetails(@Path("blogid") String blogid,@Query("label") String label,@Query("key") String api_key);
}
