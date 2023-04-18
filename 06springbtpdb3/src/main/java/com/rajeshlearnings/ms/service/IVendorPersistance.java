package com.rajeshlearnings.ms.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rajeshlearnings.ms.entities.Vendor;

public interface IVendorPersistance extends JpaRepository<Vendor, String> {

	// Search option on Company Name
	List <Vendor> findByCompanyName(String companyName);
	
	// Search by First Name with custom query
	@Query(nativeQuery=true, value="SELECT * FROM public.vendor2 WHERE lower(first_name) like %?1%")
	List<Vendor> lookupByFirstName(String firstName);
	
}
