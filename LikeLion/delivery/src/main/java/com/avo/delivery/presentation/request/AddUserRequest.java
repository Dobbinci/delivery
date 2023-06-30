package com.avo.delivery.presentation.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {

    private String name;
    private Integer age;
    private boolean gender;
    private String email;
    private String contact;
    private Integer teer;
    private Integer zipCode;
    private String address;

}
