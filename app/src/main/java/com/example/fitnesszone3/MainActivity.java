package com.example.fitnesszone3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        //for checking eithe the user is loged in or not
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getInstance().getCurrentUser() == null) {
            Intent intent = new Intent(MainActivity.this, Signup.class);
            startActivity(intent);
        }

        FirebaseMessaging.getInstance().subscribeToTopic("Gym")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (!task.isSuccessful()) {

                        }

                    }
                });


    }
    public void openbmi(View view)
    {
        Intent intent = new Intent(this, Gender.class);
        startActivity(intent);
    }
    public  void openworkout(View view)
    {
        Intent intent = new Intent(this, workoutlist.class);
        startActivity(intent);
    }
    public  void OpenSetReminder(View view)
    {
        Intent intent = new Intent(this, Reminder.class);
        startActivity(intent);
    }
    public void openprofile(View view)
    {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
    public void openDiet(View view)
    {
        Intent intent = new Intent(this, DietInformation.class);
        startActivity(intent);
    }


}