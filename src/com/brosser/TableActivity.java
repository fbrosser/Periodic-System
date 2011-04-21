package com.brosser;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Scroller;

import com.brosser.model.ElementTable;

public class TableActivity extends Activity implements OnClickListener {
	
	private Button[][] buttons = new Button[ElementTable.getGroups()][ElementTable.getPeriods()];
    
	/** Called when the activity is first created. */
    @Override 
    public void onCreate(Bundle state) {
        super.onCreate(state);
        populateTable();
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	populateTable();
    	
    	/** Adjust to options */
    	if(ElementTable.getOption(2)) {
    		// Fix screen orientation to landscape mode
    		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    	}
    	else {
    		// According to sensor
    		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    	}
    	
    	if(!ElementTable.getOption(1)) {
    		for(int i=0; i<ElementTable.getGroups(); i++) {
        		for(int j=0; j<ElementTable.getPeriods(); j++) {
        			if(j > 2 && j < 7) {
    	    			buttons[i][j].setBackgroundColor(Color.WHITE);
        			}
        			else if(i > 1 && i < 17 && (j == 8 || j == 9)) {
        				buttons[i][j].setBackgroundColor(Color.WHITE);
        			}
        			else if(j < 3 && j > 0 && (i < 2 || i > 11)) {
        				buttons[i][j].setBackgroundColor(Color.WHITE);
        			}
        			else if(j == 0 && (i == 0 || i == 17)) {
        				buttons[i][j].setBackgroundColor(Color.WHITE);
        			}
        		}
        	}
    	}
    	else {
        	// Do nothing = show colours
    	}
    }

    /** Callback function for the buttons */
	@Override
	public void onClick(View src)  {
		
		if(src == buttons[2][5] || src == buttons[2][6]) {
		    scrollDown();
			return;
		}

		for(int i=0; i<ElementTable.getGroups(); i++) {
			for(int j=0; j<ElementTable.getPeriods(); j++) {
				if(src == buttons[i][j]) {
					ElementTable.setActiveElement(ElementTable.getElement(i, j));
				}
			}
		}
		
		// Show element view for the selected element
		TabHostActivity tabHost = (TabHostActivity) this.getParent();
		tabHost.switchTab(1);
	}
	
	// Scroll down to bottom of scroll view
	private void scrollDown() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ScrollView scrollView = (ScrollView)findViewById(R.id.scrollRoot);
                scrollView.scrollTo(scrollView.getBottom(), scrollView.getBottom());
            }
        }, 1);
    }
	
	private void populateTable() {
        // Install the view
        setContentView(R.layout.table);
        
        // Populate the button matrix
        // NB! Button names are 1 ... 18
    	for(int i=0; i<ElementTable.getGroups(); i++) {
    		for(int j=0; j<ElementTable.getPeriods(); j++) {
    			String buttonID = "btn" + (i+1) + "a" + (j+1);
    			int resID = getResources().getIdentifier(buttonID, "id", getPackageName());

    			if(resID != 0) {
	    			buttons[i][j] = ((Button) findViewById(resID));
	    			buttons[i][j].setOnClickListener(this);
    			}
    		}
    	}
	}
}