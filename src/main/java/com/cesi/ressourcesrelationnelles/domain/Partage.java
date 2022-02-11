package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;

@Entity
@Table(name = "partage")
public class Partage {
    @Id
    @JoinColumn(name = "res_id")
    private Ressource RES_ID;
    @Id
    @Column(name = "par_id")
    private Long PAR_ID;
    @Column(name = "par_idindividu")
    private Long PAR_IDIndividu;
    @Column(name = "par_utilisateur")
    private boolean PAR_Utilisateur;
}
