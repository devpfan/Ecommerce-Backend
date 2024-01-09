package com.ecommerce.ecommercebackend.api.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegistrationBody {

    @NotNull
    @NotBlank
    private String userName;
    @NotBlank
    @Email
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    @Min(6)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
    @Max(32)
    private String password;
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    @NotNull
    private String lastName;

}
