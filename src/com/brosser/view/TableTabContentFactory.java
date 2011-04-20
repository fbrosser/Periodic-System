package com.brosser.view;

import com.brosser.R;
import com.brosser.model.ElementTable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class TableTabContentFactory implements TabHost.TabContentFactory {
	
	private Context context;
	private TabHost tabHost;
	private ElementTable elementTable;
	
	public TableTabContentFactory(Context context, TabHost tabHost) {
		this.context = context;
		this.tabHost = tabHost;
		this.elementTable = ElementTable.getInstance(context.getResources());
	}
	
	@Override
	public View createTabContent(String tag) {
		if(tag.equals("table_view")) {
			View view = LayoutInflater.from(context).inflate(R.layout.table, 
					tabHost.getTabContentView(), true);
			return view;
		}
		else if(tag.equals("element_view")){
	        String text = ElementTable.getActiveElement().getInfoAsString(); 
			for(int i=0; i<50; i++) {
	        	text += "dummy row\n";
	        }
			View view = LayoutInflater.from(context).inflate(R.layout.element, 
					tabHost.getTabContentView(), true);	        
			
	        //((TextView)view.findViewById(R.id.info)).setText(text);
	        ((TextView)view.findViewById(R.id.header))
	        .setText(ElementTable.getActiveElement().getName());
	        
	        return view;
		}
		else {
			final TextView txt = new TextView(context);
			txt.setText("Settings");
			return txt;
		}
	}
}
