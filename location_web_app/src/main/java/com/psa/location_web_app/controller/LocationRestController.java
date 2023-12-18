package com.psa.location_web_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psa.location_web_app.repositories.LocationRepository;


import com.psa.location_web_app.entitites.Location;

@RequestMapping("/locationsRest") //first put this class level url then below method level to access a method
@RestController
public class LocationRestController {

		@Autowired
		private LocationRepository locationRepo;
		@RequestMapping("/locationss")
		@GetMapping
		public Location getOneLocations(){ // return particular one object location based on id
			Optional<Location> location = locationRepo.findById(121L);
			return location.get();
		}
		@RequestMapping("/locations")
		@GetMapping
		public List<Location> getAllLocations(){ // return all location objects
			List<Location> findAll = locationRepo.findAll();
			return findAll;
		}
		
		@RequestMapping("/locationsById/{id}")
		@GetMapping("/{id}")
		public Location getOneLocationsById(@PathVariable("id") Long id){ // return particular one object location based on id
			Optional<Location> location = locationRepo.findById(id);
			Location location2 = location.get();
			return location2;
		}
		
		@RequestMapping("/poMapSa")
		@PostMapping
		public Location saveLocation(@RequestBody Location location) {
			return locationRepo.save(location);
		}
		
		@RequestMapping("/DelMapLoc/{id}")
		@DeleteMapping("/{id}")
		public void deleteLocation(@PathVariable("id") Long id) {
			locationRepo.deleteById(id);
		}
		
		@RequestMapping("/updateLoc")
		@PutMapping
		public Location updateLocation(@RequestBody Location location) {
			return locationRepo.save(location);
		}
}
