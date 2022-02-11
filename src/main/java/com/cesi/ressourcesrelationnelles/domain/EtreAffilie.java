package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;

@Entity
@Table(name = "etre_affilie")
public class EtreAffilie {
    @Id
    @JoinColumn(name = "uti_id")
    private Utilisateur UTI_ID;
    @Id
    @JoinColumn(name = "uti_id_1")
    private Utilisateur UTI_ID_1;
    @JoinColumn(name = "gro_id")
    private Groupe GRO_ID;
}
