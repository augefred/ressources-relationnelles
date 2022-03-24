package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "groupe")
@IdClass(Groupe.GroupeId.class)
public class Groupe implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "uti_id")
    private Utilisateur GRO_Admin;
    @Id
    @Column(name = "gro_id")
    private Long GRO_ID;
    @Column(name = "gro_nom")
    private String GRO_Nom;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "etre_affilie",
            joinColumns = { @JoinColumn(name = "gro_id"), @JoinColumn(name = "uti_id_1")},
            inverseJoinColumns = { @JoinColumn(name = "uti_id") })
    private List<Utilisateur> GRO_Uti;

    public static class GroupeId implements Serializable {

        private Long GRO_Admin;

        private Long GRO_ID;

        public GroupeId() {
            super();
        }

        public GroupeId(Long uti_id, Long gro_id) {
            this.GRO_Admin = uti_id;
            this.GRO_ID = gro_id;
        }

        public Long getGRO_Admin() {
            return GRO_Admin;
        }

        public void setGRO_Admin(Long GRO_Admin) {
            this.GRO_Admin = GRO_Admin;
        }

        public Long getGRO_ID() {
            return GRO_ID;
        }

        public void setGRO_ID(Long GRO_ID) {
            this.GRO_ID = GRO_ID;
        }
    }

    public Utilisateur getGRO_Admin() {
        return GRO_Admin;
    }

    public void setGRO_Admin(Utilisateur GRO_Admin) {
        this.GRO_Admin = GRO_Admin;
    }

    public Long getGRO_ID() {
        return GRO_ID;
    }

    public void setGRO_ID(Long GRO_ID) {
        this.GRO_ID = GRO_ID;
    }

    public String getGRO_Nom() {
        return GRO_Nom;
    }

    public void setGRO_Nom(String GRO_Nom) {
        this.GRO_Nom = GRO_Nom;
    }

    public List<Utilisateur> getGRO_Uti() {
        return GRO_Uti;
    }

    public void setGRO_Uti(List<Utilisateur> GRO_Uti) {
        this.GRO_Uti = GRO_Uti;
    }
}
