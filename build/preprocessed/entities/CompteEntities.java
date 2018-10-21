/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author USER
 */
public class CompteEntities {

   

 
    int id,montant,cin;
    String num_compte;
   
    
       public int getId() {
        return id;
    }

    public int getMontant() {
        return montant;
    }

    public int getCin() {
        return cin;
    }

    public String getNum_compte() {
        return num_compte;
    }
    
     public CompteEntities(int montant, int cin, String num_compte) {
        this.montant = montant;
        this.cin = cin;
        this.num_compte = num_compte;
    }
    
     public String getFullNames() {
        return montant +" "+cin+"  "+num_compte+" ";
    }
     
}
