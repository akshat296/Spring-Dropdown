package com.thinksys.demo.daoimpl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.thinksys.demo.dao.CountriesDao;

@Repository
public class CountriesDaoImpl implements CountriesDao{
	
	
	@Override
	public String[] getCountries()
	{
		ArrayList<String> Countries = new ArrayList<String>();
		Countries.add("Select");
		Countries.add("India");
		Countries.add("Canada");
		
		String[] jsonCountries = Countries.toArray(new String[Countries.size()]);
		return jsonCountries;
		
	}
	@Override
	public String[] getStates(String Country)
	{
		
		ArrayList<String> States = new ArrayList<String>();
		if(Country.equals("India")) {
			States.add("Uttar Pradesh");
			States.add("Tamil Nadu");
			States.add("Jammu & kashmir");
		}
		else if(Country.equals("Canada")) {
			States.add("Ontario");
			States.add("Quebec");
			States.add("Nova Scotia");
		}
		else {
			States.add("Select");
		}
		
		String[] jsonStates = States.toArray(new String[States.size()]);
		return jsonStates;
		
	}
	@Override
	public String[] getCities(String Country,String State)
	{
		
		ArrayList<String> Cities = new ArrayList<String>();
		
		if(Country.equals("India")) {
			if(State.equals("Uttar Pradesh")) {
				Cities.add("Lucknow");
				Cities.add("Shajhapur");
				Cities.add("Hapur");
				Cities.add("Ghaziabad");
			}
			
			else if(State.equals("Tamil Nadu")) {
				Cities.add("Tiruchirappalli");
				Cities.add("Chennai");
				Cities.add("Coimbatore");
				Cities.add("Thanjavur");
				Cities.add("Salem");
			}
			else if(State.equals("Jammu & kashmir")) {
				Cities.add("Jammu");
				Cities.add("Srinagar");
				Cities.add("Gulmarg");
				Cities.add("Sonamarg");
				
				}
			else {
				Cities.add("Select");
			}
			
			
		}
		else if(Country.equals("Canada")) {
			if(State.equals("Ontario")) {
				Cities.add("Toronto");
				Cities.add("Ottawa");
				Cities.add("Hamilton");
				
			}
			
			else if(State.equals("Quebec")) {
				Cities.add("Quebec City");
				Cities.add("Montreal");
				Cities.add("Sherbrooke");
				Cities.add("Gatineau");
			}
			else if(State.equals("Nova Scotia")) {
				Cities.add("Truro");
				Cities.add("Yarmouth");
				Cities.add("Wolfville");
				
				
				}
			else {
			    Cities.add("Select");
			}
			
		}
		else {
			Cities.add("Select");
		}
		
		String[] jsonCities = Cities.toArray(new String[Cities.size()]);
		return jsonCities;
		
	}

}
