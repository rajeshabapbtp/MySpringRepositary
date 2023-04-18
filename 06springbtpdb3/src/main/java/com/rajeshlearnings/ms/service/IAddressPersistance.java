package com.rajeshlearnings.ms.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajeshlearnings.ms.entities.Address;

public interface IAddressPersistance extends JpaRepository<Address, String> {

}
