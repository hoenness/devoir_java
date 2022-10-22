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
import projetjava_s5.entities.Classe;
import projetjava_s5.entities.Detail;
import projetjava_s5.entities.Professeur;
import projetjava_s5.service.FunctionController;
import projetjava_s5.service.GestionClasse;
import projetjava_s5.service.GestionProf;

/**
 * FXML Controller class
 *
 * @author BETOE CHARLENE
 */
public class GestionProfesseurController implements Initializable {

    @FXML
    private TableView<Classe> tv_classe;
    @FXML
    private Button btn_enregistrer;
    @FXML
    private ComboBox<String> cmb_classe;
    @FXML
    private TableColumn<Classe, String> tv_libelleClasse;
    GestionProf gp = new GestionProf();   
    GestionClasse gc = new GestionClasse();
    @FXML
    private TextField txt_nom=null;
    @FXML
    private TextField txt_numero=null;
    @FXML
    private TextField txt_prenom=null;
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
    private TextField txt_annee;
    @FXML
    private Button btn_exit;
    private String nameController=null;
    FunctionController function= new FunctionController();
    @FXML
    private Button btn_searchProf;
    private Professeur pr;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             for (Classe classe : gc.listerCLasse()) {
                    cmb_classe.getItems().add(classe.getLibelle());
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

    @FXML
    private void handleSearch(ActionEvent event) {
        Professeur pr= new Professeur();
        pr= gp.rechercherProf(txt_numero.getText(), txt_nom.getText(), txt_prenom.getText());
        if (pr!=null){
        txt_numero.setText(pr.getNumero()); 
        txt_nom.setText(pr.getNom());
        txt_prenom.setText(pr.getPrenom());
    }
    ObservableList<Classe> donnee = FXCollections.observableArrayList();

    }

    @FXML
    private void handleEnregistrer(ActionEvent event) {
        int last_id;
        if (pr==null){
            pr= new Professeur();
            pr.setNumero(txt_numero.getText());
            pr.setNom(txt_nom.getText());
            pr.setPrenom(txt_prenom.getText());
            int year= Integer.parseInt(txt_annee.getText());
            Detail detail= new Detail(year);
            String classe= cmb_classe.getValue();
            last_id=gp.addProfesseur(pr, detail, classe);
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
           alert.setContentText("Info Enregisté avec succees "+last_id);
           alert.showAndWait();
        }
        else{

            int year= Integer.parseInt(txt_annee.getText());
            Detail detail= new Detail(year);
            String classe= cmb_classe.getValue();
            last_id=gp.addProfesseur(detail, pr, classe);     
           Alert alert=new Alert(Alert.AlertType.INFORMATION);
           alert.setContentText("Info Enregisté avec succees "+last_id);
           alert.showAndWait();
        }
    }

    
}
