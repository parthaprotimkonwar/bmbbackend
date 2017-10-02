package com.bookmybanner.models.repository;

import com.bookmybanner.models.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by parthaprotimkonwar on 02/04/17.
 */
@Repository
public interface UsersRepository extends MongoRepository<Users, BigInteger> {

    Users findUsersByEmail(String email);

    Users findUsersByEmailAndPassword(String email, String password);

}
