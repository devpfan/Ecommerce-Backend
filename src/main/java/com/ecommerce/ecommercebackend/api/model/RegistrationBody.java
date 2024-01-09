package com.ecommerce.ecommercebackend.api.model;

import lombok.Data;

@Data
public class RegistrationBody {

    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
