package com.brosser;

import java.util.ArrayList;
import java.util.List;

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
	
	private CheckBox checkBox;
	private TextView txtCheckBox, txtRadio, txtSpinner;
	private RadioButton rb1, rb2, rb3;
	private Spinner spinner;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        
        // Some options
        checkBox = (CheckBox) findViewById(R.id.cbxBox1);
        txtCheckBox = (TextView) findViewById(R.id.txtCheckBox);
        txtRadio = (TextView) findViewById(R.id.txtRadio);
        txtSpinner = (TextView) findViewById(R.id.txtSpinner);
        rb1 = (RadioButton) findViewById(R.id.RB1);
        rb2 = (RadioButton) findViewById(R.id.RB2);
        rb3 = (RadioButton) findViewById(R.id.RB3);
        spinner = (Spinner) findViewById(R.id.spinner);
        
        // React to events from the checkbox
        checkBox.setOnClickListener(new CheckBox.OnClickListener() {
        	public void onClick(View v) {
        		if(checkBox.isChecked()) {
        			//txtCheckBox.setText("CheckBox: Box is checked");
        			txtCheckBox.setText(ElementTable.getActiveElement().getName());
        		}
        		else {
        			txtCheckBox.setText("Checkbox: Not checked");
        		}
        	}
        });
        
        // React to events from the RadioGroup
        rb1.setOnClickListener(new RadioGroup.OnClickListener() {
        	public void onClick(View v) {
        		txtRadio.setText("Radio: " + rb1.getText() + " picked");
        	}
        });
        
        rb2.setOnClickListener(new RadioGroup.OnClickListener() {
        	public void onClick(View v) {
        		txtRadio.setText("Radio: " + rb2.getText() + " picked");
        	}
        });
        
        rb3.setOnClickListener(new RadioGroup.OnClickListener() {
        	public void onClick(View v) {
        		txtRadio.setText("Radio: " + rb3.getText() + " picked");
        	}
        });       
        
        // Set up the Spinner entries
        List<String> lsSpinner = new ArrayList<String>();
        lsSpinner.add("English");
        lsSpinner.add("Deutsch");
        lsSpinner.add("Svenska");
        lsSpinner.add("Norsk");
      /*
        lsSpinner.add("Dansk");
        lsSpinner.add("Suomi");
        lsSpinner.add("Nederlands");
        lsSpinner.add("Français");
        lsSpinner.add("Italiano");
        lsSpinner.add("Pусский");
        lsSpinner.add("Ceština");
       */
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