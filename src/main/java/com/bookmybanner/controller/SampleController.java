package com.bookmybanner.controller;

import com.bookmybanner.models.Persons;
import com.bookmybanner.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by parthaprotimkonwar on 01/04/17.
 */
@RestController
public class SampleController {

    @RequestMapping("/hello")
    public String home() {
        return "Hello World!";
    }

    @Autowired
    PersonService personService;


    @RequestMapping("/person/{name}")
    public String addAndDisplayEmployee(@PathVariable String name) {

        System.out.println("Name is :" + name);
        personService.addPersons(name);

        List<Persons> personsList = personService.displayPersons();

        StringBuilder sb = new StringBuilder();

        for(Persons persons : personsList) {
            sb.append(persons.getName()).append(",");
        }

        return sb.toString();
    }
}
