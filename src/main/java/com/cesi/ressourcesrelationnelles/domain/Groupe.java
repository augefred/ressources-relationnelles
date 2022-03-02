package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "groupe")
@IdClass(Groupe.class)
public class Groupe implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "uti_id")
    private Utilisateur UTI_ID;
    @Id
    @Column(name = "gro_id")
    private Long GRO_ID;
    @Column(name = "gro_nom")
    private String GRO_Nom;
}
