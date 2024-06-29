package com.example.COSOZA.Registration.Repository;

import com.example.COSOZA.Registration.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
