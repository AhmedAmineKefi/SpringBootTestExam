package com.esprit.demoproject.repositories;

import com.esprit.demoproject.entities.Menu;
import com.esprit.demoproject.enums.TypeMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface menuRepo extends JpaRepository<Menu,Long> {
    List<Menu> findMenusByLibelleMenu(String libelleMenu);
    List<Menu> findMenusByTypeMenuOrderByPrixTotalAsc(TypeMenu typeMenu);


}
