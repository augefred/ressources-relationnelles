package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;

@Entity
@Table(name = "groupe")
public class Groupe {
    @Id
    @JoinColumn(name = "uti_id")
    private Utilisateur UTI_ID;
    @Id
    @Column(name = "gro_id")
    private Long GRO_ID;
    @Column(name = "gro_nom")
    private String GRO_Nom;
}
