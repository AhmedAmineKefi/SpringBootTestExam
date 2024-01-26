package com.esprit.demoproject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", nullable = false)
    private Long idClient;
    private String identifiant ;
    private LocalDate datePremiereVisite ;

    @ManyToMany
    private List<Menu>menus;

}
