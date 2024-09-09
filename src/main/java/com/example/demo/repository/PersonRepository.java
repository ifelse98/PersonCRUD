package com.example.demo.repository;

import com.example.demo.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT CONCAT(p.firstName, ' ', p.lastName) AS fullName, p.dateOfBirth AS dateOfBirth, c.contactType AS contactType, c.contactValue AS contactValue " +
            "FROM Person p JOIN p.contacts c " +
            "WHERE c.contactType = 'email'")
    List<Object[]> findPersonsWithEmailContacts();

    @Query(value = "SELECT CONCAT(p.first_name, ' ', p.last_name) AS fullName, p.date_of_birth AS dateOfBirth, c.contact_type AS contactType, c.contact_value AS contactValue " +
            "FROM person p JOIN contact c ON p.id = c.person_id", nativeQuery = true)
    List<Object[]> findPersonsWithEmailContactsNative();
}
