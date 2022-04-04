package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ressources")
public class Ressource {

    @Id
    @Column(name = "res_id")
    private long RES_ID;
    @Column(name = "res_titre")
    private String RES_Title;
    @Column(name = "res_datepublication")
    private Date RES_DatePublication;
    @Column(name = "res_datemodification")
    private Date RES_DateModification;
    @Column(name = "res_visibilite")
    private boolean RES_Visibilite = true;
    @Column(name = "res_repertoirecontenu")
    private String RES_URL;
    @Column(name = "res_validation")
    private boolean RES_Validation = true;
    @Column(name = "res_nbvues")
    private int RES_NbVues;
    @Column(name = "res_archive")
    private boolean RES_Archive;
    @ManyToOne
    @JoinColumn(name = "tr_id")
    private TypeRessources TR_ID;
    @ManyToOne
    @JoinColumn(name = "categ_id")
    private Categories CATEG_ID;
    @ManyToOne
    @JoinColumn(name="uti_id")
    private Utilisateur UTI_ID;

    public Ressource(){
    }

    public Ressource(String titre, Date date, String url) {
        this.RES_Title = titre;
        this.RES_DatePublication = date;
        this.RES_URL = url;
    }

    public Date getRES_DateModification() {
        return RES_DateModification;
    }

    public void setRES_DateModification(Date RES_DateModification) {
        this.RES_DateModification = RES_DateModification;
    }

    public boolean isRES_Visibilite() {
        return RES_Visibilite;
    }

    public void setRES_Visibilite(boolean RES_Visibilite) {
        this.RES_Visibilite = RES_Visibilite;
    }

    public boolean isRES_Validation() {
        return RES_Validation;
    }

    public void setRES_Validation(boolean RES_Validation) {
        this.RES_Validation = RES_Validation;
    }

    public int getRES_NbVues() {
        return RES_NbVues;
    }

    public void setRES_NbVues(int RES_NbVues) {
        this.RES_NbVues = RES_NbVues;
    }

    public long getRES_ID() {
        return RES_ID;
    }

    public void setRES_ID(long RES_ID) {
        this.RES_ID = RES_ID;
    }

    public String getRES_Title() {
        return RES_Title;
    }

    public void setRES_Title(String RES_Title) {
        this.RES_Title = RES_Title;
    }

    public Date getRES_DatePublication() {
        return RES_DatePublication;
    }

    public void setRES_DatePublication(Date RES_DatePublication) {
        this.RES_DatePublication = RES_DatePublication;
    }

    public String getRES_URL() {
        return RES_URL;
    }

    public void setRES_URL(String RES_URL) {
        this.RES_URL = RES_URL;
    }

    public boolean isRES_Archive() {
        return RES_Archive;
    }

    public void setRES_Archive(boolean RES_Archive) {
        this.RES_Archive = RES_Archive;
    }

    public TypeRessources getTR_ID() {
        return TR_ID;
    }

    public void setTR_ID(TypeRessources TR_ID) {
        this.TR_ID = TR_ID;
    }

    public Categories getCATEG_ID() {
        return CATEG_ID;
    }

    public void setCATEG_ID(Categories CATEG_ID) {
        this.CATEG_ID = CATEG_ID;
    }

    public Utilisateur getUTI_ID() {
        return UTI_ID;
    }

    public void setUTI_ID(Utilisateur UTI_ID) {
        this.UTI_ID = UTI_ID;
    }
}
