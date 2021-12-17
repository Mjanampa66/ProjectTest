package com.FleetSpringBoot.parameters.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FleetSpringBoot.parameters.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {

}
