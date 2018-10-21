/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.Date;

/**
 *
 * @author iheb
 */
public class Extrait_Naissance {
        String nom, prenom, etat, commentaire, lieu;
    String cin_pere,cin_mere;

    int num_extrait;
     public Extrait_Naissance() {
    }

    public Extrait_Naissance(String nom,String prenom,String etat,String commentaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.etat = etat;
        this.commentaire=commentaire;
        
       
    //this.datenaissance = datenaissance;
    }


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEtat() {
        return etat;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public String getLieu() {
        return lieu;
    }

    public String getCin_pere() {
        return cin_pere;
    }

    public String getCin_mere() {
        return cin_mere;
    }

   /* public String getDatenaissance() {
        return datenaissance;
    }*/

    public int getNum_extrait() {
        return num_extrait;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setCin_pere(String cin_pere) {
        this.cin_pere = cin_pere;
    }

    public void setCin_mere(String cin_mere) {
        this.cin_mere = cin_mere;
    }

    /*public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }
*/
    public void setNum_extrait(int num_extrait) {
        this.num_extrait = num_extrait;
    }

    public String getFullName() {
        return  "nom=" + nom + ", prenom=" + prenom + ", etat=" + etat + ", commentaire=" + commentaire ;
    }


  

   

  
   
    /* public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }
*/
     

    
   
    
}
