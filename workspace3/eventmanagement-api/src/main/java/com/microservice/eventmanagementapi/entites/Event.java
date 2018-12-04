package com.microservice.eventmanagementapi.entites;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@JsonPropertyOrder({"resourceId"})//it will show you top of the list
public class Event extends AbstractEntity {

	
	private String name;
	private String description;
	private ZonedDateTime startTime;//we use JackSon jsr310 to handle andso that java object converted into jason and viseversa.
	private ZonedDateTime endTime;
	private ZoneId zoneid;
	private Boolean started;
	
	@OneToMany(mappedBy="event",cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	private Set<Participant> participants;
//	removed
//
//	So this orphan removal tells that if the participants are not associated with an event delete them.
//
//	That's what this orphanremoval is
//
//	saying the cascade on the other hand if a delete happens on an event we are telling that all the participants
//
//	should also be deleted.


	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(nullable=false)
	private Organizer organizer;
	
    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @RestResource(exported=false)
    private Venue venue;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ZonedDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}

	public ZonedDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(ZonedDateTime endTime) {
		this.endTime = endTime;
	}

	
	public Boolean getStarted() {
		return started;
	}

	public void setStarted(Boolean started) {
		this.started = started;
	}

	public ZoneId getZoneid() {
		return zoneid;
	}

	public void setZoneid(ZoneId zoneid) {
		this.zoneid = zoneid;
	}
	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}
	
	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public long getResourceId() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return Objects.equals(id,((Event)obj).id);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hashCode(id);
	}
	
		
}
