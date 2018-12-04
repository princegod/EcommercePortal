package com.microservice.eventmanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.microservice.eventmanagementapi.entites.Organizer;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer,Long> {

}
