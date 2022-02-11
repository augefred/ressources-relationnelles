package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "mettre_en_favoris")
public class MettreEnFavoris {
    @Id
    @JoinColumn(name = "uti_id")
    private Utilisateur UTI_ID;
    @Id
    @JoinColumn(name = "res_id")
    private Ressource RES_ID;
}
