package com.bookmybanner.services;

import com.bookmybanner.application.exception.types.DatabaseException;
import com.bookmybanner.application.exception.types.ResourceAlreadyExistsException;
import com.bookmybanner.application.exception.types.ResourceNotExistsException;
import com.bookmybanner.models.document.Users;

import java.math.BigInteger;

/**
 * Created by parthaprotimkonwar on 08/04/17.
 */
public interface UserService {

    //register a user
    Users register(Users user) throws DatabaseException, ResourceAlreadyExistsException;

    //user login
    Users login(Users user) throws DatabaseException, ResourceNotExistsException;

    //find a user
    public Users findOne(BigInteger userId) throws DatabaseException;

}
