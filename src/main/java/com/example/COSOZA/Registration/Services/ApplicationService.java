package com.example.COSOZA.Registration.Services;

import com.example.COSOZA.Registration.Entity.Application;
import com.example.COSOZA.Registration.Repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    public void deleteById(int application_id) {
        applicationRepository.deleteById(application_id);
    }

    public Optional<Application> findById(int application_id) {
        return applicationRepository.findById(application_id);
    }

}
