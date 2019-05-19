package com.example.healthcare.dashboard;

import name.bagi.levente.pedometer.Pedometer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthcare.BaseActivity;
import com.example.healthcare.R;
import com.example.healthcare.bmi.HealthAdvicer;
import com.example.healthcare.medsreminder.ui.ListViewActivity;
import com.example.healthcare.medsreminder.ui.MainActivity;
import com.example.healthcare.workout.workactivity;

public class AndroidDashboardDesignActivity extends BaseActivity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);
        super.onCreateDrawer();
        
        /**
         * Creating all buttons instances
         * */
        // Dashboard News feed button
        Button btn_pedometer = (Button) findViewById(R.id.btn_pedometer);
        
        // Dashboard Friends button
        Button btn_BMI = (Button) findViewById(R.id.btn_BMI);
        
        // Dashboard Messages button
        Button btn_medicine = (Button) findViewById(R.id.btn_medicine);
        
        // Dashboard Places button
        Button btn_emer = (Button) findViewById(R.id.btn_emer);
        
        // Dashboard Events button
        Button btn_workout = (Button) findViewById(R.id.btn_workout);
        
        // Dashboard Photos button
        Button btn_photos = (Button) findViewById(R.id.btn_photos);
        
        /**
         * Handling all button click events
         * */
        
        // Listening to News Feed button click
        btn_pedometer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), Pedometer.class);
				startActivity(i);
			}
		});
        
       // Listening Friends button click
        btn_BMI.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), HealthAdvicer.class);
				startActivity(i);
			}
		});
        
        // Listening Messages button click
        btn_medicine.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), ListViewActivity.class);
				startActivity(i);
			}
		});
        
        // Listening to Places button click
        btn_emer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				
			}
		});
        
        // Listening to Events button click
        btn_workout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), workactivity.class);
				startActivity(i);
			}
		});
        
        // Listening to Photos button click
        btn_photos.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
			
			}
		});
    }
}