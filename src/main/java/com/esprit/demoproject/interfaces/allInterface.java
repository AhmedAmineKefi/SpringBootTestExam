package com.esprit.demoproject.interfaces;

import com.esprit.demoproject.entities.Client;
import com.esprit.demoproject.entities.Composant;
import com.esprit.demoproject.entities.Menu;
import com.esprit.demoproject.entities.Restaurant;
import com.esprit.demoproject.enums.TypeMenu;

import java.awt.*;
import java.util.List;

public interface allInterface {

     Client ajouterClient(Client client);

     Restaurant ajouterRestaurantEtMenusAssocie(Restaurant restaurant);

     Menu ajoutComposantsEtMiseAJourPrixTotalMenu(List<Composant> composants,Long idMenu);

     void affecterClientAuMenu(String identifant,String libelleMenu);

     List<String> libelleMenuParTypeMenuordonneParPrixTotal(TypeMenu typeMenu);



}
