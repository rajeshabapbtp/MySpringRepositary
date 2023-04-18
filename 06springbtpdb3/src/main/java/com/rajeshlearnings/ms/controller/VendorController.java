package com.rajeshlearnings.ms.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rajeshlearnings.ms.entities.Vendor;
import com.rajeshlearnings.ms.service.VendorService;


@Component
@RestController
public class VendorController {

	@Autowired
	VendorService vendorService;
	
	@GetMapping("/vendors")
	public List<Vendor> getVendors(){
		return vendorService.getAllVendors();
	}
	
	@GetMapping("/vendors/{vendorId}")
	public Optional<Vendor> getSingleVendor(@PathVariable("vendorId") String vendorId) {
		return vendorService.getVendorByKey(vendorId);
	}
	
	@PostMapping("/vendors")
	public Vendor createVendor(@RequestBody Vendor myVendorBody) {
		return vendorService.createVendor(myVendorBody);
	}
//	@RequestMapping(method = RequestMethod.PUT, value = "/vendors")
	@PutMapping("/vendors")
	public Vendor updateVendor(Vendor myUpdateVendor) {
		return vendorService.updateVendor(myUpdateVendor);
	}
	
	@DeleteMapping("vendors/{vendorId}")
	public void deleteVendor(@PathVariable String vendorId) {
		vendorService.deleteVendor(vendorId);
	}
	
	//Test using /vendors/search?companyName=SAP
	@GetMapping("/vendors/search")
	public List<Vendor> searchByCompanyName(@RequestParam String companyName){
		
		return vendorService.searchByCompanyName(companyName);
		
	}
	
	//Test by using /vendors/lookup/A
	@GetMapping("/vendors/lookup/{firstName}")
	public List<Vendor> searchByFirstName(@PathVariable("firstName")  String firstName){
		return vendorService.lookupByFirstName(firstName);
	}
	
}
