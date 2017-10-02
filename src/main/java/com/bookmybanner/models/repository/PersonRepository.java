package com.bookmybanner.models.repository;

import com.bookmybanner.models.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by parthaprotimkonwar on 01/04/17.
 */
@Repository
public interface PersonRepository extends JpaRepository<Persons, Long> {
}
