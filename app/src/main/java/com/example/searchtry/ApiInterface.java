package com.example.searchtry;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("getUsers.php")
    static Call<List<Users>> getUsers(@Query("key") String keyword) {
        return null;
    }
}
