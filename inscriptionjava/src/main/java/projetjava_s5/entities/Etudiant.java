/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.entities;

/**
 *
 * @author BETOE CHARLENE
 */
public class Etudiant extends Personne{
    
    public String tuteur;

    public Etudiant(String nom, String prenom, String numero) {
        super(nom, prenom, numero);
        this.category="Etudiant";
        
    }

    public Etudiant() {
    }

    /**
     * @return the tuteur
     */
    public String getTuteur() {
        return tuteur;
    }

    /**
     * @param tuteur the tuteur to set
     */
    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }
    
}
