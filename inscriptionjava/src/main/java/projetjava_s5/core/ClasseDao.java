/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetjava_s5.entities.Classe;
import projetjava_s5.entities.Personne;

/**
 *
 * @author BETOE CHARLENE
 */
public class ClasseDao implements IDao<Classe, Personne> {
private final String SQL_ALL="Select * From class ";
private final String SQL_BY="Select * From class where wording = ? ";

    
    private MysqlDB mysql;

    public ClasseDao() {
        mysql=new MysqlDB();
    }

private final String SQL_INSERT="INSERT INTO `class` (`wording`, `statement`) VALUES ( ?, ?);";


    @Override
    public int create(Classe obj) {
       int result=0;
        try {
        mysql.initPS(SQL_INSERT);
        
        mysql.getPstm().setString(1, obj.getLibelle());  
        mysql.getPstm().setBoolean(2, obj.isStatement());
        int rs =mysql.executeMaj();


    } catch (SQLException ex) {
        Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
 
    }

    @Override
    public int create(Classe obj, Personne obj2) {
        throw new UnsupportedOperationException("Vous ne pouvez pas executez cette méthode"); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public boolean update(Classe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Classe> selectAll() {
            ArrayList<Classe> classes=null;
    try {
    classes=new ArrayList<Classe>(); 
        mysql.initPS(SQL_ALL);
       
       ResultSet rs =mysql.executeSelect();
        while(rs.next()){
            Classe cl= new Classe();
            cl.setId(rs.getInt("id"));         
            cl.setLibelle(rs.getString("wording"));
            classes.add(cl);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
    }     
               return classes; 
    }

    @Override
    public Classe selectById(int id) {       
    return null;
    }


    @Override
    public Classe selectBy(String field) {
     Classe cl= new Classe();
        try {
                mysql.initPS(SQL_BY);
                mysql.getPstm().setString(1, field);
                ResultSet rs=mysql.executeSelect();
                if(rs.first()){
                    cl.setId(rs.getInt("id")); 
                    cl.setLibelle(rs.getString("wording"));        
                    }
                return cl;

            } catch (SQLException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            } 
               return cl;         
    }
    @Override
    public  ArrayList<Classe> selectBy(int annee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Classe selectBy(String numero, String classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Classe selectBy(String numero, String nom, String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }}

   