package com.example.fitnesszone3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import kr.pe.burt.android.lib.faimageview.FAImageView;

public class workoutanimation extends AppCompatActivity {
    String activity;
    FAImageView faImageView1;
    TextView tittlet,dest;
    Button sbutton;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutanimation);
        getSupportActionBar().hide();
        counter=0;
        SharedPreferences prefs = getSharedPreferences("FitnessZone", MODE_PRIVATE);
        activity = prefs.getString("activityno", "No gender defined");
        tittlet =findViewById(R.id.titleani);
        dest = findViewById(R.id.desani);
        sbutton = findViewById(R.id.buttonstart);
        faImageView1 = (FAImageView)findViewById(R.id.faimageview1);
        faImageView1.setInterval(1600);
        faImageView1.setLoop(true);
        showanimation();
        faImageView1.setOnStartAnimationListener(new FAImageView.OnStartAnimationListener() {
            @Override
            public void onStartAnimation() {
                Log.v("FAImageView", "Animation started");
            }
        });

        faImageView1.setOnFinishAnimationListener(new FAImageView.OnFinishAnimationListener() {
            @Override
            public void onFinishAnimation(boolean isLoopAnimation) {
                if(isLoopAnimation) {
                    if(counter < 15)
                    {
                    counter++;
                    dest.setText(""+counter);}
                    else
                        faImageView1.stopAnimation();

                    Log.v("FAImageView", "finished an animation cycle.");
                } else {
                    Log.v("FAImageView", "Animation is completed");
                }
            }
        });


    }

    public void startbutton(View view)
    {
        counter=0;
        sbutton.setText("Start Again");
        faImageView1.startAnimation();
    }

    public void showanimation()
    {
        if(activity.equals("1"))
        {
            tittlet.setText("bicycle crunches");
            dest.setText(""+counter);
            faImageView1.addImageFrame(R.drawable.neo_bicycle_crunches_a);
            faImageView1.addImageFrame(R.drawable.neo_bicycle_crunches_b);
            faImageView1.addImageFrame(R.drawable.neo_bicycle_crunches_c);
        }
        if(activity.equals("2"))
        {
            tittlet.setText("butt bridge");
            dest.setText(""+counter);
            faImageView1.addImageFrame(R.drawable.neo_butt_bridge_a);
            faImageView1.addImageFrame(R.drawable.neo_butt_bridge_b);
        }
        if(activity.equals("3"))
        {
            tittlet.setText("Swimmer and Superman");
            dest.setText(""+counter);
            faImageView1.addImageFrame(R.drawable.neo_swimmer_and_superman_a);
            faImageView1.addImageFrame(R.drawable.neo_swimmer_and_superman_b);
            faImageView1.addImageFrame(R.drawable.neo_swimmer_and_superman_c);
        }
        if(activity.equals("4"))
        {
            tittlet.setText("Clapping Arm Crunch");
            dest.setText(""+counter);
            faImageView1.addImageFrame(R.drawable.neo_clapping_crunches_a);
            faImageView1.addImageFrame(R.drawable.neo_clapping_crunches_b);
            faImageView1.addImageFrame(R.drawable.neo_clapping_crunches_c);
        }
        if(activity.equals("5"))
        {
            tittlet.setText("cross Arm crunches");
            dest.setText(""+counter);
            faImageView1.addImageFrame(R.drawable.neo_cross_arm_crunches_a);
            faImageView1.addImageFrame(R.drawable.neo_cross_arm_crunches_b);
        }

        if(activity.equals("6"))
        {
            tittlet.setText("Dead bug");
            dest.setText(""+counter);
            faImageView1.addImageFrame(R.drawable.neo_dead_bug_a);
            faImageView1.addImageFrame(R.drawable.neo_dead_bug_b);
            faImageView1.addImageFrame(R.drawable.neo_dead_bug_c);
        }
        if(activity.equals("7"))
        {
            tittlet.setText("flutter kicks");
            dest.setText(""+counter);
            faImageView1.addImageFrame(R.drawable.neo_flutter_kicks_a);
            faImageView1.addImageFrame(R.drawable.neo_flutter_kicks_b);
            faImageView1.addImageFrame(R.drawable.neo_flutter_kicks_c);
        }
        if(activity.equals("8"))
        {
            tittlet.setText("leg drop");
            dest.setText(""+counter);
            faImageView1.addImageFrame(R.drawable.neo_leg_drop_a);
            faImageView1.addImageFrame(R.drawable.neo_leg_drop_b);
        }
        if(activity.equals("9"))
        {
            tittlet.setText("long Arm crunches");
            dest.setText(""+counter);
            faImageView1.addImageFrame(R.drawable.neo_long_arm_crunches_a);
            faImageView1.addImageFrame(R.drawable.neo_long_arm_crunches_b);
        }
        if(activity.equals("10"))
        {
            tittlet.setText("Mountain Climbers");
            dest.setText(""+counter);
            faImageView1.addImageFrame(R.drawable.neo_mountain_climbers_a);
            faImageView1.addImageFrame(R.drawable.neo_mountain_climbers_b);
            faImageView1.addImageFrame(R.drawable.neo_mountain_climbers_c);
            faImageView1.addImageFrame(R.drawable.neo_mountain_climbers_d);
        }
        if(activity.equals("11"))
        {
            tittlet.setText("bent leg twist");
            dest.setText(""+counter);
            faImageView1.addImageFrame(R.drawable.neo_neo_bent_leg_twist_a);
            faImageView1.addImageFrame(R.drawable.neo_neo_bent_leg_twist_b);
        }
        if(activity.equals("12"))
        {
            tittlet.setText("reclined oblique twist");
            dest.setText(""+counter);
            faImageView1.addImageFrame(R.drawable.neo_reclined_oblique_twist_a);
            faImageView1.addImageFrame(R.drawable.neo_reclined_oblique_twist_b);
            faImageView1.addImageFrame(R.drawable.neo_reclined_oblique_twist_c);
        }
        if(activity.equals("13"))
        {
            tittlet.setText("reverse crunches");
            dest.setText(""+counter);
            faImageView1.addImageFrame(R.drawable.neo_reverse_crunches_a);
            faImageView1.addImageFrame(R.drawable.neo_reverse_crunches_b);
        }
        if(activity.equals("14"))
        {
            tittlet.setText("Side leg rais left");
            dest.setText(""+counter);
            faImageView1.addImageFrame(R.drawable.neo_side_leg_raise_lefta);
            faImageView1.addImageFrame(R.drawable.neo_side_leg_raise_left_b);

        }
        if(activity.equals("15"))
        {
            tittlet.setText("bicycle crunches");
            dest.setText(""+counter);
            faImageView1.addImageFrame(R.drawable.neo_bicycle_crunches_a);
            faImageView1.addImageFrame(R.drawable.neo_bicycle_crunches_b);
            faImageView1.addImageFrame(R.drawable.neo_bicycle_crunches_c);
        }


    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        faImageView1.startAnimation();
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//            faImageView1.stopAnimation();
//    }
}