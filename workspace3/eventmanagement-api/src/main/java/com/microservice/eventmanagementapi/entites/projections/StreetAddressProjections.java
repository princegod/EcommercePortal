package com.microservice.eventmanagementapi.entites.projections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.microservice.eventmanagementapi.entites.Venue;

@Projection(name="virtual",types= {Venue.class})
public interface StreetAddressProjections {//this projection is used to combine two or more and represent for a client.

	@Value("#{target.streetAddress} #{target.streetAddress2}")
	String getCompleteStreetAddress();

}
