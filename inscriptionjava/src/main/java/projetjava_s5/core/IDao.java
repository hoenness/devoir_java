/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.core;

import java.util.ArrayList;

/**
 *
 * @author hp
 * @param <T>
 * @param <T1>
 */
public interface IDao<T, T1>{
    
    public int create(T obj);     
    public int create(T obj, T1 obj2);  
    public boolean update(T obj);
    public boolean delete(int id);
    public ArrayList<T> selectAll();
    public T selectById(int id);
    public T selectBy(String field);  
    public ArrayList<T>selectBy(int annee);    
    public T selectBy(String numero, String classe);   
    public T selectBy(String numero, String nom, String prenom); 


  





}
