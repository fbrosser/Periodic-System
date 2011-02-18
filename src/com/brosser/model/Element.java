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
		this.name = name;
		this.symbol = symbol;
		this.number = number;
		this.mass = mass;
		this.density = density;
		this.meltingPoint = meltingPoint;
		this.boilingPoint = boilingPoint;
		this.state = state;
		this.nProtons = nProtons;
		this.nNeutrons = nNeutrons;
		this.nElectrons = nElectrons;
		this.group = group;
		this.period = period;
		this.groupName = groupName;
		this.periodName = periodName;
		this.starred = starred;
		this.wikiurl = wikiurl;
		this.date = date;
		this.nIsotopes = nIsotopes;
		this.nRadIsotopes = nRadIsotopes;
		this.radius = radius;
		this.covRadius = covRadius;
		this.category = category;
		this.electronAffinity = electronAffinity;
		this.abundance = abundance;
		this.electroNegativity = electroNegativity;
		this.nuclearCharge = nuclearCharge;
		this.thermalConductivity = thermalConductivity;
		this.ionizationEnergy = ionizationEnergy;
		this.ionRadius = ionRadius;
		this.heatOfFormation = heatOfFormation;
		this.heatOfFusion = heatOfFusion;
		this.heatOfVaporization = heatOfVaporization;
		
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

	public String getInfoAsString() {
		String s = "";
		s += "Name: " + this.name + "\n";
		s += "Chemical symbol: " + this.symbol + "\n";
		s += "Atomic number: " + this.number + "\n";
		s += "Atomic mass (u): " + this.mass + "\n";
		s += "Atomic radius (pm): " + this.radius + "\n";
		s += "Element Category: " + this.category + "\n";
		s += "Density (g/cm^3 at 293°K): " + this.density + "\n";
		s += "Meling point (°K): " + this.meltingPoint + "\n";
		s += "Boiling point (°K): " + this.boilingPoint + "\n";
		s += "State (at 293°K): " + stateToString(this.state) + "\n";
		s += "Protons: " + this.nProtons + "\n";
		//s += "#Neutrons (most common isotope): " + this.nNeutrons + "\n";
		s += "Electrons per shell: " + this.nElectrons + "\n";
		s += "Group: " + this.group + "\n";
		s += "Period: " + this.period + "\n";
		//s += "Group name: " + this.groupName + "\n";
		//s += "Period name: " + this.periodName + "\n";
		s += "Discovered (observed or predicted): " + this.date + "\n";
		s += "Abundance (% (mass), Lithosphere): " + this.abundance + "\n";
		s += "Covalent radius (pm): " + this.covRadius + "\n";
		s += "Electron Affinity: " + this.electronAffinity + "\n";
		s += "Electronegativity (Pauling): " + this.electroNegativity + "\n";
		s += "Heat of Formation (kJ/mol): " + this.heatOfFormation + "\n";
		s += "Heat of Fusion (kJ/mol): " + this.heatOfFusion + "\n";
		s += "Heat of Vaporization (kJ/mol): " + this.heatOfVaporization + "\n";
		s += "Ionic Radius (pm): " + this.ionRadius + "\n";
		s += "Ionization Energy (eV): " + this.ionizationEnergy + "\n";
		s += "Number of Isotopes: " + this.nIsotopes + "\n";
		s += "Nuclear Charge (Slater): " +  this.nuclearCharge + "\n";
		s += "Number of known radioactive isotopes: " + this.nRadIsotopes + "\n";
		s += "Thermal Conductivity (W/mK at 293°K): " + this.thermalConductivity + "\n";
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
