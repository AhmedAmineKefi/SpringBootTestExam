package com.esprit.demoproject.entities;


import com.esprit.demoproject.enums.TypeMenu;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu", nullable = false)
    private Long idMenu;
    private String libelleMenu ;
    @Enumerated(EnumType.STRING)
    private TypeMenu typeMenu ;
    private float prixTotal ;

    @ManyToMany(mappedBy = "menus")
    private List<Client>clients;

    @OneToMany
    private List<Composant>composants;
}
