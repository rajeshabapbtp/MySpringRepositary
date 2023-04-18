package com.rajeshlearnings.ms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rajeshlearnings.ms.entities.Vendor;


@Component
public class VendorService {
	HashMap<String,Vendor> vendors = new HashMap<String,Vendor>();
	@Autowired
	IVendorPersistance vendor;

//	@Autowired
//	Vendor vend1;
//	@Autowired
//	Vendor vend2;

	public void fillVendors() {
//		vendors.put("1", vend1);
//		vendors.put("2", vend2);
	}

	public List<Vendor> getAllVendors(){
//		fillVendors();
//		return vendors;
		// JPA fires SELECT all query
		return vendor.findAll();
	}

	public Optional<Vendor> getVendorByKey(String vendorId) {
//		fillVendors();
//		return (Vendor)vendors.get(vendorId);
		// SELECT SINGLE *
		return vendor.findById(vendorId);
	}

	public Vendor createVendor(Vendor vendorObject) {
//		fillVendors();
//		vendors.put("3", vendor);
//		return vendor;
		
		//Inserts data
		return vendor.save(vendorObject);
		
	}

	public Vendor updateVendor(Vendor vendorObject) {
//		fillVendors();
//		vendors.put("2", vendor);
//		return vendor;
		
		//Handle the UPDATE call
		Optional<Vendor> searchedRecord = vendor.findById(vendorObject.getCode());
		
		if(!searchedRecord.isPresent()) {
			return new Vendor();
		}
		return vendor.save(vendorObject);
	}

	public String deleteVendor(String vendorId) {
//		fillVendors();
//		vendors.remove(vendorId);
		
		vendor.deleteById(vendorId);
		return "Deleted successfully";
	}
	
	
	//Search on Company code
	public List<Vendor> searchByCompanyName(String companyName){
		return vendor.findByCompanyName(companyName);
	}
	
	//Search by First Name
	public List<Vendor> lookupByFirstName(String firstName){
		return vendor.lookupByFirstName(firstName);
	}
}
