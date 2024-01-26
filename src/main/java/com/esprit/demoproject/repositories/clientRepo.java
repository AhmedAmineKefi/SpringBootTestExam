package com.esprit.demoproject.repositories;

import com.esprit.demoproject.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clientRepo extends JpaRepository<Client,Long> {
}
