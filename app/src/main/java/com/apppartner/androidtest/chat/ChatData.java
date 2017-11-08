package com.apppartner.androidtest.chat;

/**
 * Created by ranad_000 on 11/6/2017.
 */

public class ChatData {


    private String data;
    private String id;
    private String username;
    private String avatar_url;

    public ChatData(String data, String id, String username, String avatar_url) {
        this.data = data;
        this.id = id;
        this.username = username;
        this.avatar_url = avatar_url;
    }

    public String getData() {
        return data;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatar_url() {
        return avatar_url;
    }
}
