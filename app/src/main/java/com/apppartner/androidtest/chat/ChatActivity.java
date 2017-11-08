package com.apppartner.androidtest.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.apppartner.androidtest.MainActivity;
import com.apppartner.androidtest.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Screen that displays a list of chats from a chat log.
 * <p>
 * Created on Aug 27, 2016
 *
 * @author Thomas Colligan
 */
public class ChatActivity extends AppCompatActivity {
    //==============================================================================================
    // Class Properties
    //==============================================================================================

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;

    private String url = "http://dev3.apppartner.com/AppPartnerDeveloperTest/scripts/chat_log.php";

    //==============================================================================================
    // Static Class Methods
    //==============================================================================================

    public static void start(Context context) {
        Intent starter = new Intent(context, ChatActivity.class);
        context.startActivity(starter);
    }

    //==============================================================================================
    // Lifecycle Methods
    //==============================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//
//        chatAdapter = new ChatAdapter();
//
//        recyclerView.setAdapter(chatAdapter);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
//                LinearLayoutManager.VERTICAL,
//                false));
//
//
//
//        List<ChatLogMessageModel> tempList = new ArrayList<>();
//
//        ChatLogMessageModel chatLogMessageModel = new ChatLogMessageModel();
//        chatLogMessageModel.message = "This is test data. Please retrieve real data.";
//
//        tempList.add(chatLogMessageModel);
//        tempList.add(chatLogMessageModel);
//        tempList.add(chatLogMessageModel);
//        tempList.add(chatLogMessageModel);
//        tempList.add(chatLogMessageModel);
//        tempList.add(chatLogMessageModel);
//        tempList.add(chatLogMessageModel);
//        tempList.add(chatLogMessageModel);
//
//        chatAdapter.setChatLogMessageModelList(tempList);

        final ListView listView = (ListView) findViewById(R.id.myList);

        // TODO: Make the UI look like it does in the mock-up. Allow for horizontal screen rotation.

        // TODO: Retrieve the chat data from http://dev3.apppartner.com/AppPartnerDeveloperTest/scripts/chat_log.php
        // TODO: Parse this chat data from JSON into ChatLogMessageModel and display it.

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<ChatData>> call = api.getChatLog();

        call.enqueue(new Callback<List<ChatData>>() {
            @Override
            public void onResponse(Call<List<ChatData>> call, Response<List<ChatData>> response) {
                List<ChatData> chatData = response.body();

                String[] names = new String[chatData.size()];

                for (int i = 0; i < chatData.size(); i++) {
                    names[i] = chatData.get(i).getUsername();
                }

                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_2, names));

//                for(ChatData d: chatData){
//                    Log.d("user_id", d.getId());
//                    Log.d("username", d.getUsername());
//                    Log.d("avatar_url", d.getAvatar_url());
//                    //"user_id" : "3", "username" : "Justin LeClair", "avatar_url"
//                }

            }

            @Override
            public void onFailure(Call<List<ChatData>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}