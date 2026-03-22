package edu.nu.owaspapivulnlab.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;

    // VULNERABILITY(API3: Excessive Data Exposure): storing plaintext passwords for demo
    // Students should hash with BCrypt and use proper credential storage.
    @NotBlank
    private String password;

    // VULNERABILITY(API6: Mass Assignment): role and isAdmin are bindable via incoming JSON
    private String role;   // e.g., "USER" or "ADMIN"
    @JsonProperty("isAdmin")
    private boolean isAdmin;

    @Email
    private String email;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
