package com.brosser.database;

import com.brosser.model.Element;
import com.brosser.model.Element.stpState;

public class SingleElementThread extends Thread {
	
	private Element elem;
	private int Offset;
	private String[] Text;
	
	public SingleElementThread(int offset, String[] text) {
		this.Offset = offset;
		this.Text = text;
	}

	public void run() {
		parseSingleElement(Offset, Text);
	}
	
	public Element getElement() {
		return this.elem;
	}
	
	public void parseSingleElement(int offset, String[] text) {
		
		int next = offset;
		
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
				
		this.elem = element;
	}
}
