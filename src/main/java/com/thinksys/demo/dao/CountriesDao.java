package com.thinksys.demo.dao;



public interface CountriesDao {
	
	public String[] getCountries();
	public String[] getStates(String Country);
	public String[] getCities(String Country, String State);
}
