package com.example.COSOZA.Registration.Repository;

import com.example.COSOZA.Registration.Entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}
