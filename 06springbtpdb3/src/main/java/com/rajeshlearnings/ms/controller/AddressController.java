package com.rajeshlearnings.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajeshlearnings.ms.entities.Address;
import com.rajeshlearnings.ms.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressSrv;
	
	@GetMapping("/address")
	public List<Address> getAddress(){
		return addressSrv.getAddress();
	}
	
	@PostMapping("/address")
	public Address createNewAddress(@RequestBody Address payload) {
		return addressSrv.createAddress(payload);
	}
	
}
