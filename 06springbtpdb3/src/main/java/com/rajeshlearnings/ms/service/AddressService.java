package com.rajeshlearnings.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rajeshlearnings.ms.entities.Address;

@Component
public class AddressService {

	@Autowired
	IAddressPersistance address;
	
	public List<Address> getAddress(){
		return address.findAll();
	}
	
	public Address createAddress(Address payload) {
		return address.save(payload);
	}
	
}
