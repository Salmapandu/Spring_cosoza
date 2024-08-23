package com.example.COSOZA.Registration.Repository;

import com.example.COSOZA.Registration.Entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    Optional<Artist> findByEmail(String email);
}
