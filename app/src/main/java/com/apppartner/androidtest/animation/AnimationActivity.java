package com.apppartner.androidtest.animation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import com.apppartner.androidtest.MainActivity;
import com.apppartner.androidtest.R;

/**
 * Screen that displays the AppPartner icon.
 * The icon can be moved around on the screen as well as animated.
 * <p>
 * Created on Aug 28, 2016
 *
 * @author Thomas Colligan
 */
public class AnimationActivity extends AppCompatActivity {
    //==============================================================================================
    // Class Properties
    //==============================================================================================
    Button fade_button;
    ImageView image_to_fade;
    private boolean isFaded = false;
    //==============================================================================================
    // Static Class Methods
    //==============================================================================================

    public static void start(Context context) {
        Intent starter = new Intent(context, AnimationActivity.class);
        context.startActivity(starter);
    }

    //==============================================================================================
    // Lifecycle Methods
    //==============================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        fade_button = (Button) findViewById(R.id.anim_fade_button);
        image_to_fade = (ImageView) findViewById(R.id.logo_image);

        // TODO: Make the UI look like it does in the mock-up. Allow for horizontal screen rotation.
        // TODO: Add a ripple effect when the buttons are clicked

        // TODO: When the fade button is clicked, you must animate the AppPartner Icon.
        // TODO: It should fade from 100% alpha to 0% alpha, and then from 0% alpha to 100% alpha

        image_to_fade.setVisibility(View.VISIBLE);
        fade_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFaded == false){
                    image_to_fade.setVisibility(View.VISIBLE);
                    imageAnimation();
                    isFaded = true;
                }
                if(isFaded == true){
                    image_to_fade.setVisibility(View.INVISIBLE);
                    imageAnimationReverse();
                    isFaded = false;
                }
            }

        });
    }

    public void imageAnimation() {
        Animation img = new AlphaAnimation(1.00f, 0.00f);
        img.setDuration(3000);
        img.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                image_to_fade.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                image_to_fade.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        image_to_fade.startAnimation(img);

    }

    public void imageAnimationReverse() {
        Animation img = new AlphaAnimation(0.00f, 1.00f);
        img.setDuration(3000);
        img.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                image_to_fade.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                image_to_fade.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        image_to_fade.startAnimation(img);

    }

    // TODO: The user should be able to touch and drag the AppPartner Icon around the screen.


//        image_to_fade.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                ActionBar.LayoutParams layoutParams = (ActionBar.LayoutParams) image_to_fade.getLayoutParams();
//                switch(event.getAction())
//                {
//                    case MotionEvent.ACTION_DOWN:
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        int x_cord = (int)event.getRawX();
//                        int y_cord = (int)event.getRawY();
//
//
//                        layoutParams.leftMargin = x_cord -25;
//                        layoutParams.topMargin = y_cord - 75;
//
//                        image_to_fade.setLayoutParams(layoutParams);
//                        break;
//                    default:
//                        break;
//                }
//                return true;
//            }
//        });
    // TODO: Add a bonus to make yourself stick out. Music, color, fireworks, explosions!!!


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}