/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.service;

import java.util.ArrayList;
import projetjava_s5.entities.Classe;
import projetjava_s5.entities.Etudiant;
import projetjava_s5.entities.Inscription;

/**
 *
 * @author hp
 */
public interface IGestionInscriptions {
public Inscription addInscription(Inscription i);
public ArrayList<Inscription> listerInscriptions();
public Etudiant rechercherEtudiant(String numero);
public ArrayList<Inscription> listerInscriptions(int annee);
public ArrayList<Inscription> listerInscriptions(Classe classe);
public ArrayList<Inscription> listerInscriptions(Classe classe,int annee);





    
    
}
