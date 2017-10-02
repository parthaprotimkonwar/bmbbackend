package com.bookmybanner.services.impl;

import com.bookmybanner.models.Persons;
import com.bookmybanner.models.repository.PersonRepository;
import com.bookmybanner.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by parthaprotimkonwar on 01/04/17.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Persons addPersons(String name) {

        Persons persons = new Persons();
        persons.setName(name);
        return personRepository.save(persons);
    }

    @Override
    public List<Persons> displayPersons() {
        return personRepository.findAll();
    }
}
