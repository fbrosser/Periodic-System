package com.brosser.model;

public class Element {
	
	public static enum stpState {UNDEFINED, GAS, LIQUID, SOLID};
	
	private String name;
	private String symbol;
	private int number;
	private double mass;
	private double density;
	private double meltingPoint;
	private double boilingPoint;
	private stpState state;
	private int nProtons;
	private int nNeutrons;
	private int nElectrons;
	private int group;
	private int period;
	private String groupName;
	private String periodName;
	
	public Element(String name, String symbol, int number, double mass,
			double density, double meltingPoint, double boilingPoint,
			stpState state, int nProtons, int nNeutrons, int nElectrons,
			int group, int period, String groupName, String periodName) {
		
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
	}

	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getNumber() {
		return number;
	}

	public double getMass() {
		return mass;
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

	public int getnElectrons() {
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

	public String getPeriodName() {
		return periodName;
	}
	
	public String getWikiURL() {
		return "http://en.wikipedia.org/wiki/Hydrogen";
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
		s += "Density (g/cm^3): " + this.density + "\n";
		s += "Meling point (K): " + this.meltingPoint + "\n";
		s += "Boiling point (K): " + this.boilingPoint + "\n";
		s += "State (at 293°K/20°C): " + stateToString(this.state) + "\n";
		s += "#Protons: " + this.nProtons + "\n";
		s += "#Neutrons (most common isotope): " + this.nNeutrons + "\n";
		s += "#Electrons: " + this.nElectrons + "\n";
		s += "Group: " + this.group + "\n";
		s += "Period: " + this.period + "\n";
		s += "Group name: " + this.groupName + "\n";
		s += "Period name: " + this.periodName + "\n";
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
