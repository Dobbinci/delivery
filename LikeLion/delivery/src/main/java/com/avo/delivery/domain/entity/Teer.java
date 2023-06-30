package com.avo.delivery.domain.entity;

import com.avo.delivery.application.dto.TeerDto;
import com.avo.delivery.application.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
/**
 * Entity of Teer*/
public class Teer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teerName;
    private Double rate;

    public static Teer toTeer (TeerDto dto) {
        return Teer.builder()
                .teerName(dto.getTeerName())
                .rate(dto.getRate())
                .build();
    }
}
