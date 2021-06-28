package com.example.fitnesszone3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DietInformation extends AppCompatActivity {

    TextView tbreakfast,tlunhc,tdinner,tsnakes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_information);
        getSupportActionBar().hide();
        tbreakfast = findViewById(R.id.breakfast);
        tlunhc = findViewById(R.id.Lunch);
        tdinner = findViewById(R.id.Dinner);
        tsnakes = findViewById(R.id.Sanaks);
        showdiet();
    }

    public void showdiet()
    {
        tbreakfast.setText("2 Brown Bread 2-3\nEgg Omelette(Without yolk)\n1 Cup Juice (200 - 300 ml, No sugar");
        tlunhc.setText("3-4 Pieces of baked fish\nand salad");
        tdinner.setText("A bowl of small serving of White\nBrown rice with Lentil\n curry");
        tsnakes.setText(" Vegetable Soup\nor Lentil\n or Bean Soup (200-300 gram)");

    }
}