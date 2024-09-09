package com.example.demo.service;

import com.example.demo.model.entity.Person;
import com.example.demo.model.response.PersonResponse;
import com.example.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    public List<PersonResponse> findPersonsWithEmailContacts() {
        return personRepository.findPersonsWithEmailContacts().stream()
                .map(row -> new PersonResponse(
                        (String) row[0],
                        (Date) row[1],
                        (String) row[2],
                        (String) row[3]
                ))
                .collect(Collectors.toList());

    }

    public List<PersonResponse> findPersonsWithEmailContactsNative() {
        return personRepository.findPersonsWithEmailContactsNative().stream()
                .map(row -> new PersonResponse(
                        (String) row[0],
                        (Date) row[1],
                        (String) row[2],
                        (String) row[3]
                ))
                .collect(Collectors.toList());
    }
}
