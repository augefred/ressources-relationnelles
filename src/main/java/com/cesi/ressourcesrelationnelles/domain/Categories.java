package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @Column(name = "categ_id")
    private Long CATEG_ID;
    @Column(name = "categ_nom")
    private String CATEG_NOM;

    public Long getCATEG_ID() {
        return CATEG_ID;
    }

    public void setCATEG_ID(Long CATEG_ID) {
        this.CATEG_ID = CATEG_ID;
    }

    public String getCATEG_NOM() {
        return CATEG_NOM;
    }

    public void setCATEG_NOM(String CATEG_NOM) {
        this.CATEG_NOM = CATEG_NOM;
    }
}
