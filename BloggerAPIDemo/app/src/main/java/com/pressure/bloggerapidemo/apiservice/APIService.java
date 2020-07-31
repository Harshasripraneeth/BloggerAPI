package com.pressure.bloggerapidemo.apiservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {
    private static  String base_url = "https://www.googleapis.com/blogger/v3/blogs/BLOG_ID/posts/";
    private static Retrofit retrofit;
    public static String url = "https://www.googleapis.com/blogger/v3/blogs/BLOG_ID/posts/search?label:YOUR_LABLE&&key=__YOUR_API_KEY";

    public static Retrofit getClient()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
