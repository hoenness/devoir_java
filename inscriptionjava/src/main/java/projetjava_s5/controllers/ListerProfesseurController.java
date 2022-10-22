/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.controllers;

import projetjava_s5.core.ClasseDao;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import projetjava_s5.entities.Classe;
import projetjava_s5.entities.Professeur;
import projetjava_s5.service.FunctionController;
import projetjava_s5.service.GestionClasse;
import projetjava_s5.service.GestionProf;

/**
 * FXML Controller class
 *
 * @author BETOE CHARLENE
 */
public class ListerProfesseurController implements Initializable {

    @FXML
    private TextField txt_numeroFilter;
    @FXML
    private Button btn_ok;
    @FXML
    private TableColumn<Professeur, String> tv_nom;
    @FXML
    private TableColumn<Professeur, String> tv_prenom;
    @FXML
    private TableView<Classe> tv_classe;
    @FXML
    private ComboBox<String> cmb_classeFilter;
    @FXML
    private TableView<Professeur> tv_Professeur;
    @FXML
    private TableColumn<Classe, String> tv_classeLibelle;
    private String nameController=null;
    FunctionController function= new FunctionController();

    GestionProf gp=new GestionProf();    
    GestionClasse gc=new GestionClasse();
    ClasseDao classeDao=new ClasseDao();   
    
    @FXML
    private Button btn_home;
    @FXML
    private Button btn_Gestion_Classe;
    @FXML
    private Button btn_GestionProf;
    @FXML
    private Button btn_List_prof;
    @FXML
    private Button btn_G_Etudiant;
    @FXML
    private TextField txt_anneeFilter;
    @FXML
    private Button btn_exit;
    @FXML
    private Button btn_filter;
    




    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ObservableList<Professeur> donneeProfesseur = FXCollections.observableArrayList();
    ObservableList<Classe> donnee = FXCollections.observableArrayList();

    
        for (Classe classe : gc.listerCLasse()) {
                    cmb_classeFilter.getItems().add(classe.getLibelle());
        }
    
    tv_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
    tv_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    tv_classeLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));

    donneeProfesseur.addAll(gp.listerProfs());
    tv_Professeur.setItems(donneeProfesseur);
    tv_Professeur.refresh();
    System.out.println(gc.listerCLasse());
    System.out.println(tv_Professeur.getItems());
    donnee.addAll(gc.listerCLasse());
    tv_classe.setItems(donnee);   
    tv_classe.refresh();


    }    
    @FXML
    private void handleSearchProfesseur(ActionEvent event){
        ObservableList<Professeur> donneeProfesseur = FXCollections.observableArrayList();  
        ObservableList<Classe> donnee = FXCollections.observableArrayList();

        String numero= txt_numeroFilter.getText();
        Professeur resultProf = gp.rechercherProf(numero);
        if(resultProf!=null){
            donneeProfesseur.addAll(resultProf);
            tv_Professeur.setItems(donneeProfesseur);
            tv_Professeur.refresh();
            System.out.println(resultProf);
        }
        
        
        

    }


    @FXML
    private void handleClassFilter(ActionEvent event) {
       ObservableList<Professeur> donneeProfesseur = FXCollections.observableArrayList();
       ObservableList<Classe> donnee = FXCollections.observableArrayList();
       ArrayList<Professeur> pList= new ArrayList<>();
        String classe= cmb_classeFilter.getValue();
        ArrayList<Professeur> resultProf = gp.filterByclasse(classe);
        System.out.println(classeDao.selectBy(classe).getId());
        if(resultProf!=null){
            donneeProfesseur.addAll(resultProf);
            tv_Professeur.setItems(donneeProfesseur);
            tv_Professeur.refresh();
            System.out.println(resultProf);
        
            donnee.add(classeDao.selectBy(classe));
            tv_classe.setItems(donnee);
            tv_classe.refresh();
        } 

    }
    
    @FXML
    private void handleFilterYear(ActionEvent event) {
       ObservableList<Professeur> donneeProfesseur = FXCollections.observableArrayList();
       ArrayList<Professeur> pList= new ArrayList<>();
        int year= Integer.parseInt(txt_anneeFilter.getText());
        ArrayList<Professeur> resultProf = gp.filterByAnnee(year);
        System.out.println(year);
        if(resultProf!=null){
            donneeProfesseur.addAll(resultProf);
            tv_Professeur.setItems(donneeProfesseur);
            tv_Professeur.refresh();
            System.out.println(resultProf);

        } 

    }


    @FXML
    private void handlechangeViewHome(ActionEvent event) throws IOException {
        nameController="Main";
        function.changeViews(btn_home, nameController);
    }

    @FXML
    private void handlechangeViewClasse(ActionEvent event) throws IOException {
         nameController="GestionClasse";
         function.changeViews(btn_Gestion_Classe, nameController);
    }

    @FXML
    private void handleChangeViewProfesseur(ActionEvent event) throws IOException {
         nameController="GestionProfesseur";     
         function.changeViews(btn_GestionProf, nameController);
    }

    @FXML
    private void handleChangeViewListe(ActionEvent event) throws IOException {
         nameController="ListerProfesseur";     
         function.changeViews(btn_List_prof, nameController);
    }

    @FXML
    private void handleChangeViewEtudiant(ActionEvent event) throws IOException {
         nameController="GestionEtudiant";     
         function.changeViews(btn_G_Etudiant, nameController);
    }
    @FXML
    private void handleExit(ActionEvent event) throws IOException {
        function.closeWindow(btn_exit);
    }



    }
    
