package com.example.COSOZA.Registration.Repository;

import com.example.COSOZA.Registration.Entity.Licensee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseeRepository extends JpaRepository<Licensee, Integer> {
}
