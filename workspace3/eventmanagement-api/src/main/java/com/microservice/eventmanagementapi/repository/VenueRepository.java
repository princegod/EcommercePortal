package com.microservice.eventmanagementapi.repository;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.microservice.eventmanagementapi.entites.Venue;

public interface VenueRepository extends PagingAndSortingRepository<Venue,Long> {
	
List<Venue> findByPostalCode(@Param("postalcode") String postalcode);

}
