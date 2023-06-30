package com.avo.delivery.domain.entity;

import com.avo.delivery.application.dto.AddressDto;
import com.avo.delivery.application.dto.TeerDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    private String address;

    private String addrDetail;

    private Integer zipCode;

    private String name;

    public static Address toAddress(AddressDto dto) {
        return Address.builder()
                .address(dto.getAddress())
                .addrDetail(dto.getAddrDetail())
                .zipCode(dto.getZipCode())
                .name(dto.getName())
                .build();
    }
}
