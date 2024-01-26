package com.esprit.demoproject.repositories;

import com.esprit.demoproject.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface restaurantRepo extends JpaRepository<Restaurant,Long> {
}
