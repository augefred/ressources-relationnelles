package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "etre_affilie")
@IdClass(EtreAffilie.class)
public class EtreAffilie implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "uti_id", insertable = false, updatable = false)
    private Utilisateur UTI_ID;
    @Id
    @OneToOne
    @JoinColumn(name = "uti_id_1")
    private Utilisateur UTI_ID_1;
    @OneToMany
    @JoinColumns({
            @JoinColumn(name = "gro_id"),
            @JoinColumn(name = "uti_id")
    })
    private List<Groupe> GRO_ID;
}
