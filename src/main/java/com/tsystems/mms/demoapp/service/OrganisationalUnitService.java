package com.tsystems.mms.demoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsystems.mms.demoapp.common.exception.ResourceNotFoundException;
import com.tsystems.mms.demoapp.model.OrganisationalUnit;
import com.tsystems.mms.demoapp.repository.OrganisationalUnitRepository;


@Service
@Transactional
public class OrganisationalUnitService {

	private final OrganisationalUnitRepository organisationalUnitRepository;

	@Autowired
	public OrganisationalUnitService(OrganisationalUnitRepository organisationalUnitRepository) {
		this.organisationalUnitRepository = organisationalUnitRepository;
	}
	
	public OrganisationalUnit getOrganisationalUnitById(Long id) {

		return organisationalUnitRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Organisational Unit not found with id: " + id));

	}
	
	
	
}
