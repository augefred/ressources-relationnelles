package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "lier")
public class Lier {
    @Id
    @JoinColumn(name = "res_id")
    private Ressource RES_ID;
    @Id
    @JoinColumn(name = "tr_id")
    private TypeRessources TR_ID;
}
