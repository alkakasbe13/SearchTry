package com.example.searchtry;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final BASE_URL="https://alkakasbe2020.000webhostapp.com/users/getUsers.php";
    public static Retrofit retrofit;
    public static Retrofit getApiClient(){

if(retrofit==null){
    retrofit=new Retrofit().Builder()
            .baseUrl(BASE_URL)
            .addConvertFactory(GsonConverterFactory.create())
            .build();
}

        return retrofit;
    }

}
