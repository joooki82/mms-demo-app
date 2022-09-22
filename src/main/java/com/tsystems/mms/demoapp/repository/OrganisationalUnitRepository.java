package com.tsystems.mms.demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsystems.mms.demoapp.model.OrganisationalUnit;

@Repository
public interface OrganisationalUnitRepository extends JpaRepository<OrganisationalUnit, Long> {

	
	
}
