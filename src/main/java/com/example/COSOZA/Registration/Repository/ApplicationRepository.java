package com.example.COSOZA.Registration.Repository;

import com.example.COSOZA.Registration.Entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
}
