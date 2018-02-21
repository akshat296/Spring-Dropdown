package com.thinksys.demo.model;

public class Country {
	private int id;
	private String name;
	private String[] states;
	private String[] cities;
	
	public String[] getStates() {
		return states;
	}
	public void setStates(String[] states) {
		this.states = states;
	}
	public String[] getCities() {
		return cities;
	}
	public void setCities(String[] cities) {
		this.cities = cities;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
