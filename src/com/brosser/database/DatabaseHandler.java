package com.brosser.database;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.res.Resources;

import com.brosser.R;
import com.brosser.R.raw;
import com.brosser.model.Element;
import com.brosser.model.Element.stpState;
import com.brosser.database.SingleElementThread;

public class DatabaseHandler extends Thread {
	
	private static final int groups = 18;
	private static final int periods = 7;
	private static Element[] elementList;
	private static Resources resources;
	private static int elementsParsed = 0;
	private static String[][] languageSets;
	
	public DatabaseHandler(Resources Resources) {
		resources = Resources;
	}
	
    private synchronized static String readRawText(int id) {

        InputStream inputStream = resources.openRawResource(id);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    try {
	    	int i = inputStream.read();
	    	
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
    
	public static String[][] parseLanguages() {
		
		String[][] langSets = new String[10][30];
		int[] languageFileIDs = {	R.raw.english, R.raw.german, R.raw.swedish, R.raw.norwegian};

		for(int i=0; i<languageFileIDs.length; i++) {
			String rawText = readRawText(languageFileIDs[i]);
			langSets[i] = singleLanguage(rawText);
		}
		
		return langSets;
	}
	
	public static String[] singleLanguage(String raw) {
		String[] lines = raw.split("\n");
		String lang[] = new String[40];

		int next = 0;
		
		for(int i=0; i<lines.length; i++) {
			lang[i] = lines[next++];
		}
		
		return lang;
	}
	
	public static Element[] parseElements() {
		
		int N = groups * periods;
		Element[] elements = new Element[N];
		String rawText = readRawText(R.raw.element_data);
		String[] lines = rawText.split("\n");
		String line = "";
		for(int i=0; i<lines.length; i++) {
			line += lines[i] + " ";
		}
		String[] text = line.split(" ");
		
		// Throw
		SingleElementThread[] elementThreads = new SingleElementThread[N];
		for(int i=0; i<elementThreads.length; i++) {
			elementThreads[i] = new SingleElementThread(35*i, text);
			elementThreads[i].start();
		}
		// Collect
		for (int i = 0; i < elementThreads.length; i++) {
			try {
				elementThreads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
			elements[i] = elementThreads[i].getElement();
		}
		
		/*
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
				next++;
				String nElectrons = (text[next++]);
				int group = Integer.parseInt(text[next++]);
				int period = Integer.parseInt(text[next++]);
				next++;
				next++;
				String date = text[next++];
				String wikiurl = "http://en.wikipedia.org/wiki/" + name;
				next++;
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
		*/
		
		return elements;
	}
	
	public void run() {
		languageSets = parseLanguages();
		elementList = parseElements();
	}
	
	public static Element[] getElementList() {
		return elementList;
	}
	
	public static int getElementsParsed() {
		return elementsParsed;
	}
	
	public static String[] getLanguage(int i) {
		return languageSets[i];
	}	
}
