package com.brosser.model; 

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.res.Resources;

import com.brosser.R;
import com.brosser.model.Element.stpState;
import com.brosser.model.Element;

public class ElementTable {

	private static ElementTable INSTANCE = null;
	
	private static int periods;
	private static int groups;
	
	private static Element[] table;
	private static Element activeElement;
	
	/**
	 * Load elements
	 */
	private ElementTable(Resources resources) {
		periods = 7;
		groups = 18;
		table = parseElements(resources);
		activeElement = table[0];
	}	
	
	public static ElementTable getInstance(Resources resources) { 
		if(INSTANCE != null) {
			return INSTANCE;
		}
		else {
			INSTANCE = new ElementTable(resources);
			return INSTANCE;
		}
	}
	
	public static int selectedNumber(Element activeElement) {
		int i = 0;
		int elementPosition = -1;
		for(Element e : table) {
			if(e.equals(activeElement)) {
				elementPosition = i;
			}
			i++;
		}
		if(elementPosition == -1) {
			return 2;
		}
		return elementPosition;
	}
	
	public static Element getElement(int number) {
		return table[number];
	}
	
	public static Element getElement(int group, int period) {
		if(group > 17 || group < 0 || period > 6 || period < 0) {
			return null;
		}
		else {
			if(period == 0) {
				return (group == 0 ? table[0] : table[1]);
			}
			else if(period == 1) {
				return (group < 2 ? table[group+2] : table[group-8]);
			}
			else if(period == 2) {
				return (group < 2 ? table[group+2+8] : table[group]);
			}
			else {
				return table[group + (period*18) - 36];
			}
		}
	}
	
	public static int getPeriods() {
		return periods;
	}
	
	public static int getGroups() {
		return groups;
	}
	
	public void setStarred(int group, int period, boolean starred) {
		getElement(group, period).setStarred(starred);
	}
	
	public static Element getActiveElement() {
		return activeElement;
	}
	
	public static void setActiveElement(Element element) {
		activeElement = element;
	}
	
	public static Element[] parseElements(Resources resources) {
		
		Element[] elements = new Element[groups*periods];
		String rawText = readRawText(resources);
		String[] lines = rawText.split("\n");
		String line = "";
		for(int i=0; i<lines.length; i++) {
			line += lines[i] + " ";
		}
		String[] text = line.split(" ");
		int next = 0;
		int nextElement = 0;
		
		for(int i=0; i<groups; i++) {
			for(int j=0; j<periods; j++) {
				String name = text[next++];
				String symbol = text[next++];
				int number = Integer.parseInt(text[next++]);
				double mass = Double.parseDouble(text[next++]);
				double density = Double.parseDouble(text[next++]);
				double meltingPoint = Double.parseDouble(text[next++]);
				double boilingPoint = Double.parseDouble(text[next++]);
				stpState state = Element.parseState(text[next++]);
				int nProtons = Integer.parseInt(text[next++]);
				int nNeutrons = Integer.parseInt(text[next++]);
				int nElectrons = Integer.parseInt(text[next++]);
				int group = Integer.parseInt(text[next++]);
				int period = Integer.parseInt(text[next++]);
				String groupName = text[next++];
				String periodName = text[next++];
				String wikiurl = text[next++];
				Element element = new Element(name, symbol, number, 
						mass, density, meltingPoint, boilingPoint, state, 
						nProtons, nNeutrons, nElectrons, group, period, 
						groupName, periodName, false, 
						wikiurl);
				elements[nextElement++] = element;
			}
		}
		
		return elements;
	}
	
    private static String readRawText(Resources resources){

        InputStream inputStream = resources.openRawResource(R.raw.element_data);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i;
	    try {
	    	i = inputStream.read();
	    	
	    	while (i != -1) {
	          byteArrayOutputStream.write(i);
	          i = inputStream.read();
	        }
	    	
	        inputStream.close();
	        
	     } catch (IOException e) {
	    	 // TODO Auto-generated catch block
	     }
	     
	     return byteArrayOutputStream.toString();
    }	
}
