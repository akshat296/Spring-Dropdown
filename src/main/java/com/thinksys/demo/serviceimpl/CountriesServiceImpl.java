package com.thinksys.demo.serviceimpl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinksys.demo.dao.CountriesDao;
import com.thinksys.demo.service.CountriesService;


@Service
public class CountriesServiceImpl implements CountriesService{
	
	
	@Autowired
	CountriesDao countriesDao;
	
	@Override
	public String[] getCountries() {
		//System.out.println(countriesDao);
		String[] Countries = this.countriesDao.getCountries();
		return Countries;
	}
	@Override
	public String[] getStates(String Country) {
		String[] States = this.countriesDao.getStates(Country);
		//System.out.println(States);
		return States;
	}

	@Override
	public String[] getCities(String Country, String State) {
		String[] Cities = this.countriesDao.getCities(Country,State);
		return Cities;
	}


}
