package com.esprit.demoproject.repositories;

import com.esprit.demoproject.entities.Composant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface composantRepo extends JpaRepository<Composant,Long> {
}
