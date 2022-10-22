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
public class Classe {
    private int id;
    private String libelle;
    private boolean statement=true;

    public boolean isStatement() {
        return statement;
    }

    public void setStatement(boolean statement) {
        this.statement = statement;
    }
    
    protected ArrayList<Inscription> inscriptions;

    public Classe(String libelle) {
        this.libelle = libelle;
        
    }

    public Classe() {
    }

    @Override
    public String toString() {
        return  libelle ;
    }
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    
}
