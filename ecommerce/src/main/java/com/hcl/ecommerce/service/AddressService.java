package com.hcl.ecommerce.service;

import com.hcl.ecommerce.dto.AddressDto;
import com.hcl.ecommerce.entity.Address;

public interface AddressService {

	Address addAddress(Long userId, AddressDto addressDto);

}
