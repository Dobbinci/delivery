package com.avo.delivery.application.service;

import com.avo.delivery.application.dto.UserDto;
import com.avo.delivery.domain.entity.Address;
import com.avo.delivery.domain.entity.User;
import com.avo.delivery.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    @Transactional
    /**
     * Add user data in the repo converting Dto to Entity */
    public Long addUser (UserDto dto) {
        User newUser = userRepository.save(User.toUser(dto));
        return newUser.getId();
    }
    @Transactional
    /**
     * Add user data in the repo converting Dto to Entity */
    public void addUserAddressList (Long id, Address address) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No such user"));
        user.addAddress(address);
    }

    @Transactional
    /**
     * Get one user's data*/
    public User getOneUser (Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("No such user"));
        return user;
    }

    @Transactional
    /**
     * Revise user's data in repo*/
    public User reviseUser (Long id, UserDto updatedDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No such user"));
        user.setName(updatedDto.getName());
        user.setAge(updatedDto.getAge());
        user.setGender(updatedDto.isGender());
        user.setEmail(updatedDto.getEmail());
        user.setContact(updatedDto.getContact());
        user.setZipCode(updatedDto.getZipCode());
        user.setAddress(updatedDto.getAddress());

        return user;
    }

    @Transactional
    /**
     * Delete user's data from repo*/
    public void deleteUser (Long id) {
        //find out whether the user is existed before to delete
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No such user"));
        userRepository.deleteById(id);
    }

    @Transactional
    /**
     * Get all of user's data from repo*/
    public List<UserDto> getAllUser () {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserDto::from).collect(Collectors.toList());
    }
}
