package com.example.air;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public void onImageClick(View view){
        Intent intent = new Intent(this, secondActivity.class);
        startActivity(intent);
    }
    //private static int SPLASH_TIME_OUT = 2000;

    //Hooks
    View first_line,goBtn;
    TextView second_line;

    //Animations
    Animation topAnimation,bottomAnimation,middleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        middleAnimation = AnimationUtils.loadAnimation(this,R.anim.middie_animation);

        //Hooks
        first_line = findViewById(R.id.first_line);
        second_line = findViewById(R.id.second_line);

        goBtn = findViewById(R.id.goBtn);

        first_line.setAnimation(topAnimation);
        second_line.setAnimation(middleAnimation);

        goBtn.setAnimation(bottomAnimation);

        //Splash Screen
    //    new Handler().postDelayed(new Runnable(){
    //        @Override
    //        public void run(){
    //            Intent intent = new Intent(MainActivity.this,secondActivity.class);
    //            startActivity(intent);
    //            finish();
    //        }
    //    },SPLASH_TIME_OUT);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}