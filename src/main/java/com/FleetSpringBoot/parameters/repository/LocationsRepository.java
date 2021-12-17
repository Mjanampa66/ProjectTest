package com.FleetSpringBoot.parameters.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FleetSpringBoot.parameters.models.Location;

@Repository
public interface LocationsRepository  extends JpaRepository<Location,Integer>{

}
