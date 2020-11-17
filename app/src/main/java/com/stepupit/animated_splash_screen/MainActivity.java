package com.stepupit.animated_splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        TextView txtFood,txtDelivery;
        RelativeLayout relativeLayout;
        Animation   txtAnimation,layoutAnimation ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDelivery=findViewById(R.id.delivery_id);
        txtFood=findViewById(R.id.food_id);
        relativeLayout=findViewById(R.id.relativeLayout_id);
        txtAnimation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.fall_down);
        layoutAnimation=AnimationUtils.loadAnimation(MainActivity.this,R.anim.bottom_to_top);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setVisibility(View.VISIBLE);
                relativeLayout.setAnimation(layoutAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        txtFood.setVisibility(View.VISIBLE);
                        txtDelivery.setVisibility(View.VISIBLE);
                        txtFood.setAnimation(txtAnimation);
                        txtDelivery.setAnimation(txtAnimation);
                    }
                },900);
            }
        },500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Home_Activity.class);
                startActivity(intent);
                finish();
            }
        },6000);
    }
}