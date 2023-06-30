package com.avo.delivery.application.dto;

import com.avo.delivery.domain.entity.Address;
import com.avo.delivery.domain.entity.Teer;
import com.avo.delivery.domain.entity.User;
import com.avo.delivery.presentation.request.AddUserRequest;
import com.avo.delivery.presentation.request.ReviseUserRequest;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private Teer teer;
    private String name;
    private Integer age;
    private boolean gender;
    private String email;
    private String contact;
    private Integer zipCode;
    private String address;
    private List<Address> addressList = new ArrayList<>();
    public static UserDto from (AddUserRequest request) {
        return UserDto.builder()
                .name(request.getName())
                .age(request.getAge())
                .gender(request.isGender())
                .email(request.getEmail())
                .contact(request.getContact())
                .zipCode(request.getZipCode())
                .address(request.getAddress())
                .build();
    }

    public static UserDto from (ReviseUserRequest request) {
        return UserDto.builder()
                .name(request.getName())
                .age(request.getAge())
                .gender(request.isGender())
                .email(request.getEmail())
                .contact(request.getContact())
                .zipCode(request.getZipCode())
                .address(request.getAddress())
                .build();
    }

    public static UserDto from (User user) {
        return UserDto.builder()
                .name(user.getName())
                .age(user.getAge())
                .gender(user.isGender())
                .email(user.getEmail())
                .contact(user.getContact())
                .zipCode(user.getZipCode())
                .address(user.getAddress())
                .build();
    }
}
