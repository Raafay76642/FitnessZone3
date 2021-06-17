package com.example.fitnesszone3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class Gender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender2);
        getSupportActionBar().hide();
    }

    public void Savefemalegender(View view)
    {
        SharedPreferences.Editor editor = getSharedPreferences("FitnessZone", MODE_PRIVATE).edit();
        editor.putString("gender", "female");
        editor.apply();
        Intent intent = new Intent(this, BmiCalculator.class);
        startActivity(intent);
    }
    public void Savemalegender(View view)
    {
        SharedPreferences.Editor editor = getSharedPreferences("FitnessZone", MODE_PRIVATE).edit();
        editor.putString("gender", "male");
        editor.apply();
        Intent intent = new Intent(this, BmiCalculator.class);
        startActivity(intent);
    }
}