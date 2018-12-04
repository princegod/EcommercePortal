package com.microservice.eventmanagementapi.entites.projections;

import java.time.Instant;
import java.time.ZonedDateTime;

import org.springframework.data.rest.core.config.Projection;

import com.microservice.eventmanagementapi.entites.Event;


@Projection(name="partial",types= {Event.class})
public interface PartialEventProjections {//represent data acoording to your client need 
	//this is the URL for projection http://localhost:8080/eventmanagement-api/events?projection=partial
	
	String getName();
    ZonedDateTime getStartTime();
	ZonedDateTime getEndTime();
	Instant getCreated();//you can also exposed out hidden entity or jsonignore entity
	
}
	
