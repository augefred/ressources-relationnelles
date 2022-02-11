package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roleutilisateur")
public class RoleUtilisateur {
    @Id
    @Column(name = "routi_id")
    private Long ROUTI_ID;
    @Column(name = "routi_nom")
    private String ROUTI_Nom;
    @Column(name = "routi_description")
    private String ROUTI_Description;
}
