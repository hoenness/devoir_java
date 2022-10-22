/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.service;

import java.util.ArrayList;
import projetjava_s5.entities.Classe;
import projetjava_s5.entities.Professeur;

/**
 *
 * @author hp
 */
public interface IGestionProf {
    public Professeur rechercherProf(String numero);
    public void addClasse(Professeur p,Classe c,int annee);

    
}
