/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.service;

import java.util.ArrayList;
import projetjava_s5.entities.Classe;
import projetjava_s5.entities.Detail;
import projetjava_s5.entities.Professeur;

/**
 *
 * @author BETOE CHARLENE
 */
public class ServiceDetail implements IDetail {
    ArrayList<Detail> bd = new ArrayList<>();

    @Override
    public Detail addDetail(Detail d) {
       bd.add(d);
       return d;
    }

    @Override
    public ArrayList<Detail> listerDetail() {
        return bd;
    }

    @Override
    public ArrayList<Professeur> rechercherProf(String classe){
        ArrayList<Professeur> p = new ArrayList<>();
        for(Detail d: bd){
            if(d.getClasse().getLibelle().equals(classe) == true) {
                 p.add(d.getProf());
            }
         }
        if(p.isEmpty()){
           return null;
        }
        else{
        return p;
        }               
    }

    @Override
    public ArrayList<Professeur> rechercherProf(int annee) {
       ArrayList<Professeur> p = new ArrayList<>();
        for(Detail d: bd){
            if(d.getAnnee() == annee) {
                 p.add(d.getProf());
            }
         }
        if(p.isEmpty()){
           return null;
        }
        else{
        return p;
        }
        
        
  
    }

    @Override
    public ArrayList<Professeur> rechercherProf(int annee, String classe) {
        ArrayList<Professeur> p = new ArrayList<>();
        for(Detail d: bd){
            if(d.getAnnee() == annee || d.getClasse().getLibelle().equals(classe) == true) {
                 p.add(d.getProf());
            }
         }
        if(p.isEmpty()){
           return null;
        }
        else{
        return p;
        }
        
        
    }
    
}
