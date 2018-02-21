package com.thinksys.demo.api;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.thinksys.demo.model.Country;

@Controller
public class ApiController {
	@CrossOrigin({"*"})
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody String getCountries() {
		Country country1 = new Country(); 
		String[] states1 = {"Uttar Pradesh"}; 
		String[] cities1 = {"Lucknow","Varanasi"}; 
		country1.setId(1);
		country1.setName("India");
		country1.setStates(states1);
		country1.setCities(cities1);
		Country country2 = new Country(); 
		String[] states2 = {"Tamil Nadu"}; 
		String[] cities2 = {"Chennai"}; 
		country2.setId(2);
		country2.setName("India");
		country2.setStates(states2);
		country2.setCities(cities2);
		ArrayList<Country> countries = new ArrayList<Country>();
		countries.add(country1);
		countries.add(country2);
		String json = new Gson().toJson(countries);
		return json;
	}
}
