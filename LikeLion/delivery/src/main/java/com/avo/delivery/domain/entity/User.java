package com.avo.delivery.domain.entity;

import com.avo.delivery.application.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
/**
 * Entity of User*/
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "teerId")
    private Teer teer;
    private String name;
    private Integer age;
    private boolean gender;
    private String email;
    private String contact;
    private Integer zipCode;
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addressList = new ArrayList<>();

    public void addAddress (Address address) {
        address.setUser(this);
        addressList.add(address);
    }



    public static User toUser (UserDto dto) {
        return User.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .gender(dto.isGender())
                .email(dto.getEmail())
                .contact(dto.getContact())
                .zipCode(dto.getZipCode())
                .address(dto.getAddress())
                .build();
    }
}
