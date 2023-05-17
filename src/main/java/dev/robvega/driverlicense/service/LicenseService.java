package dev.robvega.driverlicense.service;

import dev.robvega.driverlicense.model.License;
import dev.robvega.driverlicense.respository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    public List<License> findAll() {
        return licenseRepository.findAll();
    }

    public void create(License license) {
        licenseRepository.save(license);
    }
}
