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
import android.widget.TextView;


public class SensorActivity extends Activity implements SensorEventListener {
      
	  private TextView tv1;
	  private SensorManager mSensorManager;
	  private Sensor mProximity;
	  private int count=0;

	  @Override
	  public final void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.pushups);
	    
	    tv1=(TextView) findViewById(R.id.Tv1);

	    // Get an instance of the sensor service, and use that to get an instance of
	    // a particular sensor.
	    mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	    mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
	    
	  }

	  @Override
	  public final void onAccuracyChanged(Sensor sensor, int accuracy) {
	    // Do something here if sensor accuracy changes.
	  }

	  @Override
	  public final void onSensorChanged(SensorEvent event) {
	    float distance = event.values[0];
	    if(distance==0)
	    {
	    count++;
	    tv1.setText(String.valueOf(count));
	    }
	    // Do something with this sensor data.
	  }

	  @Override
	  protected void onResume() {
	    // Register a listener for the sensor.
	    super.onResume();
	    mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
	  }

	  @Override
	  protected void onPause() {
	    // Be sure to unregister the sensor when the activity pauses.
	    super.onPause();
	    mSensorManager.unregisterListener(this);
	  }
	  
	  public void resetSteps(View v) {
			count=0;
			tv1.setText(String.valueOf(count));
		}
	  
	}