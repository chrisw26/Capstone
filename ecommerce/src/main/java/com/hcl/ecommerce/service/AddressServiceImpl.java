package com.hcl.ecommerce.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.AddressDto;
import com.hcl.ecommerce.entity.Address;
import com.hcl.ecommerce.repository.AddressRepository;
import com.hcl.ecommerce.repository.UserRepository;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressRepository addressRepository;

	@Override
	public Address addAddress(Long userId, AddressDto addressDto) {
		
		Address address = new Address();
		
		BeanUtils.copyProperties(addressDto, address);
		
		return addressRepository.save(address);
	}

}
