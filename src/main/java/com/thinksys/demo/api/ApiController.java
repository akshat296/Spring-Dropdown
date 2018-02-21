package com.thinksys.demo.api;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.thinksys.demo.model.City;
import com.thinksys.demo.model.Country;
import com.thinksys.demo.model.State;

@Controller
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
		State state21 = new State();
		state21.setId(1);
		state21.setStateName("Tamil Nadu");
		City city221 = new City();
		city221.setId(1);
		city221.setCityName("Chennai");
		City city222 = new City();
		city222.setId(2);
		city222.setCityName("Thirumayam");
		
		ArrayList<City> allcitiesforstate12 = new ArrayList<City>();
		allcitiesforstate12.add(city221);
		allcitiesforstate12.add(city222);
		
		state21.setCities(allcitiesforstate11);
		ArrayList<State> allstatesforcountry1 = new ArrayList<State>();
		allstatesforcountry1.add(state11);
		allstatesforcountry1.add(state21);
		
		country1.setStates(allstatesforcountry1);
		String json = new Gson().toJson(country1);
		return json;
	}
}
