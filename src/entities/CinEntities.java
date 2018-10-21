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
public class CinEntities {

   
      String adresse,profession,lieu_creation,photo,empreinte,numcin;
    Date date_creation;
    int id,extrait;
    
    
    
    public CinEntities(){}
    
    public CinEntities(String adresse,String profession,String lieu_creation,String photo,String empreinte,String numcin ,Date date_creation,int extrait){
    this.adresse=adresse;
    this.profession=profession;
    this.photo=photo;
    this.empreinte=empreinte;
     this.numcin=numcin;
     this.date_creation=date_creation;
     this.extrait=extrait;
         }
    
    
     public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getLieu_creation() {
        return lieu_creation;
    }

    public void setLieu_creation(String lieu_creation) {
        this.lieu_creation = lieu_creation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmpreinte() {
        return empreinte;
    }

    public void setEmpreinte(String empreinte) {
        this.empreinte = empreinte;
    }

    public String getNumcin() {
        return numcin;
    }

    public void setNumcin(String numcin) {
        this.numcin = numcin;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExtrait() {
        return extrait;
    }

    public void setExtrait(int extrait) {
        this.extrait = extrait;
    }
    
    //lister
    public String getFullNames() {
        return adresse +" "+profession+"  "+photo +" "+empreinte+"  "+numcin+" "+date_creation+" "+extrait+" ";
    }
    
    /*
    this.adresse=adresse;
    this.profession=profession;
    this.photo=photo;
    this.empreinte=empreinte;
     this.numcin=numcin;
     this.date_creation=date_creation;
     this.extrait=extrait;
    */
}
