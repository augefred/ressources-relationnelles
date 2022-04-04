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

    public Long getROUTI_ID() {
        return ROUTI_ID;
    }

    public void setROUTI_ID(Long ROUTI_ID) {
        this.ROUTI_ID = ROUTI_ID;
    }

    public String getROUTI_Nom() {
        return ROUTI_Nom;
    }

    public void setROUTI_Nom(String ROUTI_Nom) {
        this.ROUTI_Nom = ROUTI_Nom;
    }

    public String getROUTI_Description() {
        return ROUTI_Description;
    }

    public void setROUTI_Description(String ROUTI_Description) {
        this.ROUTI_Description = ROUTI_Description;
    }
}
