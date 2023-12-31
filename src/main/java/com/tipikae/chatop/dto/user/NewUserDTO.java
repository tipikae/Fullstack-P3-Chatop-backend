package com.tipikae.chatop.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * New user DTO.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDTO {

    @Email(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Email must have an email format.")
    @NotBlank(message = "Email must not be blank.")
    @Size(max = 255,message = "Email length must be less than 255 characters.")
    private String email;

    @Size(min = 3, max = 255,message = "Name length must be between 3 and 255 characters.")
    @NotBlank(message = "Name must not be blank.")
    private String name;

    @Size(min = 3, max = 255, message = "Password length must be between 3 and 255 characters.")
    @NotBlank(message = "Password must not be blank.")
    private String password;
}
