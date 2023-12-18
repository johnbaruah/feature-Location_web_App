package com.psa.location_web_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.psa.location_web_app.entitites.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}






