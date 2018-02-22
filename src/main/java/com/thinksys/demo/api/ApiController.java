package com.thinksys.demo.api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.thinksys.demo.model.City;
import com.thinksys.demo.model.Country;
import com.thinksys.demo.model.State;

@RestController
public class ApiController {
	@CrossOrigin({"*"})
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody String getCountries() {
		Country country1 = new Country(); 
		country1.setId(1);
		country1.setName("India");
		
		State state11 = new State();
		state11.setId(1);
		state11.setStateName("Uttar Pradesh");
		
		
		City city111 = new City();
		city111.setId(1);
		city111.setCityName("Lucknow");
		City city112 = new City();
		city112.setId(2);
		city112.setCityName("Ghaziabad");
		City city113 = new City();
		city113.setId(3);
		city113.setCityName("Noida");
		ArrayList<City> allcitiesforstate11 = new ArrayList<City>();
		
		allcitiesforstate11.add(city111);
		allcitiesforstate11.add(city112);
		allcitiesforstate11.add(city113);
		
		state11.setCities(allcitiesforstate11);
		State state12 = new State();
		state12.setId(1);
		state12.setStateName("Tamil Nadu");
		City city121 = new City();
		city121.setId(1);
		city121.setCityName("Chennai");
		City city122 = new City();
		city122.setId(2);
		city122.setCityName("Thirumayam");
		
		ArrayList<City> allcitiesforstate12 = new ArrayList<City>();
		allcitiesforstate12.add(city121);
		allcitiesforstate12.add(city122);
		
		state12.setCities(allcitiesforstate12);
		ArrayList<State> allstatesforcountry1 = new ArrayList<State>();
		allstatesforcountry1.add(state11);
		allstatesforcountry1.add(state12);
		
		country1.setStates(allstatesforcountry1);
		Country country2 = new Country(); 
		country2.setId(2);
		country2.setName("Ireland");
		
		State state21 = new State();
		state21.setId(1);
		state21.setStateName("Ulster");
		
		
		City city211 = new City();
		city211.setId(1);
		city211.setCityName("Belfast");
		City city212 = new City();
		city212.setId(2);
		city212.setCityName("Derry");
		City city213 = new City();
		city213.setId(3);
		city213.setCityName("Antrim");
		ArrayList<City> allcitiesforstate21 = new ArrayList<City>();
		
		allcitiesforstate21.add(city211);
		allcitiesforstate21.add(city212);
		allcitiesforstate21.add(city213);
		
		state21.setCities(allcitiesforstate21);
		State state22 = new State();
		state22.setId(1);
		state22.setStateName("Munster");
		City city221 = new City();
		city221.setId(1);
		city221.setCityName("County Kerry");
		City city222 = new City();
		city222.setId(2);
		city222.setCityName("Limerick");
		
		ArrayList<City> allcitiesforstate22 = new ArrayList<City>();
		allcitiesforstate22.add(city221);
		allcitiesforstate22.add(city222);
		
		state22.setCities(allcitiesforstate22);
		ArrayList<State> allstatesforcountry2 = new ArrayList<State>();
		allstatesforcountry2.add(state21);
		allstatesforcountry2.add(state22);
		
		country2.setStates(allstatesforcountry2);
		ArrayList<Country> countries = new ArrayList<Country>();
		countries.add(country1);
		countries.add(country2);
		String json = new Gson().toJson(countries);
		return json;
	}
}
