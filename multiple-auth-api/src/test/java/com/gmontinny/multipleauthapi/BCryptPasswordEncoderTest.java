package com.gmontinny.multipleauthapi;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

public class BCryptPasswordEncoderTest {
    @Test
    void givenPassword_whenEncoded_thenVerifyMatch() {
        // Configuração do password encoder
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Senha original
        String rawPassword = "@Pacu2024";

        // Codifica a senha
        String encodedPassword = passwordEncoder.encode(rawPassword);

        System.out.println("Encoded Password: " + encodedPassword);

        // Verifica se a senha codificada não é igual à original (importante para segurança)
        assertThat(encodedPassword).isNotEqualTo(rawPassword);

        // Verifica se a senha codificada corresponde à senha bruta
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
        assertThat(matches).isTrue();
    }

    @Test
    void givenDifferentPassword_whenVerified_thenDoesNotMatch() {
        // Configuração do password encoder
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Senha original e uma senha incorreta
        String rawPassword = "senhaSegura123";
        String wrongPassword = "senhaErrada123";

        // Codifica a senha original
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // Verifica se a senha errada não corresponde
        boolean matches = passwordEncoder.matches(wrongPassword, encodedPassword);
        assertThat(matches).isFalse();
    }
}
