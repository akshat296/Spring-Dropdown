package com.thinksys.demo.web;



import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.thinksys.demo.service.CountriesService;





/**
 * Handles requests for the application home page.
 */
@Controller
public class CountriesController {

	@Autowired
	CountriesService countriesServiceImpl;
	

	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Locale locale, Model model,HttpServletRequest request) {
		if(request.getMethod().toString().equals("GET")) {	
			
			String[] Countries = this.countriesServiceImpl.getCountries();
			String[] States = this.countriesServiceImpl.getStates("Select");
			String[] Cities = this.countriesServiceImpl.getCities("Select","Select");
			
			model.addAttribute("countries", Countries );
			model.addAttribute("states", States);
			model.addAttribute("cities", Cities);
			
		} 
		else if(request.getMethod().equals("POST") ) {
			HttpSession session = request.getSession();
			
			try{
			String selectedcountry = request.getParameter("countries");
			String cn = (String) session.getAttribute("selectedCountry");
			String selectedstate = request.getParameter("states");
			
			String[] Countries = this.countriesServiceImpl.getCountries();
			String[] States = this.countriesServiceImpl.getStates(selectedcountry);
			
			model.addAttribute("countries", Countries );
			model.addAttribute("states", States);
			model.addAttribute("selectedCountries", selectedcountry);
			
			if(cn != null && cn.equals(selectedcountry)) {
				model.addAttribute("selectedStates", selectedstate);
			}
			else {
				model.addAttribute("selectedStates", "Select");
			}
			
			
			session.setAttribute("selectedCountry", selectedcountry);
			String[] Cities = this.countriesServiceImpl.getCities(selectedcountry,selectedstate);
			model.addAttribute("cities", Cities);
			
			}
			catch(Exception e) {
				System.out.println(e);
				}
			}
		return "home";
	}
}



