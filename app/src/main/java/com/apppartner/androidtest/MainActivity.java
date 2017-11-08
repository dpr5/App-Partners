package com.apppartner.androidtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.apppartner.androidtest.animation.AnimationActivity;
import com.apppartner.androidtest.chat.ChatActivity;
import com.apppartner.androidtest.login.LoginActivity;


/**
 * The main screen that lets you navigate to all other screens in the app.
 * <p/>
 * Created on Aug 22, 2016
 *
 * @author Thomas Colligan
 */
public class MainActivity extends AppCompatActivity
{
    //==============================================================================================
    // Lifecycle Methods
    //==============================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle(R.string.activity_main_title);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.top_toolbar);
        setSupportActionBar(toolbar);

        toolbar.inflateMenu(R.menu.toolbar);

        /**
         * =========================================================================================
         * INSTRUCTIONS
         * =========================================================================================
         *
         * 1. UI must work on Android phones of multiple sizes. Do not worry about Android Tablets.
         *
         * 2. Use this starter project as a base and build upon it. It is ok to remove some of the
         *    provided code if necessary.
         *
         * 3. Read the additional 'TODO' comments throughout the codebase, they will guide you.
         *
         * 3. Please take care of the bug(s) we left for you in the project as well.
         *
         * Thank you and Good luck. - App Partner
         * =========================================================================================
         */

        // TODO: Make the UI look like it does in the mock-up
        // TODO: Add a ripple effect when the buttons are clicked
    }

    //==============================================================================================
    // Button Click Methods
    //==============================================================================================

    public void onChatClicked(View v)
    {
        Intent chat = new Intent(MainActivity.this, ChatActivity.class);
        startActivity(chat);
    }

    public void onLoginClicked(View v)
    {
        Intent login = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(login);
    }

    public void onAnimationClicked(View v)
    {
        Intent anim = new Intent(MainActivity.this, AnimationActivity.class);
        startActivity(anim);
    }
}