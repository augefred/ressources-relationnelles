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
}
