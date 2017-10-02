package com.bookmybanner.services.impl;

import com.bookmybanner.application.exception.ErrorConstants;
import com.bookmybanner.application.exception.types.DatabaseException;
import com.bookmybanner.application.exception.types.ResourceAlreadyExistsException;
import com.bookmybanner.application.exception.types.ResourceNotExistsException;
import com.bookmybanner.models.document.Users;
import com.bookmybanner.models.repository.UsersRepository;
import com.bookmybanner.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * Created by parthaprotimkonwar on 08/04/17.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UsersRepository usersRepository;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class.getName());

    @Override
    public Users register(Users user) throws DatabaseException, ResourceAlreadyExistsException {

        Users theUser = null;
        try {
            theUser = usersRepository.findUsersByEmail(user.getEmail());
            if (null != theUser) {
                logger.error("User with Email: {} already exist", user.getEmail());
                ErrorConstants error = ErrorConstants.USER_ALREADY_EXIST;
                throw new ResourceAlreadyExistsException(error.getErrorCode(), error.getErrorMessage());
            }
            theUser = usersRepository.save(user);
        } catch (Exception ex) {
            logger.error("Exception while registering users with email: {} ", theUser.getEmail());
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new DatabaseException(error.getErrorCode(), error.getErrorMessage());
        }
        return theUser;
    }

    @Override
    public Users login(Users user) throws DatabaseException, ResourceNotExistsException {

        Users theUser = null;
        try {
            theUser = usersRepository.findUsersByEmailAndPassword(user.getEmail(), user.getPassword());
            if (theUser == null) {
                ErrorConstants error = ErrorConstants.INVALID_LOGIN;
                throw new ResourceNotExistsException(error.getErrorCode(), error.getErrorMessage());
            }
        } catch (Exception ex) {
            logger.error("Exception while user login with email: {} ", theUser.getEmail());
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new DatabaseException(error.getErrorCode(), error.getErrorMessage());
        }
        return theUser;
    }

    @Override
    public Users findOne(BigInteger userId) throws DatabaseException {
        return usersRepository.findOne(userId);
    }


}
