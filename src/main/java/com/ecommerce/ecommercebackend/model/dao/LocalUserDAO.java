package com.ecommerce.ecommercebackend.model.dao;

import com.ecommerce.ecommercebackend.model.LocalUser;
import org.springframework.data.repository.CrudRepository;

public interface LocalUserDAO extends CrudRepository<LocalUser, Long> {
}
