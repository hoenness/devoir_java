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
public class Detail {
    protected int annee;
    protected Professeur prof;
    protected Classe classe;

    public Detail(int annee, Professeur prof, Classe classe) {
        this.annee = annee;
        this.prof = prof;
        this.classe = classe;
    }
    public Detail() {

    }
    public Detail(int annee) {

    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Professeur getProf() {
        return prof;
    }

    public void setProf(Professeur prof) {
        this.prof = prof;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
}
