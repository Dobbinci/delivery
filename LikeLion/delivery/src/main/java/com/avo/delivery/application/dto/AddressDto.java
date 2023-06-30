package com.avo.delivery.application.dto;

import com.avo.delivery.domain.entity.Address;
import com.avo.delivery.domain.entity.User;
import com.avo.delivery.presentation.request.AddAddressRequest;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {

    private Long id;
    private User user;
    private String address;
    private String addrDetail;
    private Integer zipCode;
    private String name;

    public static AddressDto from (AddAddressRequest request) {
        return AddressDto.builder()
                .address(request.getAddress())
                .addrDetail(request.getAddrDetail())
                .zipCode(request.getZipCode())
                .name(request.getName())
                .build();
    }

    public static AddressDto from (Address address) {
        return AddressDto.builder()
                .address(address.getAddress())
                .addrDetail(address.getAddrDetail())
                .zipCode(address.getZipCode())
                .name(address.getName())
                .build();
    }
}
