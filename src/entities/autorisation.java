/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Vector;

/**
 *
 * @author lenovo
 */
public class autorisation {

    
    private int id;
    private int cin;

   public autorisation() {
    }
    
    

    public autorisation(int cin) {
        this.cin=cin;
    }

    public autorisation(int id, int cin) {
        this.id = id;
        this.cin = cin;
        
    }

    public int getcin() {
        return cin;
    }

    public void setcin(int cin) {
        this.cin = cin;
    }
    
    public int getId() {
        return id;
    }

    

    public void setId(int Id) {
        this.id = Id;
    }

   public String getFullAuto(){
        return ""+cin;
    }
}
