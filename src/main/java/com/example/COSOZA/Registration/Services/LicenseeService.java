package com.example.COSOZA.Registration.Services;

import com.example.COSOZA.Registration.Entity.Licensee;
import com.example.COSOZA.Registration.Repository.LicenseeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class LicenseeService {

    @Autowired
    private PasswordService passwordService;

    @Autowired

    private LicenseeRepository licenseeRepository;

    public Licensee saveLicensee(Licensee licensee){

        return licenseeRepository.save(licensee);

    }

    public List<Licensee> findAll() {
        return licenseeRepository.findAll();
    }

    public Licensee save(Licensee licensee) {
        // Check if the staff member already exists based on a unique identifier
        Optional<Licensee> existingLicensee = licenseeRepository.findByEmail(licensee.getEmail());

        if (existingLicensee.isPresent()) {
            throw new RuntimeException();
        }

        // Encode the password before saving
        licensee.setPassword(passwordService.encodePassword(licensee.getPassword()));

        return licenseeRepository.save(licensee);
    }

    public void deleteById(int licensee_id) {
        licenseeRepository.deleteById( licensee_id);
    }
    public Optional<Licensee> findById(int  licensee_id) {
        return licenseeRepository.findById( licensee_id);
    }

}
