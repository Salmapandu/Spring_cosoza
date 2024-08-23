package com.example.COSOZA.Registration.Repository;

import com.example.COSOZA.Registration.Entity.Licensee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LicenseeRepository extends JpaRepository<Licensee, Integer> {
    Optional<Licensee> findByEmail(String email);
}
