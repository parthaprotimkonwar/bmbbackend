package com.bookmybanner.services;

import com.bookmybanner.models.Persons;

import java.util.List;

/**
 * Created by parthaprotimkonwar on 01/04/17.
 */
public interface PersonService {

    Persons addPersons(String name);

    List<Persons> displayPersons();
}
