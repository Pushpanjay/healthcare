package com.example.healthcare.workout;

import com.example.healthcare.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class MyArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
 
	public MyArrayAdapter(Context context, String[] values) {
		super(context, R.layout.custom_list, values);
		this.context = context;
		this.values = values;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.custom_list, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.txt);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
		textView.setText(values[position]);
 
		// Change icon based on name
		
		String s = values[position];
 
		System.out.println(s);
 
		if (s.equals("   PushUps   ")) {
			imageView.setImageResource(R.drawable.pushup);
		} else if (s.equals("   SitUps   ")) {
			imageView.setImageResource(R.drawable.situp);
		} else if (s.equals("   Squats   ")) {
			imageView.setImageResource(R.drawable.squat);
		}
 
		return rowView;
	}
}