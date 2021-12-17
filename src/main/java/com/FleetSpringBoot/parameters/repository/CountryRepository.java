package com.FleetSpringBoot.parameters.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FleetSpringBoot.parameters.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {

	
}
