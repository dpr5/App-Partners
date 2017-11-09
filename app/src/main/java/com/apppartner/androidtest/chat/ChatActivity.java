package com.apppartner.androidtest.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.apppartner.androidtest.MainActivity;
import com.apppartner.androidtest.R;

import java.util.ArrayList;
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
    ListView listView;
    ArrayList<String> aa = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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



        // TODO: Make the UI look like it does in the mock-up. Allow for horizontal screen rotation.

        // TODO: Retrieve the chat data from http://dev3.apppartner.com/AppPartnerDeveloperTest/scripts/chat_log.php
        // TODO: Parse this chat data from JSON into ChatLogMessageModel and display it.
//************************************************************************************************************************************
        // I am disregarding the recycler view for now to get the API call working.
        // I will implement that after I can make a sucessful call and retrieve data
//************************************************************************************************************************************
        listView = (ListView) findViewById(R.id.myList);

        getChat();
    }

    private void getChat() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Chat>> call = api.getChatLog();

        call.enqueue(new Callback<List<Chat>>() {
            @Override
            public void onResponse(Call<List<Chat>> call, Response<List<Chat>> response) {
                List<Chat> heroList = response.body();
                //Creating an String array for the ListView

                String[] heroes = new String[heroList.size()];

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < heroList.size(); i++) {
                    heroes[i] = heroList.get(i).getUsername();

                }


                //displaying the string array into listview
                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes));

//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.customlistview, aa);
//                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Chat>> call, Throwable t) {
                //Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Message", t.getMessage());
            }
        });
    }

}
