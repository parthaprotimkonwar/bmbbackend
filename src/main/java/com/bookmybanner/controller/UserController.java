package com.bookmybanner.controller;

import com.bookmybanner.application.constants.ApplicationConstants;
import com.bookmybanner.application.exception.types.DatabaseException;
import com.bookmybanner.application.exception.types.ResourceAlreadyExistsException;
import com.bookmybanner.application.exception.types.ResourceNotExistsException;
import com.bookmybanner.controller.models.User;
import com.bookmybanner.models.document.Users;
import com.bookmybanner.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by parthaprotimkonwar on 08/04/17.
 */
@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public ResponseEntity register(@Valid @RequestBody User user, HttpServletResponse response) throws ResourceAlreadyExistsException, DatabaseException{
        logger.info("Inside register");
        Users users = user.toUsers();
        try {
            users = userService.register(users);
            logger.info("User registration is successful");
        } catch (DatabaseException | ResourceAlreadyExistsException e) {
            throw e;
        }
        response.setHeader(ApplicationConstants.USER_ID, users.getUserId().toString());
        logger.info("Exiting register");
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseEntity login(@Valid @RequestBody User user, HttpServletResponse response) throws ResourceNotExistsException, DatabaseException{

        logger.info("Inside login");
        Users users = user.toUsers();
        try {
            users = userService.login(users);
            logger.info("User login is successful");
        } catch (DatabaseException | ResourceNotExistsException e) {
            throw e;
        }
        response.setHeader(ApplicationConstants.USER_ID, users.getUserId().toString());
        logger.info("Exiting login");
        return new ResponseEntity(HttpStatus.OK);
    }
}
