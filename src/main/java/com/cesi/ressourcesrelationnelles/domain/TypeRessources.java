package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typeressources")
public class TypeRessources {
    @Id
    @Column(name = "tr_id")
    private Long TR_ID;
    @Column(name = "tr_nom")
    private String TR_Nom;
}
