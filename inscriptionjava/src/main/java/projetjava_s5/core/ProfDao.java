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
import projetjava_s5.entities.Detail;
import projetjava_s5.entities.Professeur;

/**
 *
 * @author BETOE CHARLENE
 */
public class ProfDao  implements IDao<Professeur, Detail> {
private final String SQL_ALL="SELECT * FROM `person` WHERE `category` = \"Professeur\"";
private final String SQL_INSERT="INSERT INTO `person` (`id`, `firstname`, `lastname`, `category`, `birthday`, `grade`,`tuteur`, `numero`, `statement`) VALUES (NULL, ?,?,\"Professeur\", NULL, ?, NULL, ?,?);";
private final String SQL_INSERT_DETAIL="INSERT INTO `detail` (`id`, `prof_id`, `class_id`, `year`) VALUES (NULL, ?, ?, ?);";
private final String SQL_BY="SELECT * FROM `person` WHERE `category` = \"Professeur\" AND `numero` = ? ";
private final String SQL_BY_FNUP="SELECT * FROM `person` WHERE `category` = \"Professeur\" and `numero` = ? AND `lastname` = ?  ";
private final String SQL_BY_ALL_FIELDS="SELECT * FROM `person` WHERE `category` = \"Professeur\" and `numero` = ? AND `lastname` = ?  and `firstname` = ? ";
private final String SQL_BY_NP="SELECT * FROM `person` WHERE `category` = \"Professeur\" and  firstname = ? AND lastname = ? ";
private final String SQL_BY_NN="SELECT * FROM `person` WHERE `category` = \"Professeur\" and  firstname = ? AND numero = ? ";
private final String SQL_BY_NOM="SELECT * FROM `person` WHERE `category` = \"Professeur\" and firstname = ?";
private final String SQL_BY_NUM="SELECT * FROM `person` WHERE `category` = \"Professeur\" and numero = ?";
private final String SQL_BY_PRENOM="SELECT * FROM `person` WHERE `category` = \"Professeur\" and `lastname` = ? ";
private final String SQL_CLASS_FILTER="SELECT `firstname`, `lastname`, `category`, `grade` , `numero` FROM `person`, `detail` WHERE ? = detail.class_id ";     
private final String SQL_ANNEE_FILTER="SELECT `firstname`, `lastname`, `category`, `grade` , `numero` FROM `person`, `detail` WHERE `year` = ? AND detail.prof_id=person.id";     
private final String SQL_ID="SELECT * FROM `person` WHERE `id` = ? ";
private ClasseDao classeDao;
private MysqlDB mysql;


    public ProfDao() {
        classeDao=new ClasseDao();
        mysql=new MysqlDB();
    }
    @Override
    public int create(Professeur obj) {
         int result=0;
        try {
              mysql.initPS(SQL_INSERT);
              mysql.getPstm().setString(1, obj.getNom());
              mysql.getPstm().setString(2, obj.getPrenom());
              mysql.getPstm().setString(3, obj.getGrade());   
              mysql.getPstm().setString(4, obj.getNumero());  
              mysql.getPstm().setBoolean(5, obj.isStatement());
             //5 Execution de la requete
              mysql.executeMaj();
              //REturn ID client ID
              ResultSet rs=mysql.getPstm().getGeneratedKeys();
              if(rs.first())  result=rs.getInt(1);
             
        } catch (SQLException ex) {
            Logger.getLogger(Professeur.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return result;
    }
    
    //Si le Prof n'existe pas
    public int create(Professeur obj, Detail obj2, String classe) {
        int idPr=this.create(obj);       
                 int result=0;
        try {
              mysql.initPS(SQL_INSERT_DETAIL);
              mysql.getPstm().setInt(1, idPr);
              mysql.getPstm().setInt(2,classeDao.selectBy(classe).getId());
              mysql.getPstm().setInt(3, obj2.getAnnee()); 
             //5 Execution de la requete
              mysql.executeMaj();
              //REturn ID client ID
              ResultSet rs=mysql.getPstm().getGeneratedKeys();
              if(rs.first())  result=rs.getInt(1);    
        } catch (SQLException ex) {
            Logger.getLogger(Detail.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return result;
 } 
@Override
 public int create(Professeur obj, Detail obj2) {
     return 0;
 }
 // Si le prof existe 
 public int create(Detail obj2, Professeur p, String classe) {
    int result=0;
        try {
              mysql.initPS(SQL_INSERT);
              mysql.getPstm().setInt(1, p.getId());
              mysql.getPstm().setInt(2,classeDao.selectBy(classe).getId());
              mysql.getPstm().setInt(3, obj2.getAnnee()); 
              mysql.executeMaj();
              //REturn ID client ID
              ResultSet rs=mysql.getPstm().getGeneratedKeys();
              if(rs.first())  result=rs.getInt(1);
             
        } catch (SQLException ex) {
            Logger.getLogger(Professeur.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return result;
 } 

    @Override
    public boolean update(Professeur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Professeur> selectAll() {
     ArrayList<Professeur> profs=null;
          try {
     profs=new ArrayList<Professeur>(); 
        mysql.initPS(SQL_ALL);       
       ResultSet rs =mysql.executeSelect();
        while(rs.next()){
            Professeur pr= new Professeur();
            pr.setId(rs.getInt("id"));         
            pr.setNom(rs.getString("firstname"));  
            pr.setPrenom(rs.getString("lastname"));   
            pr.setCategory(rs.getString("category"));
            pr.setNumero(rs.getString("numero"));

            profs.add(pr);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
    }
                  return profs;

    }

    @Override
    public Professeur selectById(int id) {
        try {
                mysql.initPS(SQL_ID);
                mysql.getPstm().setInt(1, id);
                ResultSet rs = mysql.executeSelect();
                Professeur pr= new Professeur();
                if(rs.first()){
                    pr.setId(rs.getInt("id"));         
                    pr.setNom(rs.getString("firstname"));   
                    pr.setPrenom(rs.getString("lastname"));     
                    pr.setNumero(rs.getString("numero"));  
                    pr.setGrade(rs.getString("grade"));  
                    pr.setCategory(rs.getString("category"));
                }
                if(pr!=null){
                    return pr;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            }        
    return null;

    }

    @Override
    public Professeur selectBy(String field) {
      try {
                mysql.initPS(SQL_BY);
                mysql.getPstm().setString(1, field);
                ResultSet rs=mysql.executeSelect();
                Professeur pr= new Professeur();
                if(rs.first()){
                    pr.setId(rs.getInt("id"));         
                    pr.setNom(rs.getString("firstname"));   
                    pr.setPrenom(rs.getString("lastname"));     
                    pr.setNumero(rs.getString("numero"));  
                    pr.setGrade(rs.getString("grade"));  
                    pr.setCategory(rs.getString("category"));
                }
                if(pr!=null){
                    return pr;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            }        
    return null;
    }    
     public Professeur selectBy(String field, String Request) {
      try {
                mysql.initPS(Request);
                mysql.getPstm().setString(1, field);
                ResultSet rs=mysql.executeSelect();
                Professeur pr= new Professeur();
                if(rs.first()){
                    pr.setId(rs.getInt("id"));         
                    pr.setNom(rs.getString("firstname"));   
                    pr.setPrenom(rs.getString("lastname"));     
                    pr.setNumero(rs.getString("numero"));  
                    pr.setGrade(rs.getString("grade"));  
                    pr.setCategory(rs.getString("category"));
                }
                if(pr!=null){
                    return pr;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            }        
    return null;
    }
     
    public Professeur selectBy2(String field, String fields2, String Request) {
      try {
                mysql.initPS(Request);
                mysql.getPstm().setString(1, field);  
                mysql.getPstm().setString(2, fields2);
                ResultSet rs=mysql.executeSelect();
                Professeur pr= new Professeur();
                if(rs.first()){
                    pr.setId(rs.getInt("id"));         
                    pr.setNom(rs.getString("firstname"));   
                    pr.setPrenom(rs.getString("lastname"));     
                    pr.setNumero(rs.getString("numero"));  
                    pr.setGrade(rs.getString("grade"));  
                    pr.setCategory(rs.getString("category"));
                }
                if(pr!=null){
                    return pr;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            }        
    return null;
    }


    @Override
    public ArrayList<Professeur> selectBy(int annee) {
        ArrayList<Professeur> profs=null;
          try {
                profs=new ArrayList<Professeur>(); 
                mysql.initPS(SQL_ANNEE_FILTER);
                mysql.getPstm().setInt(1, annee);
                ResultSet rs=mysql.executeSelect();
                while(rs.next()){
                   Professeur pr= new Professeur();
                    pr.setNom(rs.getString("firstname"));   
                    pr.setPrenom(rs.getString("lastname"));     
                    pr.setNumero(rs.getString("numero"));  
                    pr.setGrade(rs.getString("grade"));  
                    pr.setCategory(rs.getString("category"));
                    profs.add(pr);
                }
                return profs;           
            } catch (SQLException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
      return null;
    
    }


    public ArrayList<Professeur>selectByCLasse( String classe) {
    ArrayList<Professeur> profs=null;
          try {
     profs=new ArrayList<Professeur>(); 
                mysql.initPS(SQL_CLASS_FILTER);
                mysql.getPstm().setInt(1, classeDao.selectBy(classe).getId());
                ResultSet rs=mysql.executeSelect();
                while(rs.next()){
                   Professeur pr= new Professeur();
                    pr.setNom(rs.getString("firstname"));   
                    pr.setPrenom(rs.getString("lastname"));     
                    pr.setNumero(rs.getString("numero"));  
                    pr.setGrade(rs.getString("grade"));  
                    pr.setCategory(rs.getString("category"));
                    profs.add(pr);
                }
                return profs;           
            } catch (SQLException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
      return null;
    }

    @Override
    public Professeur selectBy(String numero, String nom, String prenom) {  
        Professeur pr= new Professeur();
        if(numero != null){
        return pr=this.selectBy(numero, SQL_BY_NUM);
        }
        if(prenom != null){
        return pr=this.selectBy(prenom, SQL_BY_PRENOM);
        }
        if(nom != null){
        return pr=this.selectBy(nom, SQL_BY_NOM);
        }
        if(numero != null && nom != null && prenom == null){
        return pr=this.selectBy2(nom,numero, SQL_BY_NN);
        }
        if(numero != null && prenom != null && nom == null ){
        return pr=this.selectBy2(numero,prenom, SQL_BY_FNUP);
        }
        if(prenom != null && nom != null && numero == null ){
        return pr=this.selectBy2(nom,prenom, SQL_BY_NP);
        }
        if(prenom != null && nom != null && numero != null)
        { 
                    try {
                mysql.initPS(SQL_BY);
                mysql.getPstm().setString(1, numero);
                mysql.getPstm().setString(2, prenom);
                mysql.getPstm().setString(3, nom);
                ResultSet rs=mysql.executeSelect();
                if(rs.first()){
                    pr.setId(rs.getInt("id"));         
                    pr.setNom(rs.getString("firstname"));   
                    pr.setPrenom(rs.getString("lastname"));     
                    pr.setNumero(rs.getString("numero"));  
                    pr.setGrade(rs.getString("grade"));  
                    pr.setCategory(rs.getString("category"));
                }
                return pr;
            } catch (SQLException ex) {
                Logger.getLogger(Professeur.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }
    return null;
   }

    
}
