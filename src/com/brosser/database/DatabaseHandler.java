package com.brosser.database;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.res.Resources;

import com.brosser.R;
import com.brosser.model.Element;
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
	    	 
	     }
	     
	     return byteArrayOutputStream.toString();
    }
    
	public static String[][] parseLanguages() {
		
		String[][] langSets = new String[10][30];
		int[] languageFileIDs = {R.raw.english, R.raw.german, R.raw.swedish, R.raw.norwegian};

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
			elementThreads[i] = new SingleElementThread(34 * i, text);
			elementThreads[i].start();
		}
		
		// Collect
		int collected = 0;
		int loopI = 0;
		while(collected < elementThreads.length) {
			if(elementThreads[loopI].isFinished()) {
				elements[loopI] = elementThreads[loopI].getElement();
				collected++;
			}
			loopI = (++loopI % elementThreads.length);
		}
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
