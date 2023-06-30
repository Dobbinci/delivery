package com.avo.delivery.application.service;


import com.avo.delivery.application.dto.AddressDto;
import com.avo.delivery.application.dto.TeerDto;
import com.avo.delivery.application.dto.UserDto;
import com.avo.delivery.domain.entity.Address;
import com.avo.delivery.domain.entity.Teer;
import com.avo.delivery.domain.entity.User;
import com.avo.delivery.domain.repository.AddressRepository;
import com.avo.delivery.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    @Transactional
    /**
     * Add user data in the repo converting Dto to Entity */
    public Address addAddress (AddressDto dto, User user) {
        Address address = Address.toAddress(dto);
        address.setUser(user);
        Address newAddress = addressRepository.save(address);
        return newAddress;
    }

    @Transactional
    public Address getAddress (Long userId) {
        Address address = addressRepository.findByAllUserId(userId);
        return address;
    }

    @Transactional
    /**
     * Get all of user's address data from repo*/
    public List<AddressDto> getAllAddress () {
        List<Address> addressList = addressRepository.findAll();
        return addressList.stream().map(AddressDto::from).collect(Collectors.toList());
    }
}
