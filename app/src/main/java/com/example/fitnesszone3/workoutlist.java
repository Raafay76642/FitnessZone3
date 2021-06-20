package com.example.fitnesszone3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class workoutlist extends AppCompatActivity {
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutlist);
        getSupportActionBar().hide();
        editor = getSharedPreferences("FitnessZone", MODE_PRIVATE).edit();

    }
    public void openactivty1(View view)
    {
        editor.putString("activityno", "1");
        editor.apply();
        Intent intent = new Intent(this, workoutanimation.class);
        startActivity(intent);
    }
    public void openactivty2(View view)
    {
        editor.putString("activityno", "2");
        editor.apply();
        Intent intent = new Intent(this, workoutanimation.class);
        startActivity(intent);
    }
    public void openactivty3(View view)
    {
        editor.putString("activityno", "3");
        editor.apply();
        Intent intent = new Intent(this, workoutanimation.class);
        startActivity(intent);
    }
    public void openactivty4(View view)
    {
        editor.putString("activityno", "4");
        editor.apply();
        Intent intent = new Intent(this, workoutanimation.class);
        startActivity(intent);
    }
    public void openactivty5(View view)
    {
        editor.putString("activityno", "5");
        editor.apply();
        Intent intent = new Intent(this, workoutanimation.class);
        startActivity(intent);
    }
    public void openactivty6(View view)
    {
        editor.putString("activityno", "6");
        editor.apply();
        Intent intent = new Intent(this, workoutanimation.class);
        startActivity(intent);
    }
    public void openactivty7(View view)
    {
        editor.putString("activityno", "7");
        editor.apply();
        Intent intent = new Intent(this, workoutanimation.class);
        startActivity(intent);
    }
    public void openactivty8(View view)
    {
        editor.putString("activityno", "8");
        editor.apply();
        Intent intent = new Intent(this, workoutanimation.class);
        startActivity(intent);
    }
    public void openactivty9(View view)
    {
        editor.putString("activityno", "9");
        editor.apply();
        Intent intent = new Intent(this, workoutanimation.class);
        startActivity(intent);
    }
    public void openactivty10(View view)
    {
        editor.putString("activityno", "10");
        editor.apply();
        Intent intent = new Intent(this, workoutanimation.class);
        startActivity(intent);
    }
    public void openactivty11(View view)
    {
        editor.putString("activityno", "11");
        editor.apply();
        Intent intent = new Intent(this, workoutanimation.class);
        startActivity(intent);
    }
    public void openactivty12(View view)
    {
        editor.putString("activityno", "12");
        editor.apply();
        Intent intent = new Intent(this, workoutanimation.class);
        startActivity(intent);
    }
    public void openactivty13(View view)
    {
        editor.putString("activityno", "13");
        editor.apply();
        Intent intent = new Intent(this, workoutanimation.class);
        startActivity(intent);
    }
    public void openactivty14(View view)
    {
        editor.putString("activityno", "14");
        editor.apply();
        Intent intent = new Intent(this, workoutanimation.class);
        startActivity(intent);
    }
    public void openactivty15(View view)
    {
        editor.putString("activityno", "15");
        editor.apply();
        Intent intent = new Intent(this, workoutanimation.class);
        startActivity(intent);
    }
}