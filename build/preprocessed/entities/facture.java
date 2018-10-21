/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author lenovo
 */
public class facture {
     int cin,Montant,id;
    String Nom, Prenom, Adresse,Etat,Type,PayerAvant;
public facture() {
    }

    public facture(int cin, String Nom, String Prenom, String Adresse, String Type, int Montant, String PayerAvant) {
        this.cin = cin;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse = Adresse;
        this.Type = Type;
        this.Montant = Montant;
        this.PayerAvant = PayerAvant;
    }

    public facture(int id,int cin,String Nom, String Prenom, String Adresse, String Type, int Montant, String PayerAvant) {
        this.id = id;
        this.cin = cin;
         this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse = Adresse;
        this.Type = Type;
        this.Montant = Montant;
        this.PayerAvant = PayerAvant;
    }

    public int getcin() {
        return cin;
    }

    public void setcin(int cin) {
        this.cin = cin;
    }

    public int getMontant() {
        return Montant;
    }

    public void setMontant(int Montant) {
        this.Montant = Montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getPayerAvant() {
        return PayerAvant;
    }

    public void setPayerAvant(String PayerAvant) {
        this.PayerAvant = PayerAvant;
    }

    public String getFullfacture() {
        return "facture{" + "cin=" + cin + ", Montant=" + Montant + ", id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Adresse=" + Adresse + ", Etat=" + Etat + ", Type=" + Type + ", PayerAvant=" + PayerAvant + '}';
    }
    
    
}
