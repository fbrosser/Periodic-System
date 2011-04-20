package com.brosser;

import com.brosser.database.DatabaseHandler;
import com.brosser.model.Element;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.TextView;

public class SplashActivity extends Activity {
	
    protected boolean _active = true;
    protected int _splashTime = 2000;
    protected Context packageContext;
    //private static TextView displayNumber;
    
    /*
    private final Runnable mUpdateUITimerTask = new Runnable() {
        public void run() {
            displayNumber.setText("Done!");
        }
    };
    private final Handler mHandler = new Handler();
    */
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        this.packageContext = this;
        //displayNumber = ((TextView)findViewById(R.id.splashNumber));
        
        // Thread for displaying the splash screen
        Thread splashTread = new Thread() {
            
        	@Override
            public void run() {
        		
        		// Start database handler
        		DatabaseHandler databaseHandler = new DatabaseHandler(getResources());
        		databaseHandler.start();
        		
        		/*
        		try {
        			int waited = 0;
                    while(_active && (waited < _splashTime)) {
                        sleep(100);
                        if(_active) {
                            waited += 100;
                           databaseHandler.join();
                            mHandler.postDelayed(mUpdateUITimerTask, 10);
                            Element.setLanguage(DatabaseHandler.getLanguage(0));
                        }
                    }
                } catch(InterruptedException e) {    
                	// Do nothing
                	} finally {
                		// Languages
                		finish();
                		// Start the real application
                		startActivity(new Intent(packageContext, TabHostActivity.class));
                		stop();
                }
                	*/
        		
                try {
					databaseHandler.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				}
				
                Element.setLanguage(DatabaseHandler.getLanguage(0));
        		// Languages
        		finish();
        		// Start the real application
        		startActivity(new Intent(packageContext, TabHostActivity.class));
        		stop();
            }
        };
        splashTread.start();
      
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            _active = false;
        }
        return true;
    }
}