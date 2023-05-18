package dev.robvega.driverlicense.service;

import dev.robvega.driverlicense.model.Person;
import dev.robvega.driverlicense.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void create(Person person) {
        personRepository.save(person);
    }

    public List<Person> findByLicenseIsNull() {
        return personRepository.findByLicenseIsNull();
    }

    public List<Person> findByLicenseIsNotNull() {
        return personRepository.findByLicenseIsNotNull();
    }

    public Person findById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        }
        return null;
    }
}
