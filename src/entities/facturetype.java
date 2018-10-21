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
public class facturetype {
    int STEG,SONEDE,TOTAL;

    public facturetype() {
    }

    public facturetype(int STEG, int SONEDE, int TOTAL) {
        this.STEG = STEG;
        this.SONEDE = SONEDE;
        this.TOTAL = TOTAL;
    }

    

    

    public int getSTEG() {
        return STEG;
    }

    public void setSTEG(int STEG) {
        this.STEG = STEG;
    }

    public int getSONEDE() {
        return SONEDE;
    }

    public void setSONEDE(int SONEDE) {
        this.SONEDE = SONEDE;
    }

    public int getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(int TOTAL) {
        this.TOTAL = TOTAL;
    }

    public String toString() {
        return "facturetype{" + "STEG=" + STEG + ", SONEDE=" + SONEDE + ", TOTAL=" + TOTAL + '}';
    }
 
    
}
