package com.example.healthcare.workout;

import com.example.healthcare.R;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


public class SitUps extends Activity {
	
	private TextView textViewCount;
	
	private Button buttonReset;
	
	private SensorManager sensorManager;
	private float acceleration;
	
	
	private float previousZ;
	private float currentZ;
	private int numCount;
	
	
	//private SeekBar seekBar;
	private int threshold;
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sit_ups);
        
        //textViewX = (TextView)findViewById(R.id.textViewX);
        //textViewY = (TextView)findViewById(R.id.textViewY);
        //textViewZ = (TextView)findViewById(R.id.textViewZ);
        
        
        textViewCount = (TextView)findViewById(R.id.textSteps);
    
        
        buttonReset = (Button)findViewById(R.id.buttonReset);

        threshold=6;
       
        
        previousZ=0;
        currentZ=0;
        numCount=0;
        
        acceleration=0.00f;
        
        enableAccelerometerListening();
        
        }

    

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
	
	private void enableAccelerometerListening() {
		// TODO Auto-generated method stub
	sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
	sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	private SensorEventListener sensorEventListener=new SensorEventListener()
	{
		
		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			
			float x=event.values[0];
			float y=event.values[1];
			float z=event.values[2];
			
			currentZ=z;
			
			if( Math.abs(currentZ-previousZ)>threshold)
			{
				numCount++;
				int count=numCount/2;
				textViewCount.setText(String.valueOf(count));
			}
			
		//	textViewX.setText(String.valueOf(x));
		//	textViewY.setText(String.valueOf(y));
		//	textViewZ.setText(String.valueOf(z));
			
			previousZ=z;
			
		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	
	public void resetSteps(View v) {
		numCount=0;
		textViewCount.setText(String.valueOf(numCount));
	}

	

   
	
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    
    
}
