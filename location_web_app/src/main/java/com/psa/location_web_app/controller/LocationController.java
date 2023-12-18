package com.psa.location_web_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psa.location_web_app.entitites.Location;
import com.psa.location_web_app.repositories.LocationRepository;
import com.psa.location_web_app.util.EmailUtil;

@Controller
public class LocationController {
	
	@Autowired
	private LocationRepository locationRepo;
	
//	@Autowired
//	private Location location;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@RequestMapping("/showLocation")
	public String showLocation() {
		return "showLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLoc(@ModelAttribute("loc") Location location, ModelMap modelMap) {
//		System.out.println(location.getId());
//		System.out.println(location.getCode());
//		System.out.println(location.getName());
//		System.out.println(location.getType());
		
//		EmailUtil emailUtil = new EmailUtil();
		
		locationRepo.save(location);
		emailUtil.sendEmail("johnbaruah8@gmail.com", "Hello John", "I am from java Body");
		
		modelMap.addAttribute("msg","Location Saved !!");
		return "showLocation";
	}
//	@RequestMapping("/saveLoc")
//	public String saveLoc(@RequestParam("id") Long id, @RequestParam("code") String code, @RequestParam("name") String name, @RequestParam("type") String type, ModelMap modelMap) {
//		System.out.println(id);
//		System.out.println(code);
//		System.out.println(name);
//		System.out.println(type);
//		
//		Location location = new Location();
//		
//		location.setId(id);
//		location.setCode(code);
//		location.setName(name);
//		location.setType(type);
//		locationRepo.save(location);
//		
//		modelMap.addAttribute("msg","Location Saved Successfully");
//		
//		
//		return "showLocation";
//	}
	
	@RequestMapping("/getLocations")
	public String getLocations(ModelMap modelMap) {
//		Iterable<Location> findAll = locationRepo.findAll();
		List<Location> locations = locationRepo.findAll();
		modelMap.addAttribute("locations", locations);
		return "getLocations";
	}
	
//	@RequestMapping("/displayLocations") we have to give the above method two lines two work either we not get the objects
//	public String displayLocations() {
//		return "getLocations";
//	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") Long id, ModelMap modelMap) {
//		System.out.println(id);
		locationRepo.deleteById(id);
		
		List<Location> locations = locationRepo.findAll();
		modelMap.addAttribute("locations", locations);
		return "getLocations";
	}
	
	@RequestMapping("/updateLocation")
	public String updateLocation(@RequestParam("id") Long id, ModelMap modelMap) {
		Optional<Location> findById = locationRepo.findById(id);
		Location location = findById.get();//give us an object
//		System.out.println(location.getId());//from object getting the data
//		System.out.println(location.getName());
//		System.out.println(location.getCode());
//		System.out.println(location.getType());
//		modelMap.addAttribute("locations", location); in single line sending data
		modelMap.addAttribute("id", location.getId());
		modelMap.addAttribute("name", location.getName());
		modelMap.addAttribute("code", location.getCode());
		modelMap.addAttribute("type", location.getType());
		return "updateTheLocation";
	}
	
	@RequestMapping("/updateLocationData")
	public String updateLocationData(@ModelAttribute("location") Location location, ModelMap modelMap) {
//		System.out.println(location.getId());
//		System.out.println(location.getName());
//		location.setCode(location.getCode());
//		location.setName(location.getName());
//		location.setType(location.getType());
		locationRepo.save(location);
		
		modelMap.addAttribute("updateMsg","New Location Updated !!");
		return "updateTheLocation";
	}
}

