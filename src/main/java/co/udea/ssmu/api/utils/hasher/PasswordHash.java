package co.udea.ssmu.api.utils.hasher;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHash {
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String encriptarPassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }

}