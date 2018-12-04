package com.microservice.eventmanagementapi.entites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microservice.eventmanagementapi.exception.NotCheckedInException;
import com.microservice.eventmanagementapi.repository.ParticipantRepository;

@RepositoryRestController
@RequestMapping("/participants")
public class CheckInController {
	@Autowired
	ParticipantRepository participantRepository;
	
	@PostMapping("/checkin/{id}")
	public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable("id") Long id,PersistentEntityResourceAssembler assembler) {
		
		Participant participant=participantRepository.findById(id).get();
		
		if(participant==null) {
			throw  new ResourceNotFoundException();
		}
		
		participant.setCheckedIn(true);
		participantRepository.save(participant);
		return ResponseEntity.ok(assembler.toResource(participant));
	}
	@PostMapping("checkout/{id}")
	public ResponseEntity<PersistentEntityResource> checkOut(@PathVariable("id") Long id,PersistentEntityResourceAssembler assembler){
		
		Participant participant=participantRepository.findById(id).get();
		
		if(!participant.isCheckedIn()) {
			throw new NotCheckedInException("user not checked in");
		}
		participant.setCheckedIn(false);
		participantRepository.save(participant);
		
		return ResponseEntity.ok(assembler.toResource(participant));//for halbrowserResponse
	}
	

}
