package com.avo.delivery.application.service;

import com.avo.delivery.application.dto.TeerDto;
import com.avo.delivery.application.dto.UserDto;
import com.avo.delivery.domain.entity.Teer;
import com.avo.delivery.domain.entity.User;
import com.avo.delivery.domain.repository.TeerRepository;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class TeerService {

    private final TeerRepository teerRepository;

    /**
     * Add user data in the repo converting Dto to Entity */
    public Long addTeer (TeerDto dto) {
        Teer newTeer = teerRepository.save(Teer.toTeer(dto));
        return newTeer.getId();
    }
    @Transactional
    public Teer getTeer (Long userId) {
        Teer teer = teerRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("No such Teer for the user"));
        return teer;
    }

    @Transactional
    public Teer reviseTeer (Long id, TeerDto updatedDto) {
        Teer teer = teerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No such Teer for the user"));
        teer.setTeerName(updatedDto.getTeerName());
        teer.setRate(updatedDto.getRate());

        return teer;
    }

    @Transactional
    /**
     * Delete teer data from repo*/
    public void deleteTeer (Long id) {
        //find out whether the teer is existed before to delete
        Teer teer = teerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No such Teer for the user"));
        teerRepository.deleteById(id);
    }
    @Transactional
    /**
     * Get all of user's data from repo*/
    public List<TeerDto> getAllTeer () {
        List<Teer> teerList = teerRepository.findAll();
        return teerList.stream().map(TeerDto::from).collect(Collectors.toList());
    }


}
