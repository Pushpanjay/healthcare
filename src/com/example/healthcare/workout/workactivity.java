package com.example.healthcare.workout;
 
import com.example.healthcare.dashboard.FriendsActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
 
public class workactivity extends ListActivity {
 
	static final String[] Android_logos = 
               new String[] { "   PushUps   ", "   SitUps   ", "   Squats   "};
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		setListAdapter(new MyArrayAdapter(this, Android_logos));
 
	}
 
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
 
		String selectedValue = (String) getListAdapter().getItem(position);
		Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
		Intent i;
		switch (position) {
		case 0:
			i = new Intent(this,SensorActivity.class );
	        startActivity(i);
			break;
		case 1:
			i = new Intent(this,SitUps.class );
	        startActivity(i);
			break;
		case 2:
			i = new Intent(this,Squats.class );
	        startActivity(i);
			break;
			
		}
 
	}
 
}