package com.avo.delivery.presentation.response;

import com.avo.delivery.application.dto.AddressDto;
import com.avo.delivery.application.dto.TeerDto;
import com.avo.delivery.application.dto.UserDto;
import com.avo.delivery.domain.entity.Address;
import com.avo.delivery.domain.entity.Teer;
import com.avo.delivery.domain.entity.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddressInfoResponse {

    private String name;
    private Integer age;
    private boolean gender;
    private String email;
    private String contact;
    private String address;
    private Integer zipCode;
    private String teerName;
    private Double rate;
    private List<Address> addressList;

    public static UserAddressInfoResponse from (User user, Teer teer) {
        return UserAddressInfoResponse.builder()
                .name(user.getName())
                .age(user.getAge())
                .gender(user.isGender())
                .email(user.getEmail())
                .contact(user.getContact())
                .address(user.getAddress())
                .zipCode(user.getZipCode())
                .teerName(teer.getTeerName())
                .rate(teer.getRate())
                .addressList(user.getAddressList())
                .build();
    }
    public static UserAddressInfoResponse from (UserDto userDto, TeerDto teerDto) {
        return UserAddressInfoResponse.builder()
                .name(userDto.getName())
                .age(userDto.getAge())
                .gender(userDto.isGender())
                .email(userDto.getEmail())
                .contact(userDto.getContact())
                .address(userDto.getAddress())
                .zipCode(userDto.getZipCode())
                .teerName(teerDto.getTeerName())
                .rate(teerDto.getRate())
                .addressList(userDto.getAddressList())
                .build();
    }
}
