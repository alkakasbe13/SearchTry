package com.example.searchtry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {

    @SerializedName("category_id") private String category_id;
    @SerializedName("location") private String locaiton;
    @SerializedName("caption") private String caption;



    public String getCategory_id() {


        return category_id;
    }

    public String getLocaiton() {
        return locaiton;
    }

    public String getCaption() {
        return caption;
    }
}
