package com.example.fitnesszone3.ui.dashboard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fitnesszone3.R;

import static android.content.Context.MODE_PRIVATE;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView tname = root.findViewById(R.id.textname);
        final TextView tbmi = root.findViewById(R.id.fbmi);
        final TextView tt = root.findViewById(R.id.ftarget);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) { 
                //code after chnaging
                SharedPreferences prefs = getActivity().getSharedPreferences("FitnessZone", MODE_PRIVATE);
                String sname = prefs.getString("name", "No name defined");
                String bmi = prefs.getString("bmi", "No bmi calculated");
                String stt = prefs.getString("calories", "No bmi calculated");
                tname.setText(sname);
                tbmi.setText("BMI  "+bmi+"kg/m");
                tt.setText("Target  "+stt+"/kcal");
            }
        });
        return root;
    }
}