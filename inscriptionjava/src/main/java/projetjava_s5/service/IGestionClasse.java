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
public interface IGestionClasse {
    public Classe addClasse(Classe c);
    public ArrayList<Classe> listerCLasse();

    
}
