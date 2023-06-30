package com.avo.delivery.application.dto;

import com.avo.delivery.domain.entity.Teer;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeerDto {

    private Long id;
    private String teerName;
    private Double rate;

    public static TeerDto from (Integer teer) {
        if (teer == 3) {
            return TeerDto.builder()
                    .teerName("Platinum")
                    .rate(10.0)
                    .build();
        }
        else if (teer == 2) {
            return TeerDto.builder()
                    .teerName("Gold")
                    .rate(8.0)
                    .build();
        }
        else if (teer == 1) {
            return TeerDto.builder()
                    .teerName("Silver")
                    .rate(5.0)
                    .build();
        }
        else {
            return TeerDto.builder()
                    .teerName("Bronze")
                    .rate(3.0)
                    .build();
        }
    }

    public static TeerDto from (Teer teer) {
        return TeerDto.builder()
                .teerName(teer.getTeerName())
                .rate(teer.getRate())
                .build();
    }
}
