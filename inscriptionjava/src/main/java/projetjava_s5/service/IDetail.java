/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.service;

import java.time.LocalDate;
import java.util.ArrayList;
import projetjava_s5.entities.Classe;
import projetjava_s5.entities.Detail;
import projetjava_s5.entities.Professeur;

/**
 *
 * @author BETOE CHARLENE
 */
public interface IDetail {
    public Detail addDetail(Detail d);    
    public  ArrayList<Detail> listerDetail();
    public ArrayList<Professeur> rechercherProf(String classe);   
    public ArrayList<Professeur> rechercherProf(int Annee);   
    public ArrayList<Professeur> rechercherProf(int Annee, String classe);



    
}
