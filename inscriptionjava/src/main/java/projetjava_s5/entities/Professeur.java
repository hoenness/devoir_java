/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.entities;

import java.util.ArrayList;

/**
 *
 * @author BETOE CHARLENE
 */
public class Professeur extends Personne{
    public String grade;
    public ArrayList<Detail> details;
    public Professeur() {
    }
    public Professeur(String nom, String prenom, String numero) {
        super(nom, prenom, numero);
        this.category="Professeur";
    }



    /**
     *
     */


    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the classeEns
     */


    /**
     * @return the details
     */
    public ArrayList<Detail> getDetails() {
  
            return details;
        
    }


    /**
     * @param details the details to set
     */
    public void setDetails(ArrayList<Detail> details) {
        this.details = details;
    }
     public String toString() {
        return  "numero= " + numero + " nom=" + nom + " prenom=" + prenom+ " Category = "+getCategory();
    }   


}
