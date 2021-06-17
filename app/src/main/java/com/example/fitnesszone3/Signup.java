package com.example.fitnesszone3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
    }

    public void openverifycode(View view)
    {
        Intent intent = new Intent(this, VerifyCode.class);
        startActivity(intent);
    }
}