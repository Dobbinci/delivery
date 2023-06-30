package com.avo.delivery.presentation.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddAddressRequest {

    private String address;
    private String addrDetail;
    private Integer zipCode;
    private String name;
}
