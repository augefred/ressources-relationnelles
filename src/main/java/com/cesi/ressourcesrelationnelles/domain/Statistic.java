package com.cesi.ressourcesrelationnelles.domain;

public class Statistic {
    private int id;
    private int id_ressource;
    private int nbVues;

    public Statistic() {

    }

    public Statistic(int id, int id_ressource, int nbVues) {
        this.id = id;
        this.id_ressource = id_ressource;
        this.nbVues = nbVues;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_ressource() {
        return id_ressource;
    }

    public void setId_ressource(int id_ressource) {
        this.id_ressource = id_ressource;
    }

    public int getNbVues() {
        return nbVues;
    }

    public void setNbVues(int nbVues) {
        this.nbVues = nbVues;
    }
}
