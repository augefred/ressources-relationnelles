package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mettre_en_favoris")
@IdClass(MettreEnFavoris.class)
public class MettreEnFavoris implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "uti_id")
    private Utilisateur UTI_ID;
    @Id
    @OneToOne
    @JoinColumn(name = "res_id")
    private Ressource RES_ID;
}
