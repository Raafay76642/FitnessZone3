package com.example.fitnesszone3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class BmiCalculator extends AppCompatActivity {
    TextView QuestionTextView;
    TextView DiscriptionTextView;
    EditText QuestioET;
    ProgressBar progressBar;
    String answer[] = new String[5];
    String[] question ={"what's your name?","what's your Age?","what's your Height?","what's your Weight?","what's your Target weight?"};
    String[] discription ={"Enter Your First and Last name","Enter Your Age in Round years","How Tall are you Enter Hight in centi meters","what's your weight in KG we need i to calculate your BMI?","whats Your weight target which you want to achieve?"};
 //   String[] hints ={"Enter your complete name","Enter Your age in years?","Enter Your Height in Centi meters?","Enter Your Weight in Kg?"};
    int Qcounter=0;
     float    height,weight,age,BMI,targetweight,Calories;
     String name,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);
        QuestionTextView = findViewById(R.id.Question);
        DiscriptionTextView = findViewById(R.id.discription);
        QuestioET=findViewById(R.id.answerET);
                progressBar=findViewById(R.id.pb);
        getSupportActionBar().hide();
                // prograss bar setting
        progressBar.setMax(5);
        progressBar.setProgress(Qcounter+1);
        //Set Question
        QuestionTextView.setText(question[0]);
        //Set Discription
        DiscriptionTextView.setText(discription[Qcounter]);
        //Set hints
        QuestioET.setText("");
        // Getting shared prefrence
        SharedPreferences prefs = getSharedPreferences("FitnessZone", MODE_PRIVATE);
         gender = prefs.getString("gender", "No gender defined");

    }

    public void Continue(View view)
    {
        Qcounter++;
        if(Qcounter < 5)
        {
        // prograss bar setting
        progressBar.setProgress(Qcounter+1);
        //Set Question
        QuestionTextView.setText(question[Qcounter]);
        //Set Discription
        DiscriptionTextView.setText(discription[Qcounter]);
        answer[Qcounter-1] = QuestioET.getText().toString();
        //Set hints
        QuestioET.setText("");}
        else
            Toast.makeText(BmiCalculator.this, "Enter the Submit button to Calculate Your BMI",
                    Toast.LENGTH_LONG).show();
    }
    public void calculateBMI()
    {
        name = answer[0];
        age = Float.parseFloat(answer[1]);
        height = Float.parseFloat( answer[2]);
        weight = Float.parseFloat(answer[3]);
    //    targetweight = Float.parseFloat(answer[4]);
        float heightmeter = height/100;
        BMI = weight/ (heightmeter*heightmeter);

    }
    public void calculateCalories()
    {
        calculateBMI();
        float weightpound= (float) (weight *2.2046);
        float heightIn = (float)( height * 0.39370);
        if(gender.equals("female"))
        {
            Calories = (float) ((float) (655.1 + (4.35 * weightpound) + (4.7 * heightIn))-(4.7 * age));
            Calories= (float) (655.1 + (4.35 * weight) + (4.7 * height) - (4.7 * age));
            Toast.makeText(BmiCalculator.this, "Your BMI Is ="+Calories+" "+BMI+" "+gender,
                    Toast.LENGTH_LONG).show();
        }
        if(gender.equals("male"))
        {
            Calories= (float) (655.1 + (4.35 * weight) + (4.7 * height) - (4.7 * age));
            Toast.makeText(BmiCalculator.this, "Your BMI Is ="+Calories+" "+BMI+" "+gender,
                    Toast.LENGTH_LONG).show();
        }
    }

    public void ShowResult(View view)
    {
        calculateCalories();
        TextView tname,tbmi,tcal,ttcal;

        SharedPreferences.Editor editor = getSharedPreferences("FitnessZone", MODE_PRIVATE).edit();
        editor.putString("name", name);
        editor.putString("bmi", ""+BMI);
        editor.putString("calories", ""+Calories);
        editor.apply();

        final Dialog dialog = new Dialog(BmiCalculator.this);
        dialog.setContentView(R.layout.resultdialouge);
        tname = dialog.findViewById(R.id.ename);
        tbmi = dialog.findViewById(R.id.ebmi);
        tcal = dialog.findViewById(R.id.ecalories);
        ttcal = dialog.findViewById(R.id.etarget);
        tname.setText(""+name);
        tbmi.setText(""+BMI+" kg/m2");
        tcal.setText(""+Calories+"/kcal");
        ttcal.setText(""+(Calories-340)+"/kcal");
        Button dialogButton = (Button) dialog.findViewById(R.id.applydioloudefilter);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = new Intent(BmiCalculator.this,MainActivity.class);
                startActivity(intent);
            }
        });
        dialog.show();

    }
}