package com.apppartner.androidtest.chat;

/**
 * Created by ranad_000 on 11/8/2017.
 */


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelAPI {

    @SerializedName("data")
    @Expose
    private List<Chat> data = null;

    public List<Chat> getData() {
        return data;
    }

    public void setData(List<Chat> data) {
        this.data = data;
    }

}