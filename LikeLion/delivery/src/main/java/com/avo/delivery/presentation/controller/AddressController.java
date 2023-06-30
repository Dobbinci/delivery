package com.avo.delivery.presentation.controller;

import com.avo.delivery.application.dto.AddressDto;
import com.avo.delivery.application.dto.TeerDto;
import com.avo.delivery.application.dto.UserDto;
import com.avo.delivery.application.service.AddressService;
import com.avo.delivery.application.service.TeerService;
import com.avo.delivery.application.service.UserService;
import com.avo.delivery.domain.entity.Address;
import com.avo.delivery.domain.entity.Teer;
import com.avo.delivery.domain.entity.User;
import com.avo.delivery.presentation.request.AddAddressRequest;
import com.avo.delivery.presentation.response.UserAddressInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AddressController {

    @Autowired
    private final AddressService addressService;

    @Autowired
    private final UserService userService;

    /**
     * Add new address data*/
    @PostMapping("/user-address/{id}")
    public ResponseEntity<Long> save (@PathVariable Long id, @RequestBody AddAddressRequest request) {
        User user = userService.getOneUser(id);
        Address address = addressService.addAddress(AddressDto.from(request), user);
        userService.addUserAddressList(id, address);
        return ResponseEntity.ok(address.getId());
    }

}
