package com.esprit.demoproject.controllers;

import com.esprit.demoproject.entities.Client;
import com.esprit.demoproject.entities.Composant;
import com.esprit.demoproject.entities.Menu;
import com.esprit.demoproject.entities.Restaurant;
import com.esprit.demoproject.interfaces.allInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/all")
public class allController {

    private allInterface interfaces;

    @PostMapping("addClient")
    public Client addClient(@RequestBody Client client){

        return interfaces.ajouterClient(client);
    }
    @PostMapping("addRestoMenu")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){
        return interfaces.ajouterRestaurantEtMenusAssocie(restaurant);
    }
    @PostMapping("affectClient")
    public void affecterClient(@RequestParam String identifiant,@RequestParam String libelleMenu){
         interfaces.affecterClientAuMenu(identifiant,libelleMenu);
    }
    @PostMapping("ajouterComposant")
    public Menu affecterClient(@RequestBody List<Composant> composants,Long idMenu){
        return interfaces.ajoutComposantsEtMiseAJourPrixTotalMenu(composants, idMenu);
    }



}
