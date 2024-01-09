package com.ecommerce.ecommercebackend.service;

import com.ecommerce.ecommercebackend.api.model.RegistrationBody;
import com.ecommerce.ecommercebackend.model.LocalUser;
import com.ecommerce.ecommercebackend.model.dao.LocalUserDAO;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private LocalUserDAO localUserDAO;

    public UserService(LocalUserDAO localUserDAO){
        this.localUserDAO=localUserDAO;
    }

    public LocalUser registerUser(RegistrationBody registrationBody){
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setUsername(registrationBody.getUserName());

        //TODO: encriptar password
        user.setPassword(registrationBody.getPassword());
        return localUserDAO.save(user);


    }
}
