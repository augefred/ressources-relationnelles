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

    public Long getTR_ID() {
        return TR_ID;
    }

    public void setTR_ID(Long TR_ID) {
        this.TR_ID = TR_ID;
    }

    public String getTR_Nom() {
        return TR_Nom;
    }

    public void setTR_Nom(String TR_Nom) {
        this.TR_Nom = TR_Nom;
    }
}
