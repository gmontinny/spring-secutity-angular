package com.gmontinny.multipleauthapi.controller;

import com.gmontinny.multipleauthapi.model.payload.UserResponse;
import com.gmontinny.multipleauthapi.security.CurrentUser;
import com.gmontinny.multipleauthapi.security.UserPrincipal;
import com.gmontinny.multipleauthapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return ResponseEntity.ok(userService.getUserInfoById(userPrincipal.getId()));
    }
}
