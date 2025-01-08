package com.gmontinny.multipleauthapi.controller;

import com.gmontinny.multipleauthapi.model.payload.LoginRequest;
import com.gmontinny.multipleauthapi.model.payload.LoginResponse;
import com.gmontinny.multipleauthapi.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(loginService.login(loginRequest));
    }
}
