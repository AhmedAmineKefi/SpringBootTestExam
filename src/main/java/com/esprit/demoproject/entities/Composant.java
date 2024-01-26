package com.esprit.demoproject.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Composant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_composant", nullable = false)
    private Long idComposant;
    private String nomComposant;
    private float prix;

    @ManyToOne
    private Menu menu;

}
