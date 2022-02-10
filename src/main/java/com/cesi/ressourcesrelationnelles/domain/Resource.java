package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ressources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "seq_post"
    )
    @SequenceGenerator(
            name = "seq_post"
    )
    @Column(name = "RES_ID")
    private long RES_ID;
    @Column(name = "RES_Title")
    private String RES_Title;
    @Column(name = "RES_DatePublication")
    private Date RES_DatePublication;
    @Column(name = "RES_DateModification")
    private Date RES_DateModification;
    @Column(name = "RES_visibilite")
    private boolean RES_Visibilite;
    @Column(name = "RES_RepertoireContenu")
    private String RES_URL;
    @Column(name = "RES_Validation")
    private String RES_Validation;
    @Column(name = "RES_NbVues")
    private String RES_NbVues;
    @Column(name = "CATEG_ID")
    private String CATEG_ID;
    @Column(name = "UTI_ID")
    private String UTI_ID;

    public Resource(){
    }

    public Resource(String titre, Date date, String url) {
        this.RES_Title = titre;
        this.RES_DatePublication = date;
        this.RES_URL = url;
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
}
