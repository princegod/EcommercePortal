package com.microservice.eventmanagementapi.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.microservice.eventmanagementapi.entites.Participant;

public interface ParticipantRepository extends PagingAndSortingRepository<Participant,Long>{
	
	List<Participant> findByEmail(@Param("email") String email);

}
