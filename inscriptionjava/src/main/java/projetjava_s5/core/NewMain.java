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
import projetjava_s5.entities.Professeur;
import projetjava_s5.entities.Detail;


/**
 *
 * @author BETOE CHARLENE
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    private final String SQL_ALL="SELECT * FROM `class`";
private final String SQL_INSERT="INSERT INTO `class` (`wording`, `statement`) VALUES ( ?, ?);";
private final String SQL_BY="SELECT * FROM `person` WHERE `category` = \"Professeur\" AND `numero` = ? ";
private final String SQL_BY_FNUP="SELECT * FROM `person` WHERE `category` = \"Professeur\" and `numero` = ? AND `lastname` = ?  ";
private final String SQL_BY_ALL_FIELDS="SELECT * FROM `person` WHERE `category` = \"Professeur\" and `numero` = ? AND `lastname` = ?  and `firstname` = ? ";
private final String SQL_BY_NP="SELECT * FROM `person` WHERE `category` = \"Professeur\" and `firstname` = ? AND `lastname` = ? ";
private final String SQL_BY_NN="SELECT * FROM `person` WHERE `category` = \"Professeur\" and `firstname` = ? AND `numero` = ? ";
private final String SQL_BY_NOM="SELECT * FROM `person` WHERE `category` = \"Professeur\" and `firstname` = ?";
private final String SQL_BY_NUM="SELECT * FROM `person` WHERE `category` = \"Professeur\" and `numero` = ?";
private final String SQL_BY_PRENOM="SELECT * FROM `person` WHERE `category` = \"Professeur\" and `lastname` = ? ";
private MysqlDB mysql;


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
     Classe cl= new Classe("Mae");     
     Detail detail= new Detail(2017, null, cl);
     System.out.println(detail.getClasse().getId());


     

    }
}
        
       


    

