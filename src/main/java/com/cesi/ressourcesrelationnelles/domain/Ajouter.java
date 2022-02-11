package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;

@Entity
@Table(name = "ajouter")
public class Ajouter {
    @Id
    @JoinColumn(name = "uti_id")
    private Utilisateur UTI_ID;
    @Id
    @JoinColumn(name = "res_id")
    private Ressource RES_ID;
    @Id
    @JoinColumn(name = "par_id")
    private Partage PAR_ID;
}
