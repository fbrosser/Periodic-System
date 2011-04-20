package com.brosser.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.brosser.R;
import com.brosser.model.Element;;

public class ElementView extends View {
    
    public ElementView(Context context, Element element) {
    	
    	super(context);
        setMinimumWidth(180);
        setMinimumHeight(200);
        setFocusable(true);
        
        String text = element.getInfoAsString();
        
        //((TextView)findViewById(R.id.info)).setText(text);
        ((TextView)findViewById(R.id.header)).setText(element.getName());
        
    }
}
