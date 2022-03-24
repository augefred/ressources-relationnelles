package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Entity
@Table(name = "partage")
@IdClass(value = Partage.PartageId.class)
public class Partage implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "res_id")
    private Ressource RES_ID;
    @Id
    @Column(name = "par_id")
    private Long PAR_ID;
    @Column(name = "par_idindividu")
    private Long PAR_IDIndividu;
    @Column(name = "par_utilisateur")
    private boolean PAR_Utilisateur;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "ajouter",
            joinColumns = { @JoinColumn(name = "par_id"), @JoinColumn(name = "res_id")},
            inverseJoinColumns = { @JoinColumn(name = "uti_id") })
    private List<Utilisateur> UTI_ID;


    public static class PartageId implements Serializable {

        private Long PAR_ID;

        private Long RES_ID;

        public PartageId() {
            super();
        }

        public PartageId(Long partageId, Long res_id) {
            this.PAR_ID = partageId;
            this.RES_ID = res_id;
        }

        public Long getPAR_ID() {
            return PAR_ID;
        }

        public void setPAR_ID(Long PAR_ID) {
            this.PAR_ID = PAR_ID;
        }

        public Long getRES_ID() {
            return RES_ID;
        }

        public void setRES_ID(Long RES_ID) {
            this.RES_ID = RES_ID;
        }
    }

    public Ressource getRES_ID() {
        return RES_ID;
    }

    public void setRES_ID(Ressource RES_ID) {
        this.RES_ID = RES_ID;
    }

    public Long getPAR_ID() {
        return PAR_ID;
    }

    public void setPAR_ID(Long PAR_ID) {
        this.PAR_ID = PAR_ID;
    }

    public Long getPAR_IDIndividu() {
        return PAR_IDIndividu;
    }

    public void setPAR_IDIndividu(Long PAR_IDIndividu) {
        this.PAR_IDIndividu = PAR_IDIndividu;
    }

    public boolean isPAR_Utilisateur() {
        return PAR_Utilisateur;
    }

    public void setPAR_Utilisateur(boolean PAR_Utilisateur) {
        this.PAR_Utilisateur = PAR_Utilisateur;
    }

    public List<Utilisateur> getUTI_ID() {
        return UTI_ID;
    }

    public void setUTI_ID(List<Utilisateur> UTI_ID) {
        this.UTI_ID = UTI_ID;
    }
}
