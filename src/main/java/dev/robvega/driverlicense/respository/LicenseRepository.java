package dev.robvega.driverlicense.respository;

import dev.robvega.driverlicense.model.License;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LicenseRepository extends CrudRepository<License, Long> {
    List<License> findAll();
}
