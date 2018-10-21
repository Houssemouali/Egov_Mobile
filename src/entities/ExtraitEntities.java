/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author USER
 */
public class ExtraitEntities {
    String nom,prenom,lieu_naissance,etat,commentaire;
    int id,cin_pere,cin_mere;        
    Date date_naissance;
    
    public  ExtraitEntities(){}

    public ExtraitEntities(String nom, String prenom, String lieu_naissance, int cin_pere, int cin_mere, Date date_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.lieu_naissance = lieu_naissance;
        this.cin_pere = cin_pere;
        this.cin_mere = cin_mere;
        this.date_naissance = date_naissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLieu_naissance() {
        return lieu_naissance;
    }

    public void setLieu_naissance(String lieu_naissance) {
        this.lieu_naissance = lieu_naissance;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCin_pere() {
        return cin_pere;
    }

    public void setCin_pere(int cin_pere) {
        this.cin_pere = cin_pere;
    }

    public int getCin_mere() {
        return cin_mere;
    }

    public void setCin_mere(int cin_mere) {
        this.cin_mere = cin_mere;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }
     public String getFullNames() {
        return nom +" "+prenom+"  "+lieu_naissance +" "+cin_pere+"  "+cin_mere+" "+date_naissance+" ";
    }
}
