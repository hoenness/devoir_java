/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.service;

import projetjava_s5.core.InscriptionDao;
import java.util.ArrayList;
import projetjava_s5.entities.Classe;
import projetjava_s5.entities.Etudiant;
import projetjava_s5.entities.Inscription;

/**
 *
 * @author hp
 */
public class GestionInscriptions implements IGestionInscriptions {


private InscriptionDao inscriptionDao;
    public GestionInscriptions() {
                        inscriptionDao=new InscriptionDao();     
    }

    ArrayList<Inscription> bd= new ArrayList<>();


    @Override
    public Inscription addInscription(Inscription i) {
        bd.add(i);
        return i;
    }
    public int addInscription(Etudiant obj, Inscription obj2, String classe) {
        return inscriptionDao.create(obj, obj2, classe);
    }
    @Override
    public Etudiant rechercherEtudiant(String numero) {
        for(Inscription i: bd){
            if(i.getEtudiant().getNumero().compareTo(numero) ==0 ){
                return i.getEtudiant();
            }
        }
        return null;
    }

    @Override
    public ArrayList<Inscription> listerInscriptions() {
        return bd;
    }

    @Override
    public ArrayList<Inscription> listerInscriptions(int annee) {
        ArrayList<Inscription> resultat = new ArrayList<>();
        for(Inscription i: bd){
            if(i.getAnnee() == annee){
                resultat.add(i);
            }
        }
        
        return resultat;
    }

    @Override
    public ArrayList<Inscription> listerInscriptions(Classe classe) {
        ArrayList<Inscription> resultat = new ArrayList<>();
        for(Inscription i: bd){
            if(i.getClasse()  == classe){
                resultat.add(i);
            }
        }
        
        return resultat;
    }

    @Override
    public ArrayList<Inscription> listerInscriptions(Classe classe, int annee) {
    return null;
   
    }
    public ArrayList<Etudiant> listerEtudiants() {
        return inscriptionDao.selectAll(); 
    }
    
}
