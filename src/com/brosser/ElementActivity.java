package com.brosser;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.net.Uri;

import com.brosser.model.Element;
import com.brosser.model.ElementTable;

public class ElementActivity extends Activity {
	
	private ImageButton star;
	private ImageButton atom;
	private ImageButton wiki;
	private Spinner spinner;
	
    /** Called when the activity is first created. */
    @Override 
    public void onCreate(Bundle state) {
    	super.onCreate(state);
       
        // Install the view
        setContentView(R.layout.element);
        
        // Load images
        star = ((ImageButton)findViewById(R.id.IB_star));
        	star.setImageResource(R.drawable.star_on);
        atom = ((ImageButton)findViewById(R.id.IB_atom));
        	atom.setImageResource(R.drawable.atom_small);
        wiki = ((ImageButton)findViewById(R.id.IB_wiki));
        	wiki.setImageResource(R.drawable.wiki);
        spinner = ((Spinner)findViewById(R.id.spinner));
        
        // Populate spinner item list
        List<String> lsElements = new ArrayList<String>();
        for(int i=0; i<18*7; i++) {
        	Element element = ElementTable.getElement(i);
        	lsElements.add(element.getNumber() + " " + element.getSymbol() + 
        			" " + element.getName());
        }
        
        ArrayAdapter<String> aspnElements = new ArrayAdapter<String>(this, R.layout.spinner, 
        		lsElements);
        
        // Create the element selector spinner
        aspnElements.setDropDownViewResource(R.layout.spinneritem);
        spinner.setAdapter(aspnElements);
        spinner.setSelection(ElementTable.selectedNumber(ElementTable.getActiveElement()));
        
        reloadText();
     
        // React to events from the buttons
        wiki.setOnClickListener(new ImageButton.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String url = "http://en.wikipedia.org/wiki/Hydrogen";
				Intent wikiIntent = new Intent(Intent.ACTION_VIEW);
				wikiIntent.setData(Uri.parse(url));
				startActivity(wikiIntent);				
			}
        });
        
        // Set up a callback for the spinner (selecting element)
        spinner.setOnItemSelectedListener(
        	new OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					if(position != ElementTable.getActiveElement().getNumber()-1) {
						ElementTable.setActiveElement(ElementTable.getElement(position));
						reloadText();
					}
				}
				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
				}
			});
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	// Screen orientation according to sensor
    	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    }
    
    public void reload() {
        onStop();
        onCreate(getIntent().getExtras());
    }
    
    public void reloadText() {
        String text = ElementTable.getActiveElement().getInfoAsString();
        for(int i=0; i<50; i++) {
        	text += "dummy row\n";
        }
        ((TextView)findViewById(R.id.info)).setText(text);
        ((TextView)findViewById(R.id.header)).setText(ElementTable.getActiveElement().getName());
    }
    
}
