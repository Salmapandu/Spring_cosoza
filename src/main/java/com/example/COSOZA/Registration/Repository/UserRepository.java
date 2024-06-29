package com.example.COSOZA.Registration.Repository;

import com.example.COSOZA.Registration.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository <User, Integer> {
}
