package com.esprit.demoproject.services;

import com.esprit.demoproject.entities.Client;
import com.esprit.demoproject.entities.Composant;
import com.esprit.demoproject.entities.Menu;
import com.esprit.demoproject.entities.Restaurant;
import com.esprit.demoproject.enums.TypeMenu;
import com.esprit.demoproject.interfaces.allInterface;
import com.esprit.demoproject.repositories.clientRepo;
import com.esprit.demoproject.repositories.composantRepo;
import com.esprit.demoproject.repositories.menuRepo;
import com.esprit.demoproject.repositories.restaurantRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.DoubleStream;

@AllArgsConstructor
@Service
public class allServices implements allInterface {
    private clientRepo clientRepo;
    private composantRepo composantRepo;
    private menuRepo menuRepo;
    private restaurantRepo restaurantRepo;

    @Override
    public Client ajouterClient(Client client) {
        client.setDatePremiereVisite(LocalDate.now());
        return clientRepo.save(client);
    }

    @Override
    public Restaurant ajouterRestaurantEtMenusAssocie(Restaurant restaurant) {
        restaurant.getMenus().stream().forEach(menu -> menu.setPrixTotal(0));
       return restaurantRepo.save(restaurant);
    }

    @Override
    public Menu ajoutComposantsEtMiseAJourPrixTotalMenu(List<Composant> composants, Long idMenu) {
        float sumPrix = (float) (composants.stream().mapToDouble(composant -> composant.getPrix())).sum();
        Menu saveMenu =   menuRepo.findById(idMenu).get();
        if(!(menuRepo.existsById(idMenu))){
                    System.out.println("NO MENU IS PRESENT");
                }
                if (sumPrix>20){
                    System.out.println("SUM IS ABOVE 20DT");
                }else
                {
                saveMenu.setPrixTotal(sumPrix);
                saveMenu.setComposants(composants);
                composants.forEach(composant -> composant.setMenu(saveMenu));
                composantRepo.saveAll(composants);
                }
        return menuRepo.save(saveMenu);

    }

    @Override
    public void affecterClientAuMenu(String identifant, String libelleMenu) {

        Client client1 = clientRepo.findById(Long.valueOf(1203)).get();
        Client client2 = clientRepo.findById(Long.valueOf(1204)).get();
        List<Menu> menu = menuRepo.findMenusByLibelleMenu(libelleMenu);
        client1.setMenus(menu);
        client2.setMenus(menu);
    }

    @Override
    public List<String> libelleMenuParTypeMenuordonneParPrixTotal(TypeMenu typeMenu) {
        return menuRepo.findMenusByTypeMenuOrderByPrixTotalAsc(typeMenu).stream().map(menu -> menu.getTypeMenu().toString()).toList();
    }


}
