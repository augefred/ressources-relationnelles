package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

@Entity
@Table(name = "partage")
@IdClass(Partage.class)
public class Partage implements Serializable {
    @Id
    @OneToOne
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
