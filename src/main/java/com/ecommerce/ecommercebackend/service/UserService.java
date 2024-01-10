package com.ecommerce.ecommercebackend.service;

import com.ecommerce.ecommercebackend.api.model.RegistrationBody;
import com.ecommerce.ecommercebackend.exception.UserAlreadyExistEx;
import com.ecommerce.ecommercebackend.model.LocalUser;
import com.ecommerce.ecommercebackend.model.dao.LocalUserDAO;
import jakarta.validation.Valid;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private LocalUserDAO localUserDAO;
    private EncryptionService encryptionService;


    public UserService(LocalUserDAO localUserDAO, EncryptionService encryptionService){

        this.localUserDAO=localUserDAO;
        this.encryptionService = encryptionService;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistEx {
        if(localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUserName()).isPresent()){
            throw new UserAlreadyExistEx();
        }

        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setUsername(registrationBody.getUserName());
        user.setPassword(encryptionService.encrypPassword(registrationBody.getPassword()));
        return localUserDAO.save(user);


    }
}
