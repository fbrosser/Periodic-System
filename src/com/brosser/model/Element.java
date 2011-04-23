package com.brosser.model;

public class Element {
	
	public static enum stpState {UNDEFINED, GAS, LIQUID, SOLID, SYNTHETIC};
	
	private String name;
	private String symbol;
	private int number;
	private double mass;
	private double density;
	private double meltingPoint;
	private double boilingPoint;
	private String date;
	private stpState state;
	private int nProtons;
	private int nNeutrons;
	private String nElectrons;
	private int group;
	private int period;
	private String groupName;
	private String periodName;
	private boolean starred;
	private String wikiurl;
	private int nIsotopes;
	private int nRadIsotopes;
	private String radius;
	private String covRadius;
	private String category;
	private String electronAffinity;
	private String abundance;
	private double electroNegativity;
	private double nuclearCharge;
	private String thermalConductivity;
	private String ionizationEnergy;
	private String ionRadius;
	private String heatOfFormation;
	private String heatOfFusion;
	private String heatOfVaporization;
	private static String[] labels; 
	private static String[] unitLabels;
	private String[] info;
	
	public Element(String name, String symbol, int number, double mass,
			double density, double meltingPoint, double boilingPoint,
			stpState state, int nProtons, int nNeutrons, String nElectrons,
			int group, int period, String groupName, String periodName, 
			boolean starred, String wikiurl, String date, int nIsotopes, int nRadIsotopes,
			String radius, String covRadius, String category, String electronAffinity, String abundance,
			double electroNegativity, double nuclearCharge, String thermalConductivity,
			String ionizationEnergy, String ionRadius, String heatOfFormation, String heatOfFusion,
			String heatOfVaporization) {
		
		super();
		
		this.info = new String[50];
		
		this.name = name;
		this.symbol = symbol;
		this.number = number;
		this.mass = mass;
		this.density = density;

		this.radius = radius;
		this.nRadIsotopes = nRadIsotopes;
		this.nIsotopes = nIsotopes;
		this.period = period;
		this.groupName = groupName;
		this.periodName = periodName;
		this.starred = starred;
		this.wikiurl = wikiurl;
		this.date = date;
		this.nProtons = nProtons;
		this.nNeutrons = nNeutrons;
		this.nElectrons = nElectrons;
		this.group = group;
		this.state = state;
		this.boilingPoint = boilingPoint;
		this.meltingPoint = meltingPoint;
		this.covRadius = covRadius;
		this.electronAffinity = electronAffinity;
		this.electroNegativity = electroNegativity;
		this.nuclearCharge = nuclearCharge;
		this.thermalConductivity = thermalConductivity;
		this.abundance = abundance;
		this.ionizationEnergy = ionizationEnergy;
		this.category = category;
		this.heatOfFormation = heatOfFormation;
		this.ionRadius = ionRadius;
		this.heatOfVaporization = heatOfVaporization;
		this.heatOfFusion = heatOfFusion;
		
		info[0] = ""+name;
		info[1] = ""+symbol;
		info[2] = ""+number;
		info[3] = ""+mass;
		info[4] = ""+radius;
		info[5] = ""+category;
		info[6] = ""+density;
		info[7] = ""+meltingPoint;
		info[8] = ""+boilingPoint;
		info[9] = ""+stateToString(this.state);
		info[10] = ""+nProtons;
		info[11] = ""+nElectrons;
		info[12] = ""+group;
		info[13] = ""+period;
		info[14] = ""+date;
		info[15] = ""+abundance;
		info[16] = ""+covRadius;
		info[17] = ""+electronAffinity;
		info[18] = ""+electroNegativity;
		info[19] = ""+heatOfFormation;
		info[20] = ""+heatOfFusion;
		info[21] = ""+heatOfVaporization;
		info[22] = ""+ionRadius;
		info[23] = ""+ionizationEnergy;
		info[24] = ""+nIsotopes;
		info[25] = ""+nRadIsotopes;
		info[26] = ""+nuclearCharge;
		info[27] = ""+thermalConductivity;
		
		if(Element.labels == null) {
			Element.labels = new String[30];
			for(int i=0; i<30; i++) {
				labels[i] = "Parsing falure";
			}
		}
		if(Element.unitLabels == null) {
			Element.unitLabels = new String[30];
			for(int i=0; i<30; i++) {
				unitLabels[i] = "Parsing falure";
			}
		}
	}

	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}
	
	public int getIsotopes() {
		return nIsotopes;
	}
	
	public static void setLanguage(String[] languageSet) {
		Element.labels = languageSet;
	}
	
	public static void setUnits(String[] unitSet) {
		Element.unitLabels = unitSet;
	}
	
	public int getRadIsotopes() {
		return nRadIsotopes;
	}
	
	public int getNumber() {
		return number;
	}
	
	public double getMass() {
		return mass;
	}
	
	public String getThermalConductivity() {
		return this.thermalConductivity;
	}
	
	public String getHeatOfFormation() {
		return this.heatOfFormation;
	}
	
	public String getHeatOfFusion() {
		return this.heatOfFusion;
	}
	
	public String getHeatOfVaporization() {
		return this.heatOfVaporization;
	}
	
	public String getIonRadius() {
		return this.ionRadius;
	}
	
	public double getElectroNegativity() {
		return this.electroNegativity;
	}
	
	public String getIonizationEnergy() {
		return this.ionizationEnergy;
	}

	public String getElectronAffinity() {
		return this.electronAffinity;
	}
	
	public double getDensity() {
		return density;
	}

	public double getMeltingPoint() {
		return meltingPoint;
	}

	public double getBoilingPoint() {
		return boilingPoint;
	}

	public stpState getState() {
		return state;
	}

	public int getnProtons() {
		return nProtons;
	}

	public int getnNeutrons() {
		return nNeutrons;
	}

	public String getnElectrons() {
		return nElectrons;
	}

	public int getGroup() {
		return group;
	}

	public int getPeriod() {
		return period;
	}

	public String getGroupName() {
		return groupName;
	}
	
	public String getAbundance() {
		return this.abundance;
	}

	public String getPeriodName() {
		return periodName;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public double getNuclearCharge() {
		return this.nuclearCharge;
	}
	
	public String getRadius() {
		return radius;
	}
	
	public boolean isStarred() {
		return this.starred;
	}
	
	public void setStarred(boolean starred) {
		this.starred = starred;
	}
	
	public String getCovRadius() {
		return this.covRadius;
	}
	
	public String getWikiURL() {
		return wikiurl;
	}
	
	public static stpState parseState(String string) {
		if(string.toLowerCase().equals("gas")) {
			return stpState.GAS;
		}
		else if(string.toLowerCase().equals("liquid")) {
			return stpState.LIQUID;
		}
		else if(string.toLowerCase().equals("solid")) {
			return stpState.SOLID;
		}
		else if(string.toLowerCase().equals("synthetic")) {
			return stpState.SYNTHETIC;
		}
		else {
			return stpState.UNDEFINED;
		}
	}
	
	public static String stateToString(stpState state) {
		if(state == stpState.GAS) {
			return "Gas";
		}
		else if(state == stpState.LIQUID) {
			return "Liquid";
		}
		else if(state == stpState.SOLID) {
			return "Solid";
		}
		else if(state == stpState.SYNTHETIC) {
			return "Synthetic";
		}
		else {
			return "Undefined";
		}		
	}
	
	public String[] getInfoAsArray() {
		String[] infoArray = new String[100];
		for(int i=0; i<28; i++) {
			infoArray[(i*2)] = labels[i];
			if(!unitLabels[i].equals("") && ElementTable.getOption(0)) {
				infoArray[(i*2)] += " (" + unitLabels[i] + ")";
			}
			infoArray[(i*2)+1] = info[i];
		}
		return infoArray;
	}

	public String getInfoAsString() {
		String s = "";
		s += labels[0] + " " + unitLabels[0] + ": " + this.name + "\n";
		s += labels[1] + " " + unitLabels[1] + ": " + this.symbol + "\n";
		s += labels[2] + " " + unitLabels[2] + ": " + this.number + "\n";
		s += labels[3] + " " + unitLabels[3] + ": " + this.mass + "\n";
		s += labels[4] + " " + unitLabels[4] + ": " + this.radius + "\n";
		s += labels[5] + " " + unitLabels[5] + ": " + this.category + "\n";
		s += labels[6] + " " + unitLabels[6] + ": " + this.density + "\n";
		s += labels[7] + " " + unitLabels[7] + ": " + this.meltingPoint + "\n";
		s += labels[8] + " " + unitLabels[8] + ": " + this.boilingPoint + "\n";
		s += labels[9] + " " + unitLabels[9] + ": " + stateToString(this.state) + "\n";
		s += labels[10] + " " + unitLabels[10] + ": " + this.nProtons + "\n";
		s += labels[11] + " " + unitLabels[11] + ": " + this.nElectrons + "\n";
		s += labels[12] + " " + unitLabels[12] + ": " + this.group + "\n";
		s += labels[13] + " " + unitLabels[13] + ": " + this.period + "\n";
		s += labels[14] + " " + unitLabels[14] + ": " + this.date + "\n";
		s += labels[15] + " " + unitLabels[15] + ": " + this.abundance + "\n";
		s += labels[16] + " " + unitLabels[16] + ": " + this.covRadius + "\n";
		s += labels[17] + " " + unitLabels[17] + ": " + this.electronAffinity + "\n";
		s += labels[18] + " " + unitLabels[18] + ": " + this.electroNegativity + "\n";
		s += labels[19] + " " + unitLabels[19] + ": " + this.heatOfFormation + "\n";
		s += labels[20] + " " + unitLabels[20] + ": " + this.heatOfFusion + "\n";
		s += labels[21] + " " + unitLabels[21] + ": " + this.heatOfVaporization + "\n";
		s += labels[22] + " " + unitLabels[22] + ": " + this.ionRadius + "\n";
		s += labels[22] + " " + unitLabels[22] + ": " + this.ionizationEnergy + "\n";
		s += labels[23] + " " + unitLabels[23] + ": " + this.nIsotopes + "\n";
		s += labels[24] + " " + unitLabels[24] + ": " + this.nuclearCharge + "\n";
		s += labels[25] + " " + unitLabels[25] + ": " + this.nRadIsotopes + "\n";
		s += labels[26] + " " + unitLabels[26] + ": " + this.thermalConductivity + "\n";
		return s;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Element) {
			Element e = (Element) o;
			if(e.getName().equals(this.name) && e.getNumber() == this.number) {
				return true;
			}
		}
		return false;
	}
}
