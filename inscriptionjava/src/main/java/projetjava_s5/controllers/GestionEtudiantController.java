/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava_s5.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import projetjava_s5.entities.Classe;
import projetjava_s5.entities.Etudiant;
import projetjava_s5.entities.Inscription;
import projetjava_s5.service.FunctionController;
import projetjava_s5.service.GestionClasse;
import projetjava_s5.service.GestionInscriptions;

/**
 * FXML Controller class
 *
 * @author BETOE CHARLENE
 */
public class GestionEtudiantController implements Initializable {

    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_prenom;
    @FXML
    private TextField txt_numero;
    @FXML
    private ComboBox<String> cmb_classe_filter;
    @FXML
    private Button btn_ok;
    @FXML
    private ComboBox<String> cmbx_classeFilter;
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
    private Button btn_exit;
    private String nameController=null;
    FunctionController function= new FunctionController();
    @FXML
    private TableColumn<Etudiant, String> tv_num=null;
    @FXML
    private TableColumn<Etudiant, String> tv_name=null;
    @FXML
    private TableColumn<Etudiant, String> tv_prenom=null;
    @FXML
    private TableColumn<Etudiant, String> tv_year=null;
    @FXML
    private TableColumn<Etudiant, String> tvc_classe;
   GestionClasse gc = new GestionClasse();  
   GestionInscriptions gi = new GestionInscriptions();
       private Etudiant etudiant;


    @FXML
    private TableView<Etudiant> tv_stud;
    @FXML
    private TextField txt_tuteur;
    @FXML
    private TextField txt_annee;
    @FXML
    private TextField txt_anneeFilter;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Etudiant> donneeEtudiant = FXCollections.observableArrayList();
        for (Classe classe : gc.listerCLasse()) {
                    cmbx_classeFilter.getItems().add(classe.getLibelle()); 
                    cmb_classe_filter.getItems().add(classe.getLibelle());

        }
    tv_num.setCellValueFactory(new PropertyValueFactory<>("numero"));
    tv_name.setCellValueFactory(new PropertyValueFactory<>("nom"));
    tv_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));  
    tv_year.setCellValueFactory(new PropertyValueFactory<>("year"));
    tvc_classe.setCellValueFactory(new PropertyValueFactory<>("classe"));


    donneeEtudiant.addAll(gi.listerEtudiants());
    tv_stud.setItems(donneeEtudiant);
    tv_stud.refresh();

        // TODO
    }    

    @FXML
    private void handleSearchOk(ActionEvent event) {
    }

    @FXML
    private void handleInscription(ActionEvent event) {
    ObservableList<Etudiant> donneeEtudiant = FXCollections.observableArrayList();
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);

            
            int last_id;
            if(txt_numero == null || txt_nom  == null || txt_prenom  == null || txt_tuteur  == null || txt_annee == null ){
            alert.setContentText("Veuillez entrez des valeurs");
            alert.showAndWait();
            }
            else{
            etudiant= new Etudiant();
            etudiant.setNumero(txt_numero.getText());
            etudiant.setNom(txt_nom.getText());
            etudiant.setPrenom(txt_prenom.getText());    
            etudiant.setTuteur(txt_tuteur.getText());
             int year= Integer.parseInt(txt_annee.getText());
             
             Inscription inscriptions= new Inscription(year);
                System.out.println(inscriptions);
             
            String classe= cmbx_classeFilter.getValue();
            last_id=gi.addInscription(etudiant, inscriptions, classe);
            alert.setContentText("Info Enregisté avec succees "+last_id);
            alert.showAndWait();
            donneeEtudiant.addAll(gi.listerEtudiants());
            tv_stud.setItems(donneeEtudiant);
            tv_stud.refresh();
             
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
