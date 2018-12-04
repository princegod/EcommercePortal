package com.microservice.eventmanagementapi.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.microservice.eventmanagementapi.entites.Event;
import com.microservice.eventmanagementapi.entites.projections.PartialEventProjections;
//Excerpts are projections that should be applied by default to a resource collection.
//you can define your projection here for by default working
@RepositoryRestResource(excerptProjection=PartialEventProjections.class)//to use excerpts mark repository by this annotation
public interface EventRepository extends PagingAndSortingRepository<Event,Long>{//to enable paging and sorting Simply extends PagingAndSortingRepository 

	List<Event> findByName(@Param("name") String name);//custom findby it gives Multiple dublicates
   
	//public Page<Event> findByName(@Param("name") String name,Pageable pageable); Not working
	
	List<Event> findByNameAndDescription(@Param("name") String name, @Param("description") String description);
	//url //http://localhost:8080/eventmanagement-api/events/search/findByNameAndDescription?name=Spring Data Rest Training 7&description=The Worse Course Ever
	//Page<Event> findByNameAndDescription(@Param("name") String name, @Param("description") String description,Pageable pageable);
		}
