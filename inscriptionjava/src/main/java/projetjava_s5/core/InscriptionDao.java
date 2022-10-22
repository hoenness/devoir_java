/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetjava_s5.entities.Etudiant;
import projetjava_s5.entities.Inscription;

/**
 *
 * @author BETOE CHARLENE
 */
public class InscriptionDao implements IDao<Etudiant, Inscription> {
private final String SQL_ALL="SELECT * FROM `person` WHERE `category` = \"Etudiant\"";
private final String SQL_INSERT="INSERT INTO `person` (`id`, `firstname`, `lastname`, `category`, `birthday`, `grade`,`tuteur`, `numero`, `statement`) VALUES (NULL, ?,?,\"Etudiant\", NULL, NULL, ?,?,?);";
private final String SQL_INSERT_DETAIL="INSERT INTO `inscription` (`id`, `year`, `student_id`, `class_id`, `statement`) VALUES (NULL, ? , ? , ? , ?);";
private final String SQL_BY_NN="SELECT * FROM `person` WHERE `category` = \"Professeur\" and  firstname = ? AND numero = ? ";
private final String SQL_BY_NOM="SELECT * FROM `person` WHERE `category` = \"Professeur\" and firstname = ?";
private final String SQL_BY_NUM="SELECT * FROM `person` WHERE `category` = \"Professeur\" and numero = ?";
private ClasseDao classeDao;
private MysqlDB mysql;

    public InscriptionDao() {
        classeDao=new ClasseDao();
        mysql=new MysqlDB();
    }

    @Override
    public int create(Etudiant obj) {
            int result=0;
        try {
              mysql.initPS(SQL_INSERT);
              mysql.getPstm().setString(1, obj.getNom());
              mysql.getPstm().setString(2, obj.getPrenom());
              mysql.getPstm().setString(3, obj.getTuteur());   
              mysql.getPstm().setString(4, obj.getNumero());  
              mysql.getPstm().setBoolean(5, obj.isStatement());
             //5 Execution de la requete
              mysql.executeMaj();
              //REturn ID client ID
              ResultSet rs=mysql.getPstm().getGeneratedKeys();
              if(rs.first())  result=rs.getInt(1);
             
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionDao.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return result;
    }

    public int create(Etudiant obj, Inscription obj2, String classe) {
      int idPr=this.create(obj);       
                 int result=0;
        try {
              mysql.initPS(SQL_INSERT_DETAIL);
              mysql.getPstm().setInt(1, obj2.getAnnee());    
              mysql.getPstm().setInt(2, idPr);
              mysql.getPstm().setInt(3,classeDao.selectBy(classe).getId()); 
              mysql.getPstm().setBoolean(4,obj2.isStatement());

             //5 Execution de la requete
              mysql.executeMaj();
              //REturn ID client ID
              ResultSet rs=mysql.getPstm().getGeneratedKeys();
              if(rs.first())  result=rs.getInt(1);    
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionDao.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return result;
    }
    @Override
    public int create(Etudiant obj, Inscription obj2) {
    return 0;

    }


    @Override
    public boolean update(Etudiant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Etudiant> selectAll() {
     ArrayList<Etudiant> etuds=null;
          try {
     etuds=new ArrayList<Etudiant>(); 
        mysql.initPS(SQL_ALL);       
       ResultSet rs =mysql.executeSelect();
        while(rs.next()){
            Etudiant etud= new Etudiant();
            etud.setId(rs.getInt("id"));         
            etud.setNom(rs.getString("firstname"));  
            etud.setPrenom(rs.getString("lastname"));   
            etud.setCategory(rs.getString("category"));
            etud.setNumero(rs.getString("numero"));
            etuds.add(etud);
        }
    } catch (SQLException ex) {
        Logger.getLogger(InscriptionDao.class.getName()).log(Level.SEVERE, null, ex);
    }
                  return etuds;
    }
    public ArrayList<Integer> selectAllClasse() {
     ArrayList<Etudiant> etuds=null;
          try {
     etuds=new ArrayList<Etudiant>(); 
        mysql.initPS(SQL_ALL);       
       ResultSet rs =mysql.executeSelect();
        while(rs.next()){
            Etudiant etud= new Etudiant();
            etud.setId(rs.getInt("id"));         
            etud.setNom(rs.getString("firstname"));  
            etud.setPrenom(rs.getString("lastname"));   
            etud.setCategory(rs.getString("category"));
            etud.setNumero(rs.getString("numero"));
            
            etuds.add(etud);
        }
    } catch (SQLException ex) {
        Logger.getLogger(InscriptionDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }

    @Override
    public Etudiant selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Etudiant selectBy(String field) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Etudiant> selectBy(int annee) {
    return null;
      }

    @Override
    public Etudiant selectBy(String numero, String classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Etudiant selectBy(String numero, String nom, String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
