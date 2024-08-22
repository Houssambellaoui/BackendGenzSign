package com.prod.GenZ.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_doc;
    private String intitule;
    private String chemin;
    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL) // This defines the inverse relationship
    @JsonIgnoreProperties({"document"})
    private Set<Signature> signatures;


    public Document() {
    }

    public int getId_doc() {
        return id_doc;
    }

    public void setId_doc(int id_doc) {
        this.id_doc = id_doc;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public Set<Signature> getSignatures() {
        return signatures;
    }

    public void setSignatures(Set<Signature> signatures) {
        this.signatures = signatures;
    }
}
