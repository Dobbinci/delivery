package com.avo.delivery.presentation.response;

import com.avo.delivery.application.dto.TeerDto;
import com.avo.delivery.application.dto.UserDto;
import com.avo.delivery.domain.entity.Address;
import com.avo.delivery.domain.entity.Teer;
import com.avo.delivery.domain.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoResponse {

    private String name;
    private Integer age;
    private boolean gender;
    private String email;
    private String contact;
    private String address;
    private Integer zipCode;
    private String teerName;
    private Double rate;

    public static UserInfoResponse from (User user, Teer teer) {
        return UserInfoResponse.builder()
                .name(user.getName())
                .age(user.getAge())
                .gender(user.isGender())
                .email(user.getEmail())
                .contact(user.getContact())
                .address(user.getAddress())
                .zipCode(user.getZipCode())
                .teerName(teer.getTeerName())
                .rate(teer.getRate())
                .build();

    }

    public static UserInfoResponse from (UserDto userDto, TeerDto teerDto) {
        return UserInfoResponse.builder()
                .name(userDto.getName())
                .age(userDto.getAge())
                .gender(userDto.isGender())
                .email(userDto.getEmail())
                .contact(userDto.getContact())
                .address(userDto.getAddress())
                .zipCode(userDto.getZipCode())
                .teerName(teerDto.getTeerName())
                .rate(teerDto.getRate())
                .build();

    }



}
