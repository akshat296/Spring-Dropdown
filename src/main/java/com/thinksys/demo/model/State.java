package com.thinksys.demo.model;

import java.util.ArrayList;

public class State {
	private int id;
	private String stateName;
	private ArrayList<City> cities;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateName() {
		return stateName;
	}
	public ArrayList<City> getCities() {
		return cities;
	}
	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}

}
