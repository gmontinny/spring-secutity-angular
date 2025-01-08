package com.gmontinny.multipleauthapi.service;

import com.gmontinny.multipleauthapi.model.entity.User;
import com.gmontinny.multipleauthapi.model.payload.UserResponse;
import com.gmontinny.multipleauthapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse getUserInfoById(Long id) {
        log.debug("Getting user info by id: {}", id);

        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: %s.".formatted(id)));

        return UserMapper.mapToUserResponse(user);
    }
}
