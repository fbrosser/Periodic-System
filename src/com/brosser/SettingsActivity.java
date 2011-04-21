package com.brosser;

import java.util.ArrayList;
import java.util.List;

import com.brosser.database.DatabaseHandler;
import com.brosser.model.Element;
import com.brosser.model.ElementTable;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class SettingsActivity extends Activity {
	
	private CheckBox showUnits, showColours, lockLandscape;
	private Spinner spinner;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        
        // Option checkboxes
        showUnits = (CheckBox) findViewById(R.id.showUnits);
        showColours = (CheckBox) findViewById(R.id.showColours);
        lockLandscape = (CheckBox) findViewById(R.id.lockLandscape);
        final CheckBox[] checkBoxes = {showUnits, showColours, lockLandscape};
        
        spinner = (Spinner) findViewById(R.id.spinner);
        
        for(int i = 0; i < 3; i++) {
        	final int id = i;
        	checkBoxes[id].setChecked(true);
        	checkBoxes[id].setOnClickListener(new CheckBox.OnClickListener() {
            	public void onClick(View v) {
            		ElementTable.setOption(id, checkBoxes[id].isChecked());
            	}
            });
        }
        
        // Set up the Spinner entries
        List<String> lsSpinner = new ArrayList<String>();
        lsSpinner.add("English");
        lsSpinner.add("Deutsch");
        lsSpinner.add("Svenska");
        lsSpinner.add("Norsk");
        
        ArrayAdapter<String> aSpinner = new ArrayAdapter<String>(this,
        		android.R.layout.simple_spinner_item, lsSpinner);
        aSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spinner.setAdapter(aSpinner);
        
        // Set up a callback for the spinner
        spinner.setOnItemSelectedListener( new OnItemSelectedListener() {
        	public void onNothingSelected(AdapterView<?> arg0) {
        		
        	}
        	public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        		Element.setLanguage(DatabaseHandler.getLanguage(position));
        	}
        });
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    }
}