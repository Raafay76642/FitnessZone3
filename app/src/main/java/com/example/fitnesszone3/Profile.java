package com.example.fitnesszone3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    EditText Name,Email,Age,Height,Weight;
    String sname,sEmail,sAge,sHeight,sWeight;

    private ProgressDialog mProgressBarsaving;
    DatabaseReference databaseProfileRef;
    FirebaseDatabase database;
    String id;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        database =FirebaseDatabase.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();
        databaseProfileRef = database.getReference("Users");
        id =firebaseAuth.getCurrentUser().getUid();
//Progress bar
        mProgressBarsaving = new ProgressDialog(Profile.this);

        getdata();
        //Getting Inputs from Xml
        Name=findViewById(R.id.Uname);
        Email=findViewById(R.id.Email);
        Age=findViewById(R.id.age);
        Height=findViewById(R.id.Height);
        Weight=findViewById(R.id.weight);
    }


    public void UpdateData(View view)
    {
        sEmail=Email.getText().toString();
        sHeight=Height.getText().toString();
        sAge=Age.getText().toString();
        sWeight=Weight.getText().toString();
        sname=Name.getText().toString();
        mProgressBarsaving.setMessage("Saving. . .!");
        mProgressBarsaving.show();

        ProfileModelClass profileModelCalss = new ProfileModelClass(sname,sEmail,sAge,sWeight,sHeight);

        databaseProfileRef.child(id).child("Profile").setValue(profileModelCalss).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                mProgressBarsaving.cancel();
                final Toast toast = Toast.makeText(Profile.this, "Data is Saved", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        SharedPreferences.Editor editor = getSharedPreferences("FitnessZone", MODE_PRIVATE).edit();
        editor.putString("name",sname);
        editor.putString("age",sAge);
        editor.putString("weight",sWeight);
        editor.putString("Height",sHeight);
        editor.putString("Email",sEmail);
        editor.apply();
        Intent intent = new Intent(Profile.this,MainActivity.class);
        startActivity(intent);

    }


    public void getdata(){

        mProgressBarsaving.setMessage("Loading. . .!");
        mProgressBarsaving.show();
        databaseProfileRef.child(id).child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    ProfileModelClass model_class=dataSnapshot.getValue(ProfileModelClass.class);
                    Name.setText(model_class.getName());
                    Email.setText(model_class.getEmail());
                    Age.setText(model_class.getAge());
                    Weight.setText((model_class.getWeight()));
                    Height.setText((model_class.getHeight()));
                    mProgressBarsaving.cancel();
                }
                else {
                    Toast.makeText(Profile.this, "Please Complete your Profile", Toast.LENGTH_SHORT).show();
                    mProgressBarsaving.cancel();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                mProgressBarsaving.cancel();
            }
        });}
}
