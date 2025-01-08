package com.gmontinny.multipleauthapi.model.payload;

import com.gmontinny.multipleauthapi.model.enums.AuthProvider;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private AuthProvider authProvider;
    private String name;
    private String imageUrl;
}
