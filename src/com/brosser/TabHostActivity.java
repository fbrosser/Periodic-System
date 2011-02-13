package com.brosser;

import com.brosser.model.ElementTable;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class TabHostActivity extends TabActivity {
	
	/** Called when the activity is first created. */
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		TabHost tabHost = getTabHost();
		
		// Inflate the view
		LayoutInflater.from(this).inflate(R.layout.tabs, tabHost.getTabContentView(), true);
		
		// Set up the element table
		ElementTable elementTable = ElementTable.getInstance(getResources());
	
		// Add tabs
		tabHost.addTab(tabHost.newTabSpec("table_view")
				.setIndicator("", 
						getResources().getDrawable(R.drawable.table))
				.setContent(new Intent(this, TableActivity.class)
					.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));
		
		tabHost.addTab(tabHost.newTabSpec("element_view")
				.setIndicator("",
						getResources().getDrawable(R.drawable.atom))
				.setContent(new Intent(this, ElementActivity.class)
					.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));
		
		tabHost.addTab(tabHost.newTabSpec("settings_view")
				.setIndicator("",
					getResources().getDrawable(R.drawable.android_settings_icon))
					.setContent(new Intent(this, SettingsActivity.class)
					.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));
	}

}
