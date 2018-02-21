package com.thinksys.demo.service;



public interface CountriesService {
	
	public String[] getCountries();
	public String[] getStates(String Country);
	public String[] getCities(String Country, String State);

}
