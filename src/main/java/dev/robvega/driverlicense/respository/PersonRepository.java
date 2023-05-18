package dev.robvega.driverlicense.respository;

import dev.robvega.driverlicense.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();
    List<Person> findByLicenseIsNull();
    List<Person> findByLicenseIsNotNull();
}
