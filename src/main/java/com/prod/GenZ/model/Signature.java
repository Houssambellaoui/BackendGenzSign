package com.prod.GenZ.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.util.Date;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Signature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_signature;
    private Date date_signature;
    private String date_fin_signature;
    private String signataire;
    private String type_signature;
    private String mailSignataire;

    public String getOrganisme() {
        return organisme;
    }

    public void setOrganisme(String organisme) {
        this.organisme = organisme;
    }

    private String organisme;
    @ManyToOne
    @JoinColumn(name = "document_id") // This column will represent the relationship

    private Document document;





    public Signature() {
    }

    public int getId_signature() {
        return id_signature;
    }

    public void setId_signature(int id_signature) {
        this.id_signature = id_signature;
    }

    public Date getDate_signature() {
        return date_signature;
    }

    public void setDate_signature(Date date_signature) {
        this.date_signature = date_signature;
    }

    public String getDate_fin_signature() {
        return date_fin_signature;
    }

    public void setDate_fin_signature(String date_fin_signature) {
        this.date_fin_signature = date_fin_signature;
    }

    public String getSignataire() {
        return signataire;
    }

    public void setSignataire(String signataire) {
        this.signataire = signataire;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getType_signature() {
        return type_signature;
    }

    public void setType_signature(String type_signature) {
        this.type_signature = type_signature;
    }

    public String getMailSignataire() {
        return mailSignataire;
    }

    public void setMailSignataire(String mailSignataire) {
        this.mailSignataire = mailSignataire;
    }
}
