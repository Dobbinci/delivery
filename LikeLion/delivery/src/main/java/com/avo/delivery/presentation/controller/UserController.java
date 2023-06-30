package com.avo.delivery.presentation.controller;

import com.avo.delivery.application.dto.TeerDto;
import com.avo.delivery.application.dto.UserDto;
import com.avo.delivery.application.service.TeerService;
import com.avo.delivery.application.service.UserService;
import com.avo.delivery.domain.entity.Teer;
import com.avo.delivery.domain.entity.User;
import com.avo.delivery.presentation.request.AddUserRequest;
import com.avo.delivery.presentation.request.ReviseUserRequest;
import com.avo.delivery.presentation.response.UserAddressInfoResponse;
import com.avo.delivery.presentation.response.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;
    @Autowired
    private final TeerService teerService;

    /**
     * Add new user data*/
    @PostMapping("/user")
    public ResponseEntity<Long> save (@RequestBody AddUserRequest request) {
        Long savedId = userService.addUser(UserDto.from(request));
        Long teerId = teerService.addTeer(TeerDto.from(request.getTeer()));

        return ResponseEntity.ok(savedId);
    }

    @GetMapping("/show/{num}")
    public ResponseEntity<Integer> show (@PathVariable Integer num) {
        Integer result = num+1;
        return ResponseEntity.ok(result);
    }
    /**
     * Get one user's data*/
    @GetMapping("/user/{id}")
    public ResponseEntity<UserInfoResponse> getOneUser (@PathVariable Long id) {
        User user = userService.getOneUser(id);
        Teer teer = teerService.getTeer(id);
        return ResponseEntity.ok(UserInfoResponse.from(user, teer));
    }
    /**
     * Revise user's data*/
    @PatchMapping("/user")
    public ResponseEntity<UserInfoResponse> reviseUser (@RequestParam(value = "id", required = false) Long id,
                                            @RequestBody ReviseUserRequest request) {
        User updatedUser = userService.reviseUser(id, UserDto.from(request));
        Teer updatedTeer = teerService.reviseTeer(id, TeerDto.from(request.getTeer()));
        return ResponseEntity.ok(UserInfoResponse.from(updatedUser, updatedTeer));

    }
    /**
     * Delete user's data*/
    @DeleteMapping("/user")
    public ResponseEntity<Integer> deleteUser (@RequestParam(value = "id", required = false) Long id) {
        try {
            userService.deleteUser(id);
            teerService.deleteTeer(id);
            return ResponseEntity.ok(1);
        }
        catch (Exception e){
            return ResponseEntity.ok(0);
        }
    }
    @GetMapping("/all-user")
    /**
     *Get All of user's data*/
    public ResponseEntity<List<UserInfoResponse>> getAllUserList() {
        List<UserDto> userDtoList = userService.getAllUser();
        List<TeerDto> teerDtoList = teerService.getAllTeer();

        List<UserInfoResponse> response = new ArrayList<>();
        for (int i = 0; i < userDtoList.size(); i++) {
            UserDto userDto = userDtoList.get(i);
            TeerDto teerDto = teerDtoList.get(i);
            response.add(UserInfoResponse.from(userDto, teerDto));
        }

        return ResponseEntity.ok(response);
    }
    /**
     * Get user's data and address*/
    @GetMapping("/user-address")
    public ResponseEntity<UserAddressInfoResponse> getOneUserWithAddress (@RequestParam(value = "id") Long id) {
        User user = userService.getOneUser(id);
        Teer teer = teerService.getTeer(id);
        return ResponseEntity.ok(UserAddressInfoResponse.from(user, teer));
    }

    /**
     *Get all the address' data*/
    @GetMapping("/all-user-address")
    public ResponseEntity<List<UserAddressInfoResponse>> getAllUserWithAddress() {
        List<UserDto> userDtoList = userService.getAllUser();
        List<TeerDto> teerDtoList = teerService.getAllTeer();
        List<UserAddressInfoResponse> response = new ArrayList<>();

        for (int i = 0; i < userDtoList.size(); i++) {
            UserDto userDto = userDtoList.get(i);
            TeerDto teerDto = teerDtoList.get(i);
            response.add(UserAddressInfoResponse.from(userDto, teerDto));
        }

        return ResponseEntity.ok(response);
    }
}
