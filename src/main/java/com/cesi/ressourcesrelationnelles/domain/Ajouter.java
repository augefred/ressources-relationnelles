package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ajouter")
@IdClass(Ajouter.class)
public class Ajouter implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "uti_id")
    private Utilisateur UTI_ID;
    @Id
    @OneToOne
    @JoinColumn(name = "res_id")
    private Ressource RES_ID;
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "par_id"),
            @JoinColumn(name = "res_id")
            })
    private Partage PAR_ID;
}
