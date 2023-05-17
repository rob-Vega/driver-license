package dev.robvega.driverlicense.service;

import dev.robvega.driverlicense.model.Person;
import dev.robvega.driverlicense.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void createPerson(Person person) {
        personRepository.save(person);
    }
}
