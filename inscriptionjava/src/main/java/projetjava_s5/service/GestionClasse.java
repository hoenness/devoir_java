/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.service;

import projetjava_s5.core.ClasseDao;
import java.util.ArrayList;
import projetjava_s5.entities.Classe;

/**
 *
 * @author hp
 */
public class GestionClasse {
    private ClasseDao classeDao;

    public GestionClasse() {
                classeDao=new ClasseDao();
    }

    public int addClasse(Classe c) {
        return classeDao.create(c);
    }

    public ArrayList<Classe> listerCLasse() {
        return classeDao.selectAll();
    }

    
}