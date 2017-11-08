package com.apppartner.androidtest.chat;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;



/**
 * Created by ranad_000 on 11/6/2017.
 */

public interface Api {

    String Base_URL = "http://dev3.apppartner.com/AppPartnerDeveloperTest/scripts/";

    @GET("chat_log.php")
    Call<List<ChatData>> getChatLog();

}