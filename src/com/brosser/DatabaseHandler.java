package com.brosser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.res.Resources;

import com.brosser.model.Element;
import com.brosser.model.Element.stpState;

public class DatabaseHandler extends Thread {
	
	private static final int groups = 18;
	private static final int periods = 7;
	private static Element[] elementList;
	private static Resources resources;
	private static int elementsParsed = 0;
	
	public DatabaseHandler(Resources Resources) {
		resources = Resources;
	}
	
	public void run() {
		elementList = parseElements();
	}
	
	public static Element[] getElementList() {
		return elementList;
	}
	
	public static Element[] parseElements() {
		
		Element[] elements = new Element[groups*periods];
		String rawText = readRawText();
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
				//int nNeutrons = Integer.parseInt(text[next++]);
				next++;
				String nElectrons = (text[next++]);
				int group = Integer.parseInt(text[next++]);
				int period = Integer.parseInt(text[next++]);
				//String groupName = text[next++];
				//String periodName = text[next++];
				next++;
				next++;
				String date = text[next++];
				String wikiurl = "http://en.wikipedia.org/wiki/" + name;
				next++;
				//next++;
				//int nIsotopes = 0;
				int nIsotopes = Integer.parseInt(text[next++]);
				int nRadIsotopes = Integer.parseInt(text[next++]);
				String radius = text[next++];
				String covRadius = text[next++];
				
				String category = "";
				for (int k = 0; k < 3; k++) {
					String str = text[next++];
					if(!str.equals("X")) {
						category += str + " ";
					}
				}
				
				String electronAffinity = text[next++];
				String abundance = text[next++];
				double electroNegativity = Double.parseDouble(text[next++]);
				double nuclearCharge = Double.parseDouble(text[next++]);
				String thermalConductivity = text[next++];
				String ionizationEnergy = text[next++];
				String ionradius = text[next++];
				String heatOfFormation = text[next++];
				String heatOfFusion = text[next++];
				String heatOfVaporization = text[next++];
				
				Element element = new Element(name, symbol, number, 
						mass, density, meltingPoint, boilingPoint, state, 
						nProtons, 0, nElectrons, group, period, 
						"", "", false, 
						wikiurl, date, nIsotopes, nRadIsotopes, radius, covRadius, category,
						electronAffinity, abundance, electroNegativity, nuclearCharge,
						thermalConductivity, ionizationEnergy, ionradius, heatOfFormation,
						heatOfFusion, heatOfVaporization);
				
				elements[nextElement++] = element;
				elementsParsed++;
			}
		}
		
		return elements;
	}
	

    private static String readRawText(){

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
