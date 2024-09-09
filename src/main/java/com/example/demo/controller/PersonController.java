package com.example.demo.controller;

import com.example.demo.model.entity.Person;
import com.example.demo.model.response.PersonResponse;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        return personService.save(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
    }

    @GetMapping("/emails")
    public List<PersonResponse> getPersonsWithEmailContacts() {
        return personService.findPersonsWithEmailContacts();
    }

    @GetMapping("/native")
    public List<PersonResponse> getPersonsWithEmailContactsNative() {
        return personService.findPersonsWithEmailContactsNative();
    }
}
