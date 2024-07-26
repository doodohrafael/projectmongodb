package com.rafael.projectmongodb.api;

import com.rafael.projectmongodb.api.request.UserRequestDTO;
import com.rafael.projectmongodb.api.response.UserResponseDTO;
import com.rafael.projectmongodb.business.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserResponseDTO> saveDataUsers(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.saveUser(userRequestDTO));
    }


    @GetMapping()
    public ResponseEntity<UserResponseDTO> getUserByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(userService.getUserData(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam("email") String email) {
        userService.deleteUser(email);
        return ResponseEntity.accepted().build();
    }

}
